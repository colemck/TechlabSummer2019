package antlife;

import apcs.Window;

public class Ant extends GameObject {

	// ATTRIBUTES
	double dx = 1;
	double dy = 1;
	double speed = 3;
	
	GameObject focus;
	GameObject food;
	Hill home;
	
	boolean reachedFocus = false;

	public Ant(Hill home) {

		this.x = home.x;
		this.y = home.y;
		this.home = home;

	}

	public void findFocus(GameObject f) {

		double xdiff = f.x - x;
		double ydiff = f.y - y;
		double dist = Math.sqrt(xdiff * xdiff + ydiff * ydiff);

		if (dist < f.range && this.focus == null) {
			this.focus = f;
			f.range = 150;
			this.food = f;
		}

	}
	


	public void wander() {
		dx = choose(dx);
		dy = choose(dy);

		x += dx + Window.random(-2, 1);
		y += dy + Window.random(-2, 1);

	}

	public void goToFocus() {

		double xdiff = focus.x - x;
		double ydiff = focus.y - y;
		double dist = Math.sqrt(xdiff * xdiff + ydiff * ydiff);

		dx = (xdiff) / (dist + 1) * speed;
		dy = (ydiff) / (dist + 1) * speed;

		x += (dx + Window.random(-2, 1));
		y += (dy + Window.random(-2, 1));
		
		if (dist < 10 && Window.rollDice(20) == 1) {
			
			if(focus == home){
				focus = null;
				food = null;
			}else{
				focus.radius-= 0.5;
				
				if(Window.rollDice(10)==1)focus = home;
				
			}
		}
		
		
		if(focus == home && dist < home.radius){
			speed = 2;
		}else{
			speed = 3;
		}
		

	}

	private double choose(double dir) {
		if (Window.rollDice(50) == 1) {
			if (Window.flipCoin())
				dir = 2;
			else
				dir = -2;
		}

		if (Window.rollDice(25) == 1) {
			if (Window.flipCoin())
				dir = 1;
			else
				dir = -1;
		}

		return dir;
	}
	
	
	public void drawFood() {
		Window.out.color(food.r, food.g, food.b);
		Window.out.circle(x + dx, y + dy, 2);

	}

	@Override
	public void draw() {
		
		Window.out.color("black");
		Window.out.circle(x + dx * 2, y + dy * 2, 3);
		Window.out.circle(x, y, 3);
		Window.out.circle(x - dx * 2, y - dy * 2, 3);
		
		if(focus == home){
			this.drawFood();
		}

	}

}
