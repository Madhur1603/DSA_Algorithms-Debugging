package Debugs.Arrays.ContainerWithMostWater;

public class ContainerWithMostWater_Approach2 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        containerMostWater(height);
    }

    private static void containerMostWater(int[] height) {
        int maxCurrent;
        int maxOverall = Integer.MIN_VALUE;
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int i = 0;
        while(leftPointer < rightPointer){

            if(height[leftPointer] <= height[rightPointer]){
                maxCurrent = height[leftPointer]*(rightPointer - leftPointer);

                if(maxCurrent > maxOverall){
                    maxOverall = maxCurrent;
                }

                leftPointer++;
            }

            if(height[leftPointer] > height[rightPointer]){
                maxCurrent = height[rightPointer]*(rightPointer - leftPointer);
                if(maxCurrent > maxOverall){
                    maxOverall = maxCurrent;
                }

                rightPointer--;
            }
            i++;
        }

        System.out.println("Maximum amount of water in an container  = "+maxOverall);
    }
}
