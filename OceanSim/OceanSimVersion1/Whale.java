package oceansim;

import apcs.Window;

public class Whale extends Organism{

	
	double w = Window.random(80, 100);
	double h = Window.random(40, 60);
	int dx = Window.random(-10, 10);
	int dy = Window.random(-1, 1);
	
	Organism focus = null;
	
	@Override
	public void draw() {
		Window.out.color("dodger blue");
		Window.out.oval(x, y, (int)w, (int)h);
	
		
		Window.out.color("light blue");
		Window.out.oval(x, (int)(y +  h/3), (int)(w / 1.5), (int)(h / 3));
		
	}

	@Override
	public void move() {
		x = x + dx;
		y = y + dy;
		
		
		if(x < w/2 || x >= Window.width() - w/2) {
			dx = -dx;
		}
		if(y < h/2|| y >= Window.height() - h/2) {
			dy = -dy;
		}
		
	}
	
//	public void findFocus(Organism o) {
//		
//		if(o instanceof Plankton) {	
//			if(focus == null) {
//		
//				double xdiff = x - o.x;
//				double ydiff = y - o.y;
//				double dist = Math.sqrt(xdiff * xdiff + ydiff * ydiff);
//				
//				if(dist < 200) {
//					focus = o;
//				}
//				
//				
//			}else {
//				goToFocus();
//			}
//		}
//	}
	
	
//	public void goToFocus() {
//		double xdiff = focus.x - x;
//		double ydiff = focus.y - y;
//		
//		dx = (int)xdiff/10;
//		dy = (int)ydiff/10;
//		
//		
//	}

	@Override
	public boolean canEat(Organism o) {
		
		if(o instanceof Plankton) {
			return true;
		}
		
		return false;
		
	}
	
	
	public void eat(Organism o) {
		
		if(this.canEat(o)) {
			double xdiff = x - o.x;
			double ydiff = y - o.y;
			double dist = Math.sqrt(xdiff * xdiff + ydiff * ydiff);
			
			if(dist < h/2) {
				o.alive = false;
				
				w += 1;
				h += 1;
				
			}
			
		}
	}
}
