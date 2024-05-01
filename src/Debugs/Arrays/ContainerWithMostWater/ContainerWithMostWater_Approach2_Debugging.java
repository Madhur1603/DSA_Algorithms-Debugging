package Debugs.Arrays.ContainerWithMostWater;

// This is an optimal approach
public class ContainerWithMostWater_Approach2_Debugging {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        containerMostWater(height);
    }

    private static void containerMostWater(int[] height) {
        int maxCurrent;
        System.out.println("Initialising maxCurrent");
        int maxOverall = Integer.MIN_VALUE;
        System.out.println("Initialising maxOverall = "+maxOverall);
        int leftPointer = 0;
        System.out.println("Initialising leftPointer = "+leftPointer);
        int rightPointer = height.length - 1;
        System.out.println("Initialising rightPointer = "+rightPointer);
        int i = 0;
        while(leftPointer < rightPointer){
            System.out.println();
            System.out.println("Loop "+(i+1)+" :");
            System.out.println("(leftPointer < rightPointer) -> true , as leftPointer = "+leftPointer+" is less then rightPointer = "+rightPointer);
            if(height[leftPointer] <= height[rightPointer]){
                System.out.println("\t (height[leftPointer] <= height[rightPointer]) -> true , as height[leftPointer] = height["+leftPointer+"] = "+height[leftPointer]+" is less then or equal to height[rightPointer] = height["+rightPointer+"] = "+height[rightPointer]);
                System.out.println("\t maxCurrent = height[leftPointer] * (rightPointer - leftPointer) = height["+leftPointer+"] * ("+rightPointer+" - "+leftPointer+") = "+height[leftPointer]+" * ("+rightPointer+" - "+leftPointer+")");
                maxCurrent = height[leftPointer]*(rightPointer - leftPointer);
                System.out.println("\t So maxCurrent = "+maxCurrent);
                if(maxCurrent > maxOverall){
                    System.out.println("\t\t (maxCurrent > maxOverall) -> true , as maxCurrent = "+maxCurrent+" is greater then maxOverall = "+maxOverall);
                    maxOverall = maxCurrent;
                    System.out.println("\t\t So maxOverall = maxCurrent , maxOverall = "+maxOverall);
                }
                else{
                    System.out.println("\t\t (maxCurrent > maxOverall) -> false , as maxCurrent = "+maxCurrent+" is less then maxOverall = "+maxOverall);
                    System.out.println("\t\t So maxOverall = "+maxOverall+" , does not change");
                }
                leftPointer++;
                System.out.println("\t\t Now we increase leftPointer = leftPointer + 1 = "+(leftPointer-1)+" + 1  = "+leftPointer);
            }
            if(height[leftPointer] > height[rightPointer]){
                System.out.println("\t (height["+leftPointer+"] > height["+rightPointer+"]) -> true , as height[leftPointer] = "+height[leftPointer]+" is greater then to height[rightPointer] = "+height[rightPointer]);
                System.out.println("\t maxCurrent = height[rightPointer] * (rightPointer - leftPointer) = height["+rightPointer+"] * ("+rightPointer+" - "+leftPointer+") = "+height[rightPointer]+" * ("+rightPointer+" - "+leftPointer+")");
                maxCurrent = height[rightPointer]*(rightPointer - leftPointer);
                System.out.println("\t So maxCurrent = "+maxCurrent);
                if(maxCurrent > maxOverall){
                    System.out.println("\t\t (maxCurrent > maxOverall) -> true , as maxCurrent = "+maxCurrent+" is greater then maxOverall = "+maxOverall);
                    maxOverall = maxCurrent;
                    System.out.println("\t\t So maxOverall = maxCurrent , maxOverall = "+maxOverall);
                }
                else{
                    System.out.println("\t\t (maxCurrent > maxOverall) -> false , as maxCurrent = "+maxCurrent+" is less then maxOverall = "+maxOverall);
                    System.out.println("\t\t So maxOverall = "+maxOverall+" , does not change");
                }
                rightPointer--;
                System.out.println("\t\t Now we decrease rightPointer = rightPointer - 1 = "+(rightPointer+1)+" - 1 = "+rightPointer);
            }
            i++;
        }
        System.out.println();
        System.out.println("Most Water in Container  = "+maxOverall);
    }
}
