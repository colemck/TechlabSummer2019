package antlife;

import apcs.Window;

public class Food extends GameObject {

	
	boolean finished = false;
	
	
	public Food(){
		
		radius = Window.random(8, 20);
		x = Window.random((int)radius, Window.width() - (int)radius);
		y = Window.random((int)radius, Window.height() -(int)radius);
		r = Window.random(50, 250);
		g = Window.random(50, 255);
		b = Window.random(50, 200);
		range = (int)radius + 30;
		
	}
	
	
	@Override
	public void draw() {
	
//		Window.out.color("red");
//		Window.out.circle(x, y, range);
		
		Window.out.color(r, g, b);
		Window.out.circle(x, y, radius);
		
		
		
	}
	
}
