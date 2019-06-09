package invaders;


import apcs.Window;

public class Invader {
	int x;
	int y;
	int dx;
	int dy;
	boolean dead = false;
	
	// Construct the invader
	public Invader() {
		int roll = Window.rollDice(4);
		
		// Start at the top, move down
		if (roll == 1) {
			x = Window.rollDice( Window.width() );
			y = -20;
			dx = 0;
			dy = 5;
		}
		// Start at bottom and move up
		if (roll == 2) {
			x = Window.rollDice( Window.width() );
			y = Window.height() + 20;
			dx = 0;
			dy = -5;
		}
		// Start at left, move right
		if (roll == 3) {
			x = -20;
			y = Window.rollDice(Window.height());
			dx = 5;
			dy = 0;
		}
		// Start at right, move left
		if (roll == 4) {
			x = Window.width() + 20;
			y = Window.rollDice(Window.height());
			dx = -5;
			dy = 0;
		}
	}
	
	public void draw() {
		if (dead == false) {
			Window.out.color("green");
			Window.out.circle(x, y, 8);
		}
	}

	public void move() {
		x = x + dx;
		y = y + dy;
	}

	public boolean isTouching(Player me) {
		if ( Math.abs(x - me.x) < 15 && Math.abs(y - me.y) < 15) {
			return true;
		}
		return false;
	}

	public boolean isTouching(Bullet b) {
		if (Math.abs(x - b.x) < 10 && Math.abs(y - b.y) < 10) {
			return true;
		}
		return false;
	}

	public void die() {
		dead = true;
	}

}