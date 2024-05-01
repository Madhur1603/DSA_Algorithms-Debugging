package Debugs.Arrays.SubarraysWhereMaxElementAppearsKTimes;

public class subarrayCountMaxElement_Debugging {
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,3};
        int k = 2;
        countSubarrayWithMaxElement(nums,k);
    }

    private static void countSubarrayWithMaxElement(int[] nums, int k) {
        int maxi = Integer.MIN_VALUE;
        // Finding the maximum element in the array
        for (int i = 0; i < nums.length; i++) {
            maxi = Math.max(maxi, nums[i]);
        }
        System.out.println("Maximum element: " + maxi);

        int start = 0;
        int end = 0;
        long count = 0;
        int maxElementFrequency = 0;

        while (end < nums.length) {
            // Expansion phase
            System.out.println("\nExpansion Phase:");
            if (nums[end] == maxi) {
                maxElementFrequency++;
                System.out.println("Max element found at index " + end + ". Frequency: " + maxElementFrequency);
            }
            System.out.println("End index: " + end);
            // Shrinking phase
            while (maxElementFrequency == k) {
                // Counting subarrays
                System.out.println("\nShrinking Phase:");
                System.out.println("Max element frequency meets condition. Counting subarrays...");
                count = count + nums.length - end;
                System.out.println("Count: " + count);
                if (nums[start] == maxi) {
                    maxElementFrequency--;
                    System.out.println("Max element removed at index " + start + ". Frequency: " + maxElementFrequency);
                }
                start++;
                System.out.println("Start index: " + start);
            }
            end++;
        }

        System.out.println("\nTotal count of subarrays with maximum element appearing " + k + " times: " + count);
    }
}
