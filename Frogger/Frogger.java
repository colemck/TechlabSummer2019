package frogger;

import java.util.ArrayList;

import apcs.Window;

public class Frogger {
	
	// Global variables
	static int frogx = 400;
	static int frogy = 575;

	public static void main(String[] args) {
		Window.size(800, 600);
		
		Window.frame();
		
		// Object that stores a list of things
		ArrayList<Truck> list = new ArrayList<Truck>();
		
		// Do this 10 times
		int i = 0;
		while (i < 10) {
			// Create a truck and add it to the list.
			list.add(new Truck());
			
			// Increment
			i = i + 1;
		}
		
		while (true) {
			drawBackground();
			drawFrog();
			moveFrog();
			
			// For every truck, call it t, in my list of trucks,
			for (Truck t : list) {
				// Draw and move the truck
				t.draw();
				t.move();
				// Reset the frog if it's hitting this truck
				if (t.hitting(frogx, frogy)) {
					frogx = 400;
					frogy = 575;
				}
			}
			
			Window.frame();
		}
		
	}

	private static void moveFrog() {
		if (Window.key.pressed("left")) {
			frogx = frogx - 10;
		}
		if (Window.key.pressed("right")) {
			frogx = frogx + 10;
		}
		if (Window.key.pressed("up")) {
			frogy = frogy - 10;
		}
		if (Window.key.pressed("down")) {
			frogy = frogy + 10;
		}
		
	}

	private static void drawFrog() {
		
		Window.out.color("sea green");
		Window.out.circle(frogx, frogy, 12);
		Window.out.color("white");
		Window.out.circle(frogx - 4, frogy - 3, 4);
		Window.out.circle(frogx + 4, frogy - 3, 4);

		Window.out.color("black");
		Window.out.circle(frogx - 4, frogy - 3, 2);
		Window.out.circle(frogx + 4, frogy - 3, 2);
	}

	private static void drawBackground() {
		Window.out.background("gray");
		Window.out.color("green");
		Window.out.rectangle(400, 25, 800, 50);
		Window.out.rectangle(400, 575, 800, 50);
		
		Window.out.color("yellow");
		int y = 100;
		
		while (y < 550) {
			int x = 20;
			while (x < 800) {
				Window.out.rectangle(x, y, 20, 4);
				x = x + 40;
			}
			y = y + 50;
		}
	}
}