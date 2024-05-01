package Debugs.Arrays.ContainerWithMostWater;

import java.util.Arrays;

public class ContainerWithMostWater_Approach1 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        containerMostWater(height);
    }

    private static void containerMostWater(int[] height) {
        int maxOverall = Integer.MIN_VALUE;
        int maxCurrent ;

        for(int i=0; i<height.length; i++){
            for(int j=i+1; j<height.length; j++){

                if(height[i] >= height[j]){
                    maxCurrent = height[j] * (j-i);

                    if(maxCurrent > maxOverall){
                        maxOverall = maxCurrent;
                    }
                }
                if(height[i] < height[j]){
                    maxCurrent = height[i]*(j-i);

                    if(maxCurrent > maxOverall){
                        maxOverall = maxCurrent;
                    }
                }
            }
        }

        System.out.println("Maximum amount of water in an container = "+maxOverall);
    }
}
