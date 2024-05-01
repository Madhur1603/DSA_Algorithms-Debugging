package Debugs.Arrays.SpirallyTraversingMatrix;

import java.util.ArrayList;

public class spirallyTraversingMatrix_Approach1 {
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
        int right = col-1, left = 0, top = 0, bottom = row-1, direction=0;

        while(top<=bottom && left<=right){
            if(direction == 0){
                for(int i=left; i<=right; i++){
                    list.add(input[top][i]);
                }
                direction=1;
                top++;
            }
            else if(direction == 1){
                for(int i=top; i<=bottom; i++){
                    list.add(input[i][right]);
                }
                direction=2;
                right--;
            }
            else if(direction == 2){
                for(int i=right; i>=left; i--){
                    list.add(input[bottom][i]);
                }
                direction = 3;
                bottom--;
            }
            else if(direction == 3){
                for(int i=bottom; i>=top; i--){
                    list.add(input[i][left]);
                }
                direction = 0;
                left++;
            }
        }
        System.out.println(list);
    }
}
