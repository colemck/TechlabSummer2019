package antlife;

import java.util.ArrayList;

import apcs.Window;

public class Hill extends GameObject {

	// Attributes
	int radius = Window.random(35, 75);
	int cr = radius;

	ArrayList<Ant> ants = new ArrayList<Ant>();

	ArrayList<Food> food = new ArrayList<Food>();

	public Hill() {
		x = Window.random(Window.width() / 2 - 100, Window.width() / 2 + 100);
		y = Window.random(Window.height() / 2 - 100, Window.height() / 2 + 100);
		range = (Window.width() + Window.height()) / 2;
		this.setup();
	}

	public void setup() {
		for (int i = 0; i < 1; i++) {
			this.addAnt();
		}

	}

	private void addAnt() {
		// creates a new ant and adds it to the ANTS arraylist
		ants.add(new Ant(this));
	}

	public void draw() {
		while (cr > 0) {
			Window.out.color(150, cr * 2, 0);
			Window.out.circle(x, y, cr);
			cr -= 8;
		}

		cr = radius;

		Window.out.color("black");
		Window.out.circle(x, y, 4);

	}

	public void exist() {
		
		ArrayList<Food> kiltFood = new ArrayList<Food>();

		if (Window.key.pressed("1")) {
			ants.add(new Ant(this));
		}

		// if(Window.rollDice(100) == 1)food.add(new Food());
		if (Window.key.pressed("space")) {
			food.add(new Food());
		}

		for (Food f : food){
			f.draw();
			
			if(f.radius < 0) f.finished = true;
			
			if(f.finished){
				kiltFood.add(f);
			}
			f.range += .5;
		}

		this.draw();
		for (Ant a : ants) {
			a.draw();
			if (a.focus == null) {
				a.wander();

				if (food.size() > 0) {
					for (Food f : food)
						a.findFocus(f);

				}

			} else {
				a.goToFocus();

			}

		}
		
		for(Food f: kiltFood){
			food.remove(f);
		}

	}

}
