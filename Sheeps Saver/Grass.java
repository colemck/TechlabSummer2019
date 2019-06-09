package sheepsaver;

import apcs.Window;

public class Grass {

	int x = Window.width() / 2;
	int y = Window.height() / 2;
	int energy = Window.random(9, 16);

	int r = Window.random(50, 100);
	int g = Window.random(190, 250);
	int b = Window.random(50, 60);
	public boolean eaten = false;

	Grass(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw() {
		if (!eaten) {
			Window.out.color(r, g, b);
			for (int i = 1; i < energy/2; i++) {
				Window.out.polygon(x + i * 4, y, x + i * 4 + 4, y - 20, x + i * 4 + 6, y);
			}
		}
	}

}
