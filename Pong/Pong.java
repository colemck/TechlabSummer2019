package day3;

import apcs.Window;

public class Pong {

	public static void main(String[] args) {

		Window.size(600, 400);

		// Ball variables --------
		int x = Window.random(100, Window.width() - 100);
		int y = Window.random(100, Window.height() - 100);
		int dx = 10;
		int dy = 13;
		int radius = 20;
		// -------

		// Variables for both paddles
		int pw = 10;
		int ph = 100;
		int paddleSpeed = 20;

		// Paddle 1 position --------
		int p1x = 30;
		int p1y = Window.height() / 2;

		// Paddle 2 position --------
		int p2x = Window.width() - 30;
		int p2y = Window.height() / 2;

		Window.out.fontSize(30);
		Window.out.print("test", -100, -100);

		// New colors
		Window.addColor("carpet blue", "#545f83");
		Window.addColor("marker green", "#2acba5");

		while (true) {
			Window.frame();
			drawBackground();

			// Move Ball
			x += dx;
			y += dy;

			// Bounce
			if (x - 30 < 0 || x + 30 > Window.width()) {
				dx = -dx;
			}
			if (y - 30 < 0 || y + 30 > Window.height()) {
				dy = -dy;
			}

			// Paddle Bounce

//			Conditions:
//		    
//		         the left side of the ball is past the right of side of the paddle 
//				 AND the right side of the ball is past the left side of the paddle
//				 
//				 (we know the ball is in the horizontal zone, now check vertical position)
//			 
//				  the top of the ball is higher than the bottom of the paddle
//				  AND the bottom of the ball is under the top of the paddle
//			
//       	Math.abs(x - px)	
//			if(horizontal){
//				
//				if(vertical){
//					
//					reflect
//					
//				}
//				
//			}

			// Left Paddle
			if (Math.abs(x - p1x) < radius + pw / 2 + 2) {
				if (Math.abs(y - p1y) < radius + ph / 2) {
					dx = -dx;
				}
			}
			// Right Paddle
			if (Math.abs(x - p2x) < radius + pw / 2 + 2) {
				if (Math.abs(y - p2y) < radius + ph / 2) {
					dx = -dx;
				}
			}

			// Left paddle movement
			if (Window.key.pressed("1")) {
				p1y -= paddleSpeed;
			} else if (Window.key.pressed("2")) {
				p1y += paddleSpeed;
			}
			// Right paddle movement
			if (Window.key.pressed("up")) {
				p2y -= paddleSpeed;
			} else if (Window.key.pressed("down")) {
				p2y += paddleSpeed;
			}

			drawBall(x, y, radius);
			drawPaddle(p1x, p1y, pw, ph);
			drawPaddle(p2x, p2y, pw, ph);

		}

	}

	private static void drawPaddle(int px, int py, int pw, int ph) {
		Window.out.color("black");
		Window.out.rectangle(px, py, pw, ph);

	}

	private static void drawBall(int x, int y, int radius) {
		Window.out.color("orange");
		Window.out.circle(x, y, radius);

	}

	private static void drawBackground() {
		Window.out.background("marker green");
		Window.out.color("white");
		Window.out.rectangle(Window.width() / 2, Window.height() / 2, 7, Window.height());

	}

}
