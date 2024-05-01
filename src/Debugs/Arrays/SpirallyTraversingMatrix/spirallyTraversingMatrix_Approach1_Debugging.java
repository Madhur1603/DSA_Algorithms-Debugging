package Debugs.Arrays.SpirallyTraversingMatrix;

import java.util.ArrayList;

public class spirallyTraversingMatrix_Approach1_Debugging {
    public static void main(String[] args) {
        int[][] input = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        spiralTraversing(input);
    }

    private static void spiralTraversing(int[][] input) {
        ArrayList<Integer> list = new ArrayList<>();
        int row = input.length;
        int col = input[0].length;
        System.out.println("Rows: " + row + ", Cols: " + col);
        int k = 0;
        int right = col - 1, left = 0, top = 0, bottom = row - 1, direction = 0;

        while (top <= bottom && left <= right) {
            System.out.println("\nLoop iteration : "+(k+1));
            System.out.println("\tDirection = " + direction);
            if (direction == 0) {
                System.out.println("\tMoving right from (" + top + ", " + left + ") to (" + top + ", " + right + ")");
                for (int i = left; i <= right; i++) {
                    System.out.println("\tAdding " + input[top][i] + " to the list");
                    list.add(input[top][i]);
                }
                direction = 1;
                top++;
            } else if (direction == 1) {
                System.out.println("\tMoving down from (" + top + ", " + right + ") to (" + bottom + ", " + right + ")");
                for (int i = top; i <= bottom; i++) {
                    System.out.println("\tAdding " + input[i][right] + " to the list");
                    list.add(input[i][right]);
                }
                direction = 2;
                right--;
            } else if (direction == 2) {
                System.out.println("\tMoving left from (" + bottom + ", " + right + ") to (" + bottom + ", " + left + ")");
                for (int i = right; i >= left; i--) {
                    System.out.println("\tAdding " + input[bottom][i] + " to the list");
                    list.add(input[bottom][i]);
                }
                direction = 3;
                bottom--;
            } else if (direction == 3) {
                System.out.println("\tMoving up from (" + bottom + ", " + left + ") to (" + top + ", " + left + ")");
                for (int i = bottom; i >= top; i--) {
                    System.out.println("\tAdding " + input[i][left] + " to the list");
                    list.add(input[i][left]);
                }
                direction = 0;
                left++;
            }
            k++;
            System.out.println("Current list: " + list);
        }

        System.out.println("\nFinal spiral traversal list: " + list);
    }
}
