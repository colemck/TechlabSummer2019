package dino_jumper;

import apcs.Window;

public class Game {
	// GLOBAL VARIABLES
//	//---------------
//	static int floor_thickness = 100;
//	static int floor_pos = Window.height() - floor_thickness / 2;
//	//---------------

	public static void main(String[] args) {
		
		Window.size(600, 700);
		//---------------
		int floor_thickness = 100;
		int floor_pos = Window.height() - floor_thickness / 2;
		int ground = floor_pos - floor_thickness/2;
		//---------------
		
		//----CHARACTER VARIABLES -------
		int x = Window.width()/3;
		int y = 10;
		int char_width = 40;
		int char_height = 60;
		int dy = 1;
		
		
		int sidelen = 30;
		int cy = ground - sidelen / 2;
		int cspeed = 16;
				
		int cx1 = Window.width() + 50 +  Window.random(0, 100);
		int cx2 = Window.width() + 500 +  Window.random(0, 100);
		int cx3 = Window.width() + 1050 +  Window.random(0, 100);
	
		
		boolean canJump = false;
	
		
		while(true){
			Window.frame();
			drawBackground(floor_pos, floor_thickness);
			
			Window.addColor("jake yellow", "#ffcc00");
			Window.out.color("jake yellow");
			
		
			//MOVE CHARACTER
			y = y + dy;
			dy = dy + 4;
			
			//DRAW CHARACTER
			Window.out.rectangle(x, y, char_width, char_height);
			
			
			//LETS CHECK IF WE'RE ON THE GROUND
			if(y + char_height/2 >= floor_pos - floor_thickness/2){
				y = floor_pos - floor_thickness/2 - char_height/2;
				dy = 0;
				canJump = true;
			}else{
				canJump = false;
			}
			
			if(Window.key.pressed("space") && canJump == true){
				dy = -30;
			}
			
			
			//DRAW THE CACTUSES 
			
			//MOVE THEM
			cx1 -= cspeed;
			cx2 -= cspeed;
			cx3 -= cspeed;
			
			Window.out.color("purple");
			Window.out.square(cx1, cy, sidelen);
			Window.out.square(cx2, cy, sidelen);
			Window.out.square(cx3, cy, sidelen);
			
			
			if(cx1 < -100){
				cx1 = Window.width() + 30 + Window.random(0, 100);	
			}
			
			if(cx2 < -100){
				cx2 = Window.width() + 30 + Window.random(0, 100);		
			}
			
			if(cx3 < -100){
				cx3 = Window.width() + 30 + Window.random(0, 100);		
			}
			

			
			//if the player is betwen the two sides 
			if(x + char_width / 2 > cx1 - sidelen/2 && x - char_width/2 < cx1 + sidelen / 2){
				//add a point
				
				if(y + char_height / 2 > cy - sidelen / 2 && y - char_height / 2 < cy + sidelen/2  ){
					//dead
					break;
					
				}
				
			}
			
			if(x + char_width / 2 > cx2 - sidelen/2 && x - char_width/2 < cx2 + sidelen / 2){
				//add a point
				
				if(y + char_height / 2 > cy - sidelen / 2 && y - char_height / 2 < cy + sidelen/2  ){
					//dead
					break;
					
				}
				
			}
			
			if(x + char_width / 2 > cx3 - sidelen/2 && x - char_width/2 < cx3 + sidelen / 2){
				//add a point
				
				if(y + char_height / 2 > cy - sidelen / 2 && y - char_height / 2 < cy + sidelen/2  ){
					//dead
					break;
					
				}
				
			}
		
		}
		
	}
	
	
	private static void drawBackground(int y, int height) {
		Window.out.background(150, 220, 255);
	
		Window.out.color("green");
		Window.out.rectangle(Window.width()/2, y, Window.width(), height);
		
	
		
	}

}
