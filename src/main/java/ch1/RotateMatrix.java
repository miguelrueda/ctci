package ch1;

public class RotateMatrix {

    boolean rotate (int [][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) return false;

        int n = matrix.length;
        System.out.println("Matrix length" + n);
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            System.out.println("First " + layer);
            int last = n - 1 - layer;
            System.out.println("Last " + last);
            for (int i = first; i < last; i++) {
                int offset = i - first;
                System.out.println("Offset " + offset);
                int top = matrix[first][i]; // save top
                System.out.println("Top " + top);

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
        return true;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int [][] imageMatrix = {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
        };

        printMatrix(imageMatrix);

        RotateMatrix rotateMatrix = new RotateMatrix();
        rotateMatrix.rotate(imageMatrix);

        printMatrix(imageMatrix);
    }

}
