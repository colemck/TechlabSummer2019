package oceansim;

import apcs.Window;

public class Clownfish extends Organism{

	
	int w = Window.random(17, 30);
	int h = Window.random(10, 20);
	
	int r = Window.random(0, 255);
	int g = Window.random(0, 255);
	int b = Window.random(0, 255);
	
	
	int dx = Window.random(2, 4);
	int dy = Window.random(0, 1);
	int ow = w;
	int bound = Window.random(1, 3);
	int angle = 1;
	
	
	
	@Override
	public void draw() {
		
		Window.out.color(r, g, b);
		Window.out.oval(x, y, w, h);
		Window.out.color("black");
		if(dx > 0) {
			Window.out.circle(x + w/3, y - 2, 2);
			Window.out.color("red");
			Window.out.oval(x + w/2, y, 4, 8);
			
			Window.out.color(r, g, b);
			Window.out.polygon(x - w/2 - 4, y - 6, x - w/2 - 4, y + 6, x - w/2, y);
		}else {
			Window.out.circle(x - w/3, y - 2, 2);
			Window.out.color("red");
			Window.out.oval(x - w/2, y, 4, 8);
			Window.out.color(r, g, b);
			Window.out.polygon(x + w/2 + 4, y - 6, x + w/2 + 4, y + 6, x + w/2, y);
		}
		
		
		w -= angle;
		if(w < ow - bound || w > ow) angle = -angle;
		
		
		
	}

	@Override
	public void move() {
		
		x = x + dx;
		y = y + dy;
		
		if(x > Window.width() || x < 0) {
			dx = -dx;
		}
		if(y > Window.height() || y < 0) {
			dy = -dy;
		}
		
		dx = this.choose(dx);
		dy = this.choose(dy);
	
	}

	private int choose(int dir) {
		
		if(Window.rollDice(50) == 1) {
			dir = -dir;
		}
		
		return dir;
	}

	
	@Override
	public boolean canEat(Organism o) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	@Override
	public void eat(Organism o) {
		// TODO Auto-generated method stub
		
	}

}
