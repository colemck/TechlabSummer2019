package sheepsaver;

import apcs.Window;

public class Sheep {
	
	int x = Window.random(Window.width()/2 - 100, Window.width()/2 + 100);
	int y = Window.random(Window.height()/2 - 100, Window.height()/2 + 100);
	int dx = 1;
	int dy = 1;
	int radius = 15;
	int randomness = Window.random(35, 60);
	int splash = -30;
	
	Sheep(){
		if(Window.flipCoin()){
			dx = -dx;
		}
		if(Window.flipCoin()){
			dy = -dy;
		}
	}
	
	
	
	private void fall(){
		
		//first point: center of the screen
		int mx = Window.width()/2;
		int my = Window.height()/2;
		
		double diffx = x - mx;
		double diffy = y - my;
		double dist = Math.sqrt(diffx * diffx + diffy * diffy);
		
		//If sheep is off the island
		if(dist > Window.width()/3 + radius && radius > -40){
			//fall
			radius -= 6;
			
			
			
			if(splash < 17 && splash > -32){
				splash += 6;
			}else{
				splash = -33;
			}
		}
		
		
	}
	
	public void eat(Grass g){
		double diffx = -x + g.x;
		double diffy = -y + g.y;
		double dist = Math.sqrt(diffx * diffx + diffy * diffy);
		if(!g.eaten){	
			if (dist < 70) {
				dx = (int) diffx/8;
				dy = (int) diffy /8;
			}

			if (dist < 20) {
				System.out.println("eating");
				g.energy--;
			}
			if (g.energy == 0) {
				radius++;
				g.eaten = true;
			}
		}
		
	}
	
	public void move(){
        x += dx;
        y += dy;
        
        dx = choose(dx);
        dy = choose(dy);
        this.fall();
    }
	public int choose(int dir){
		if(Window.rollDice(randomness) == 1){
			if(Window.flipCoin()){
				dir = -2;
			}else{
				dir = 2;
			}
		}
		
		if(Window.rollDice(randomness/2) == 1){
			if(Window.flipCoin()){
				dir = -1;
			}else{
				dir = 1;
			}
		}
		
		return dir;
	}
	
	
	public void draw(){
		
		//ears
		Window.out.color("moccasin");
		Window.out.oval(x - radius/2 - 2, y - radius/2, radius, radius);
		Window.out.oval(x + radius/2 + 2, y - radius/2, radius, radius);
		
		Window.out.color("ivory");
		Window.out.circle(x, y, radius + 1);
		
		Window.out.color("papaya whip");
		Window.out.circle(x, y, radius - radius/3);
		
		Window.out.color("black");
		Window.out.circle(x - radius/2, y - 2, radius / 5 );
		Window.out.circle(x + radius/2, y - 2, radius / 5 );
		
		//splash
		Window.out.color("light blue");
		Window.out.circle(x, y, splash);
		
		
	}
	

}
