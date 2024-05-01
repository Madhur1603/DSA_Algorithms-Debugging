package Debugs.Arrays.ContainerWithMostWater;

import java.util.Arrays;

// This is a brute force approach
public class ContainerWithMostWater_Approach1_Debugging {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        containerMostWater(height);
    }

    private static void containerMostWater(int[] height) {
        System.out.println("Given array , height = "+ Arrays.toString(height));
        int maxOverall = Integer.MIN_VALUE;
        System.out.println("Initialising maxOverall as the smallest integer possible , maxOverall = "+maxOverall);
        int maxCurrent = 0;
        System.out.println("Initialising maxCurrent = "+maxCurrent);
        for(int i=0; i<height.length; i++){
            System.out.println();
            if(i != height.length-1){
                System.out.println("Outer loop i = "+(i+1));
            }
            for(int j=i+1; j<height.length; j++){
                System.out.println();
                System.out.println("\t Inner loop j = "+(j+1));
                if(height[i] >= height[j]){
                    System.out.println("\t ( height["+i+"] >= height["+j+"] ) -> true , as height["+i+"] = "+height[i]+" is greater or equal to height["+j+"] = "+height[j]+"");
                    System.out.println("\t maxCurrent = height["+j+"] * (j - i) = "+height[j]+" * ("+j+" - "+i+")");
                    maxCurrent = height[j] * (j-i);
                    System.out.println("\t So, maxCurrent = "+maxCurrent);
                    if(maxCurrent > maxOverall){
                        System.out.println("\t ( maxCurrent > maxOverall ) -> true , as maxCurrent = "+maxCurrent+" is greater then maxOverall = "+maxOverall+"");
                        maxOverall = maxCurrent;
                        System.out.println("\t So maxOverall = maxCurrent , maxOverall = "+maxOverall);
                    }
                    else{
                        System.out.println("\t ( maxCurrent > maxOverall ) -> false , as maxCurrent = "+maxCurrent+" is less then maxOverall = "+maxOverall+"");
                        System.out.println("\t So maxOverall = "+maxOverall+" , does not change");
                    }
                }
                if(height[i] < height[j]){
                    System.out.println("\t ( height["+i+"] < height["+j+"] ) -> true , as height["+i+"] = "+height[i]+" is less then to height["+j+"] = "+height[j]+"");
                    System.out.println("\t maxCurrent = height["+i+"] * (j - i) = "+height[i]+" * ("+j+" - "+i+")");
                    maxCurrent = height[i]*(j-i);
                    System.out.println("\t So, maxCurrent = "+maxCurrent);
                    if(maxCurrent > maxOverall){
                        System.out.println("\t ( maxCurrent > maxOverall ) -> true , as maxCurrent = "+maxCurrent+" is greater then maxOverall = "+maxOverall+"");
                        maxOverall = maxCurrent;
                        System.out.println("\t So maxOverall = maxCurrent ,  maxOverall = "+maxOverall);
                    }
                    else{
                        System.out.println("\t ( maxCurrent > maxOverall ) -> false , as maxCurrent = "+maxCurrent+" is less then maxOverall = "+maxOverall+"");
                        System.out.println("\t So maxOverall = "+maxOverall+" , does not change");
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Maximum amount of water in an container = "+maxOverall);
    }
}
