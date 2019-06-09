package invaders;


import apcs.Window;

public class Player {
	
	int x = Window.width() / 2;
	int y = Window.height() / 2;

	/**
	 * Draws the player at its x, y position.
	 */
	public void draw() {
		Window.out.color("blue");
		Window.out.circle(x, y, 10);
	}
	
	/**
	 * Moves the player with the arrow keys.
	 * Uses the up, down, left, right arrow keys.
	 */
	public void move() {
		if (Window.key.pressed("up")) {
			y = y - 10;
		}
		if (Window.key.pressed("down")) {
			y = y + 10;
		}
		if (Window.key.pressed("left")) {
			x = x - 10;
		}
		if (Window.key.pressed("right")) {
			x = x + 10;
		}
		// TODO: check the boundaries
		if (x < 10) {
			x = 10;
		}
		if (x > 790) {
			x = 790;
		}
	}

}