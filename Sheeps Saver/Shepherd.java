package sheepsaver;

import apcs.Window;

public class Shepherd {

	int x = Window.width() / 2;
	int y = Window.height() / 2;
	int radius = 15;
	
	int dx = 10;
	int dy = 10;
	
	public void near(Sheep sheep){
		double diffx = sheep.x - x;
		double diffy = sheep.y - y;
		double dist = Math.sqrt(diffx * diffx + diffy * diffy);
		
		if(dist < 40){
			sheep.dx = (int)(diffx/7);
			sheep.dy = (int)(diffy/7);
		}
		
	}
	
	public void move(){
//		x = Window.mouse.getX();
//		y = Window.mouse.getY();
		
		if(Window.key.pressed("left")){
			x -= dx;
		}
		if(Window.key.pressed("right")){
			x += dx;
		}
		if(Window.key.pressed("up")){
			y -= dy;
		}
		if(Window.key.pressed("down")){
			y += dy;
		}
		
	}
	
	
	
	
	public void draw() {
		this.move();
		
		// Body
		Window.out.color("moccasin");
		Window.out.circle(x, y, radius);

		// Eyes
		Window.out.color("black");
		Window.out.circle(x - radius / 2, y - 2, radius / 5);
		Window.out.circle(x + radius / 2, y - 2, radius / 5);

		// Nose
		Window.out.polygon(x - 4, y + 2, x + 4, y + 2, x, y + 6);

		// Mouth
		Window.out.color("hot pink");
		Window.out.polygon(x - 4, y + 7, x + 4, y + 7, x, y + 12);
		
		// ears
		Window.out.color("brown");
		Window.out.square(x - radius + 4, y - radius + 4, 9, 45);
		Window.out.square(x + radius - 4, y - radius + 4, 9, 45);
	}

	// hits

}
