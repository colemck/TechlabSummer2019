package oceansim;

import apcs.Window;

public class Plankton extends Organism{

	
	int radius = 2;
	@Override
	public void draw() {
		Window.out.color("light green");
		Window.out.circle(x, y, radius);
		
	}
	
	

	@Override
	public void move() {
		x = x + Window.random(-2, 1);
		y = y + Window.random(-2, 1);
	}



	@Override
	public boolean canEat(Organism o) {
		return false;
	}



	@Override
	public void eat(Organism o) {
		// TODO Auto-generated method stub
		
	}

}
