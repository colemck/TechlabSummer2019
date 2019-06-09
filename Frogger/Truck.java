package frogger;

import apcs.Window;

public class Truck {
	int speed = Window.rollDice(5) + 5;
	int x = -50 - Window.rollDice(500);
	int lane = Window.rollDice(10);
	
	public void draw() {
		Window.out.color("black");		
		Window.out.rectangle(x + 30, 25 + 50 * lane, 25, 48);
		Window.out.rectangle(x - 25, 25 + 50 * lane, 25, 48);
	
		Window.out.color("orange");
		Window.out.rectangle(x, 25 + 50 * lane, 100, 40);
		
		Window.out.color("brown");
		Window.out.rectangle(x - 23, 25 + 50 * lane, 45, 36);
		
		Window.out.color("light blue");
		Window.out.rectangle(x + 22, 25 + 50 * lane, 7, 38);
	}

	public void move() {
		x = x + speed;
		if (x > 850) {
			x = -50 - Window.rollDice(50);
			lane = Window.rollDice(10);
			speed = Window.rollDice(5) + 5;
		}
	}

	public boolean hitting(int frogx, int frogy) {
		if (Math.abs(frogx - x) < 50 && Math.abs(25 + 50 * lane - frogy) < 20) {
			return true;
		}
		else {
			return false;
		}
	}
}