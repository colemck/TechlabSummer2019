package invaders;


import apcs.Window;

public class Bullet {
	int x;
	int y;
	int dx;
	int dy;

	public Bullet(Player me) {
		x = me.x;
		y = me.y;
		dx = (Window.mouse.getX() - x) / 5;
		dy = (Window.mouse.getY() - y) / 5;
		// TODO: make the bullet speed more "normal"/realistic
		if (dx > 10) {
			dx = 10;
		}
		if (dx < -10) {
			dx = -10;
		}
		if (dy > 10) {
			dy = 10;
		}
		if (dy < -10) {
			dy = -10;
		}
	}

	public void draw() {
		Window.out.color("red");
		Window.out.circle(x, y, 3);
	}

	public void move() {
		x = x + dx;
		y = y + dy;
	}

}