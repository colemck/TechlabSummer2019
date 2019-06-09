package Lunar_Lander;

import apcs.Window;

public class Lunar_Lander {

	public static void main(String[] args) throws InterruptedException {
		
		//NEW 
		boolean lose = false;
		boolean win = false;
		
		Window.size(1000, 600);
		
		Window.out.print("..", 2, 2);
		
		int x = 200;
		int y = 200;
		
		int dx = 0;
		int dy = 0;
		
		//NEW
		int floor_height = 80;
		//NEW
		int rocket_blast = 0;
		
		//NEW 
		int explosion_radius = 0;
		
		//NEW
		int boxPos = 450;
		
		//NEW
		int landing_speed = 0;
		
		//NEW
		int landing_padX = 400;
		int landing_pad_width = 200;
		
		while(true){	
			
			//NEW
			boolean start = false; 
			Window.out.background("white");
			Window.out.color("green");
			Window.out.fontSize(40);
			
			//Rocket silhouette
			Window.out.polygon(x - 25, y - 50, x-20, y - 65, x, y - 90, x + 20, y - 65, x + 25, y - 50, x + 28, y + 10, x + 45, y + 40, x + 40, y + 50, x - 40, y + 50, x - 45, y + 40, x - 28, y + 10  );
			
			Window.out.print("Press Space to start", 350, 200);
			Window.out.fontSize(20);
			Window.out.print("Your rocket starts here!!" , 110, 280);
			
			//Start window
			while(start != true){
				if(Window.key.pressed("space")){
					start = true;
				}
			}
			
			while(start){
				//NEW 
				int grabber_height = y;
				
				Window.frame();  
				
				
				Window.out.background("light blue");
				
				Window.out.color("green");
				Window.out.rectangle(500, 600 - floor_height/2, 1000, floor_height);
				
				//Grabber 
				Window.out.rectangle(x, grabber_height, 8, 100);
				
				//Space-craft body
				Window.out.color("gray");
				Window.out.polygon(x - 25, y - 50, x-20, y - 65, x, y - 90, x + 20, y - 65, x + 25, y - 50, x + 28, y + 10, x + 45, y + 40, x + 40, y + 50, x - 40, y + 50, x - 45, y + 40, x - 28, y + 10  );
				Window.out.color("black");
				Window.out.polygon(x, y + 10, x - 15, y + 48, x + 15, y + 48);
				
				//Stripes
				Window.out.color("blue");
				Window.out.rectangle(x, y,9, 100);
				Window.out.color("white");
				Window.out.rectangle(x, y,5, 100);
				
				//Fin
				Window.out.color("grey");
				Window.out.rectangle(x, y + 35,3, 35);
				
				//Window
				Window.out.color("black");
				Window.out.oval(x,  y - 35, 22, 60);
				Window.out.color("grey");
				Window.out.square(x, y - 8, 17);
				
				//Landing Pad
				Window.out.color("black");
				Window.out.rectangle(landing_padX, 600 - floor_height + 3, landing_pad_width, 10);
				
				//COLLABEDIT
				
				
				
				
				if(Window.key.pressed("space")){
					rocket_blast += 2;
					
					Window.out.color("orange");
					Window.out.polygon(x - 20, y + 50, x, y + (65 + rocket_blast), x + 20, y + 50);
					Window.out.polygon(x - 36, y + 50, x - 28, y + (50 + rocket_blast),x - 20, y + 50);
					Window.out.polygon(x + 36, y + 50, x + 28, y + (50 + rocket_blast), x + 20, y + 50);
				}
				x = x + dx;
				y = y + dy;
				dy = dy + 1;
				
				if(lose != true && win != true){
					if(y > 550 - floor_height){
						
						y = 550 - floor_height; 
						dx = dx/2;
						
						if(dy > 15){
							dy = 0;
							lose = true;
			
						}else{
							//UPDATED LANDING PAD STUFF
							landing_speed = dy;
							dy = 0;
							
							if(x - 25 > landing_padX - landing_pad_width/2 && x + 25 < landing_padX + landing_pad_width/2){
								
								win = true;
								
							}
							
						}
						
					}
				
					if(Window.key.pressed("space")){
						dy = dy - 2;
			
							
					}else{
						rocket_blast = 0;
						
					}
					if(Window.key.pressed("down")){
						
						if(grabber_height - y < 85){
							grabber_height += 5;
						}
					}
					if(Window.key.pressed("right")){
						dx = dx + 1;
					}
					if(Window.key.pressed("left")){
						dx = dx - 1;
					}
					
					if(Window.key.pressed("p")){
						Thread.sleep(10000);
					}
				}else if(lose == true){
					dy = 0;
					dx = dx/2;
					y = 550 - floor_height;
					Window.out.print("You Lose", 300, 300);
					if(explosion_radius < 1000){
						explosion_radius += 10;
					}
					
					Window.out.color("yellow");
					Window.out.circle(x, y, explosion_radius);
					if(explosion_radius == 1000){
						Window.out.color("black");
						Window.out.fontSize(30);
						Window.out.print("Houston, we have a problem.. press space to try again", 200, 250);
						
					}
					if(Window.key.pressed("space")){
						dy = 0;
						dx = 0;
						x = 200;
						y = 200;
						explosion_radius = 0;
						
						lose = false;
						start = false;
					}
				}else{
					
					dx = dx/2;
					y = 550 - floor_height;
					Window.out.color("green");
					Window.out.print("Success!", 260, 200);
					Window.out.print("Landing speed: ", 230, 230);
					Window.out.print(landing_speed, 400, 230);
					//win(landing_speed);
				}
			}
		}
	}
	
}
