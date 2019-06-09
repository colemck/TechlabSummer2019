package birdgamefinished;

import apcs.Window;

public class Game {

	public static void main(String[] args) {
		
		
		Window.size(600, 700);
		
		
		Bird bird = new Bird();
		
		Pipe pipe1 = new Pipe(100);
		Pipe pipe2 = new Pipe(400);
		Pipe pipe3 = new Pipe(700);
		
		
		
		while(true) {
			Window.frame();
			drawBackground();
			
			bird.draw();
			bird.move();
			
			pipe1.draw();
			pipe1.move();
			
			pipe2.draw();
			pipe2.move();
			
			pipe3.draw();
			pipe3.move();
			
			if(bird.makeContact(pipe1) || 
			   bird.makeContact(pipe2) || 
			   bird.makeContact(pipe3) || 
			   bird.y > Window.height()) {
				
				bird.reset();
				pipe1.reset();
				pipe2.reset();
				pipe3.reset();
			}
		}
	
	}
	
	public static void drawBackground(){
		Window.out.background("dodger blue");
		for(int i = 0; i < 5; i ++){
			Window.out.color(80 - i * 5, 250 - i * 10, 150 - i * 70);
			Window.out.circle(100 + i * 200, Window.height() + 120, 200);
			
		}
	}

}
