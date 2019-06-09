package birdgamefinished;

import apcs.Window;

public class Bird {

	// Attributes
	int x = Window.width() / 3;
	int y = 100;
	int yspeed = 2;
	int radius = 30;
	boolean canJump = true;

	// Methods

	public void draw() {
		Window.out.color("yellow");
		Window.out.circle(x, y, radius);
	}

	public void move() {

		y = y + yspeed;
		yspeed = yspeed + 4;
		
		
		//deleted floor bound
		
		// We can only jump once per space click
		if (Window.key.pressed("space") && canJump == true) {
			yspeed = -20;
			canJump = false;
		} else if (!Window.key.pressed("space")) {
			canJump = true;
		}
		
		
		
	}
	
	
	// The most important part! Let the students spend some time thinking about this one. 
	
	public boolean makeContact(Pipe p) {
		
		//determines if the bird is in the horizontal zone
		if(x + radius >= p.x - p.p_width/2 && x - radius <= p.x + p.p_width/2) {
			//determines if the bird is in the vertical zone 
			if(y + radius >= Window.height() - p.bottom_p_height || y - radius <= p.top_p_height) {
				return true;
			}
		}
		return false;
	}
	
	
	public void reset() {
		y = 100;
		yspeed = 2;
	}
	

}


