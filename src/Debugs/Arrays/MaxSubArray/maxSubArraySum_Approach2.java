package Debugs.Arrays.MaxSubArray;

public class maxSubArraySum_Approach2 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubarraySumBruteForce(nums);
    }

    private static void maxSubarraySumBruteForce(int[] nums) {
        // n is the number of length
        int n = nums.length;
        System.out.println("Length of the array is : "+n);

        // Initially letting max sub-array sum as 0
        int maxSubArray = 0;
        System.out.println("Initially letting maxSubArray = 0");

        System.out.println("Starting of Program");
        for (int i = 0; i < n; i++) {
            System.out.println();
            int slidingwindowsum = 0;
            System.out.println("Outer loop with i = " + i);
            System.out.println("\t Initialising slidingwindowsum = 0");
            for (int j = i+1; j < n; j++) {
                System.out.println("\t Inner loop with j = i+1 = "+i+"+1 = "+j);
                System.out.println("\t\t slidingwindowsum = slidingwindowsum + nums["+j+"] = "+slidingwindowsum+" + "+nums[j]);
                slidingwindowsum = slidingwindowsum + nums[j];
                System.out.println("\t\t slidingwindowsum = " + slidingwindowsum);
                if (slidingwindowsum > maxSubArray) {
                    System.out.println("\t\t (slidingwindowsum > maxSubArray) -> true , as slidingwindowsum = "+slidingwindowsum+" is greater then maxSubArray = "+maxSubArray);
                    maxSubArray = slidingwindowsum;
                    System.out.println("\t\t Hence maxSubArray = slidingwindowsum , so maxSubArray = " + maxSubArray);
                }
                else{
                    System.out.println("\t\t (slidingwindowsum > maxSubArray) -> false, as slidingwindowsum = "+slidingwindowsum+" and maxSubArray = "+maxSubArray+" , so maxSubArray is not change");
                }
            }
        }
        System.out.println();
        System.out.println("Final maxSubArray value: " + maxSubArray);
    }
}
