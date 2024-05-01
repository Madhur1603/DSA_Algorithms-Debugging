package Debugs.Arrays.MaxSubArray;

public class maxSubArraySum_Approach1 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        // This is approach - 1
//        maxSubarraySumOptimal(nums);
        // This is approach - 2
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

    private static void maxSubarraySumOptimal(int[] nums) {
        // n is the number of length
        int n = nums.length;
        System.out.println("Length of the array is : "+n);

        // We take the initial sum as 0
        int sum = 0;
        System.out.println("letting initial sum of the array as : "+sum);

        // We take the initial maxSubArray as minimum value
        int maxSubArraySum = Integer.MIN_VALUE;
        System.out.println("We take the initial maxSubArraySum as minimum integer value = "+maxSubArraySum);

        int arrayStart = 0;
        int arrayEnd = 0;
        System.out.println("Letting arrayStart as : "+arrayStart+" and arrayEnd as : "+arrayEnd);
        int start = 0;

        System.out.println();
        System.out.println("Starting of program");
        for(int i=0; i<n; i++){
            System.out.println();
            System.out.println("Loop iteration : " +(i+1));
            System.out.println("i = "+i);

            // Over here we set the start as the initialiser to find form where our sub-array is starting.
            if(sum == 0){
                start = i;
                System.out.println("As sum = 0, so start value = i, hence start = "+i);
            }
            else{
                System.out.println("As sum is not equal to 0, so start value remains same as : " +start);
            }

            // we take the first as the
            System.out.println("sum = sum + nums["+i+"] = "+sum+" + "+nums[i]);
            sum = sum + nums[i];
            System.out.println("sum = "+sum);

            // Here we check if the sum is greater then our maxSubArray then put the value of sum in maxSubArray
            if(sum > maxSubArraySum){
                System.out.println("(sum > maxSubArraySum) -> true , means here sum = "+sum+" is greater then maxSubArraySum = "+maxSubArraySum);
                maxSubArraySum = sum;
                System.out.println("\t Hence maxSubArraySum is updated to : "+sum);
                arrayStart = start;
                System.out.println("\t And sub-array start index, arrayStart = start, arrayStart = "+arrayStart);
                arrayEnd = i;
            }
            else{
                System.out.println("(sum > maxSubArraySum) -> false , means here sum = "+sum+" is less then maxSubArraySum = "+maxSubArraySum+", so no change.");
            }

            // If the sum is lower then 0 then we dont want it to carry forward as it will only decrease out our sum(as initially if sum = -2 then if we add -1 to it it will only get decrese)
            if(sum < 0){
                System.out.println("(sum < 0) -> true , means here sum = "+sum+" is less then 0, so sum = 0");
                sum = 0;
            }
            else{
                System.out.println("Here sum = "+sum+" is greater then 0, so no change in sum.");
            }
        }

        System.out.println();
        System.out.println("Printing the final result : ");
        System.out.println("Sum of max sub-array = "+maxSubArraySum);
        System.out.println("Sub-array start index = "+arrayStart);
        System.out.println("Sub-array end index = "+arrayEnd);
    }
}
