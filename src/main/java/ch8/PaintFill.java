package ch8;

public class PaintFill {

    enum Color {
        Black,
        White,
        Red,
        Yellow,
        Green;
    }

    boolean paintFill(Color [][] screen, int r, int c, Color ncolor) {
        if (screen[r][c] == ncolor) return false;
        return paintFill(screen, r, c, screen[r][c], ncolor);
    }

    boolean paintFill(Color [][] screen, int r, int c, Color ocolor, Color nColor) {
        if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) {
            return false;
        }

        if (screen[r][c] == ocolor) {
            screen[r][c] = nColor;
            paintFill(screen, r - 1, c, ocolor, nColor); // up
            paintFill(screen, r + 1, c, ocolor, nColor); // down
            paintFill(screen, r, c - 1, ocolor, nColor); // left
            paintFill(screen, r, c + 1, ocolor, nColor); //right
        }
        return true;
    }

    public static void main(String[] args) {
        PaintFill paintFill = new PaintFill();
        Color [][] matrix = {
                {Color.White, Color.White, Color.White},
                {Color.White, Color.Green, Color.White},
                {Color.White, Color.White, Color.White},
        };

        boolean b = paintFill.paintFill(matrix, 1, 1, Color.Black);
        System.out.println(b);

    }
}
