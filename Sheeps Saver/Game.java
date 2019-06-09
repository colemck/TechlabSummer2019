package sheepsaver;

import java.util.ArrayList;

import apcs.Window;

public class Game {

    public static void main(String[] args) {

        Window.size(800, 800);
        int islandrad = Window.width() / 3;

        Sheep shawn = new Sheep();
        Sheep shawna = new Sheep();

        ArrayList<Sheep> sheeps = new ArrayList<Sheep>();
        ArrayList<Grass> grass = new ArrayList<Grass>();
        Shepherd doggo = new Shepherd();

        for (int i = 0; i < 15; i++) {
            sheeps.add(new Sheep());
        }

        while (true) {
            Window.frame();
            drawBackground(islandrad);

            doggo.draw();
            // Draw and move every Sheep in sheeps
            for (Sheep sheep : sheeps) {
                sheep.move();
                sheep.draw();
                doggo.near(sheep);
                for (Grass g : grass) {
                    sheep.eat(g);
                    g.draw();
                }

            }

            if (Window.key.pressed("space")) {
                grass.add(new Grass(doggo.x, doggo.y));
            }

            if (Window.key.pressed("p")) {
                Window.sleep(4000);
            }

        }

    }

    public static void drawBackground(int radius) {

        Window.out.background("dodger blue");
        Window.out.color("yellow green");
        Window.out.circle(Window.width() / 2, Window.height() / 2, radius);

    }

}
