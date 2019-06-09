package birdgamefinished;

import apcs.Window;

public class Pipe {
	
    
	int x;                  //  x coord of both pipes
	int xspeed = 7;         //  horz. speed of both pipes
	int gap = 170;          //  size of the space between pipes
	int p_width = 60;       //  pipe width
	int initialPos;         
	
	//top pipe height = random int - gap
	int top_p_height = Window.random(0, Window.height() - gap);
	
	//bottom pipe height = window height - (top pipe height + gap)
	int bottom_p_height = Window.height() - top_p_height - gap;
	

	//the y coordinate of the pipes 
	int top_y = top_p_height / 2;
	int bottom_y = Window.height() - bottom_p_height/2;
	
	
	/*
	 * startingVal is the distance the pipe will start off screen
	 * This is to offset the pipes 
	 * 
	 *   100    400    700
	 *   ||     ||     ||
	 *          ||     ||
	 *   ||     ||     
	 *   ||            ||
	 *   ||     ||     ||
	 *      300    300
	 */
	Pipe(int startingVal){
		this.x = Window.width() + startingVal;
		
		//saving the initial position of the pipe for later
		this.initialPos = x;
	}
	
	
	public void draw() {
		
		//pipes
		Window.out.color("green");
		Window.out.rectangle(x, top_y, p_width, top_p_height);
		Window.out.rectangle(x, bottom_y, p_width, bottom_p_height);
		
		//pipe rims
		Window.out.color("dark green");
		Window.out.rectangle(x, top_p_height, p_width + 3, 10);
		Window.out.rectangle(x, Window.height() - bottom_p_height, p_width + 3, 10);
		
		
	}
	
	
	public void move(){
		
		x = x - xspeed;
		
		//resets the pipe
		if(x <= -150) {
			x = Window.width() + 150;
		}
		
		// note: 150 + 150 = 300   (pipe distances from each other)
	}
	
	
	
	
	
	//Called when bird hits pipe
	public void reset() {
		
		top_p_height = Window.random(0, Window.height() - gap);
		bottom_p_height = Window.height() - top_p_height - gap;
		
		//pipe coordinates
		x = initialPos;
		top_y = top_p_height / 2;
		bottom_y = Window.height() - bottom_p_height/2;
		
	}
	


}
