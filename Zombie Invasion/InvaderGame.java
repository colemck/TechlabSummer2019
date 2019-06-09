package invaders;

import java.util.ArrayList;

import apcs.Window;

import java.util.ArrayList;

import apcs.Window;

public class InvaderGame {

	public static void main(String[] args) {
		// Pick a size
		Window.size(800, 800);
		
		// Make variables to store what's in the world
		Player me = new Player();
		ArrayList<Invader> invaderList = new ArrayList<Invader>();
		ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
		
		// Variables to time and store the state of the world
		int bulletTimer = 0;
		int invadersHit = 0;
		boolean gameOver = false;
		
		// Infinitely draw frames
		while (true) {
			Window.frame();
			Window.out.background("tan");
			
			// draw and move everything
			me.draw();
			me.move();
			
			// Pick a key that represents shooting
			if (Window.mouse.clicked() && bulletTimer <= 0) {
				// Construct a bullet object that goes to me
				Bullet newBullet = new Bullet(me);
				// Add the bullet to the list
				bulletList.add(newBullet);
				// Start the timer at some positive number
				bulletTimer = 5;
			}
			// The bullet timer is always counting down
			bulletTimer = bulletTimer - 1;
			
			// Randomly add invaders to the list
			if (Window.rollDice(10) == 1) {
				// Create a new invader
				Invader newInvader = new Invader();
				// Add it to the list
				invaderList.add(newInvader);
			}
			
			// draw and move every invader
			for (Invader i : invaderList) {
				i.draw();
				i.move();
			}
			
			// draw and move every bullet
			for (Bullet b : bulletList) {
				b.draw();
				b.move();
			}
			
			// many-to-one interaction
			// interaction between every invader and the one player
			for (Invader i : invaderList) {
				// If the invader i is touching the player
				if (i.isTouching(me)) {
					// Record that I got hit
					gameOver = true;
				}
			}
			
			// many-to-many interaction
			// For every invader,
			for (Invader i : invaderList) {
				// Check every bullet
				for (Bullet b : bulletList) {
					// Is the invader touching the bullet?
					if (i.isTouching(b)) {
						i.die();
						invadersHit = invadersHit + 1;
					}
				}
			}
			
			if (invadersHit > 10) {
				// Go to the next level
			}
			
			// If the gameOver boolean has been set to true
			if (gameOver == true) {
				Window.out.background("red");
				Window.out.color("white");
				Window.out.fontSize(80);
				Window.out.print("The zombies got you!", 50, 300);
				Window.out.fontSize(40);
				Window.out.print("Click to reset", 250, 350);
				
				// To stop the game over message
				if (Window.mouse.clicked()) {
					// Refresh everything
					invaderList.clear();
					bulletList.clear();
					me = new Player();
					gameOver = false;
				}
			}
		}
		
	}

}