package oceansim;

import apcs.Window;

public abstract class Organism {
	
	int x = Window.random(0, Window.width());
	int y = Window.random(0, Window.height());
	boolean alive = true;
	
	public abstract void draw();
	public abstract void move();
	public abstract boolean canEat(Organism o);
	public abstract void eat(Organism o);
	
	
	

}
