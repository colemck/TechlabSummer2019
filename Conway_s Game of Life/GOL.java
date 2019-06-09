import apcs.Window;

public class GOL {

    static int cs = 100;
    static int rs = 100;

    public static void main(String[] args) {

        Window.size(700, 700);

        int side = Window.width() / cs;

        // created an empty boolean array
        boolean[][] cells = new boolean[rs][cs];

        // fills in living cells
        for (int r = 0; r < rs; r++) {

            for (int c = 0; c < cs; c++) {

                if (Window.rollDice(8) == 1) {
                    cells[r][c] = true;
                }

            }
        }

        boolean start = false;

        while (true) {
            Window.frame(100);

            Window.out.background("dodger blue");

            // adds cells on click
            if (Window.mouse.clicked()) {
                int x = Window.mouse.getX();
                int y = Window.mouse.getY();

                if (cells[y / side][x / side]) {
                    cells[y / side][x / side] = false;
                } else {
                    cells[y / side][x / side] = true;
                }
            }

            // draws the cells
            for (int r = 0; r < rs; r++) {

                for (int c = 0; c < cs; c++) {

                    if (cells[r][c] == true) {
                        // Window.out.color(c * 3, 0, r * 3);
                        // Window.out.randomColor();
                        Window.out.color("yellow green");
                        Window.out.square(c * side + side / 2, r * side + side / 2 - 2, side);
                    } else {
                        Window.out.color("black");
                        Window.out.square(c * side + side / 2, r * side + side / 2, side - 1);
                    }
                }
            }

            // Waits for me to press space

            // sends the cells through a generation
            if (start) {
                cells = life(cells);
            }

            if (Window.key.pressed("space")) {
                start = true;
            }

        }

    }

    public static boolean[][] life(boolean[][] cells) {

        boolean[][] newCells = new boolean[rs][cs];

        for (int r = 0; r < rs; r++) {

            for (int c = 0; c < cs; c++) {

                int neighbors = 0;

                // top left
                if (r > 0 && c > 0 && cells[r - 1][c - 1] == true)
                    neighbors++;

                // above
                if (r > 0 && cells[r - 1][c] == true)
                    neighbors++;

                // top right
                if (r > 0 && c < cs - 1 && cells[r - 1][c + 1])
                    neighbors++;

                // right
                if (c < cs - 1 && cells[r][c + 1] == true)
                    neighbors++;

                // bottom right
                if (r < rs - 1 && c < cs - 1 && cells[r + 1][c + 1] == true)
                    neighbors++;

                // below
                if (r < rs - 1 && cells[r + 1][c] == true)
                    neighbors++;

                // bottom left
                if (c > 0 && r < rs - 1 && cells[r + 1][c - 1])
                    neighbors++;

                // left
                if (c > 0 && cells[r][c - 1] == true)
                    neighbors++;

                // RULES:
                // 1. if a living cell has <= 1 neighbor, it will die
                // 2. if a living cell has 2 or 3 neighbors, it will live
                // 3. if a living cell has >= 4 neighbors, it will die
                // 4. if a dead cell has exactly 3 neighbors, it will be reborn

                if (cells[r][c] == true) {
                    if (neighbors == 2 || neighbors == 3) {
                        newCells[r][c] = true;
                    }
                } else {
                    if (neighbors == 3) {
                        newCells[r][c] = true;
                    }
                }

            }

        }

        return newCells;
    }

}
