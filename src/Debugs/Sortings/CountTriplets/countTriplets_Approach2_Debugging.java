package Debugs.Sortings.CountTriplets;

import java.util.Arrays;

public class countTriplets_Approach2_Debugging {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        countTripletsOutput(nums);
    }

    private static void countTripletsOutput(int[] nums) {
        int count = 0;
        System.out.println("\nStep 1 : Sort the given array");
        // Sort the array
        Arrays.sort(nums);
        System.out.println("Sorted array: " + Arrays.toString(nums));

        int k = 1;
        System.out.println("\nStep 2 : Iterate through possible three elements from the array");
        // Iterate through possible third elements from the end of the array
        for (int i = nums.length - 1; i >= 2; i--) {
            System.out.println("\nLoop iteration : "+k);
            int l = 0;
            int r = i - 1;

            // Use two pointers to find pairs that sum up to the third element
            while (l < r) {
                System.out.println("\tChecking pair (" + nums[l] + ", " + nums[r] + ")");
                if (nums[l] + nums[r] == nums[i]) {
                    System.out.println("\tnums["+l+"] + nums["+r+"] == nums["+i+"], means "+ nums[l] +" + "+ nums[r] +" = "+ nums[i] +"");
                    count++;
                    System.out.println("\tTriplet found: (" + nums[l] + ", " + nums[r] + ", " + nums[i] + "), Hence count = count + 1 = "+count);
                    l++;
                    r--;
                    System.out.println("\tIncrement l by 1 : l = "+l);
                    System.out.println("\tDecrement r by 1 : r = "+r);
                } else if (nums[l] + nums[r] < nums[i]) {
                    System.out.println("\tnums["+l+"] + nums["+r+"] < nums["+i+"], means "+ nums[l] +" + "+ nums[r] +" = "+(nums[l] + nums[r])+" < "+ nums[i] +"");
                    l++;
                    System.out.println("\tIncrement l by 1 : l = "+l);
                } else {
                    System.out.println("\tnums["+l+"] + nums["+r+"] > nums["+i+"], means "+ nums[l] +" + "+ nums[r] +" = "+(nums[l] + nums[r])+" > "+ nums[i] +"");
                    r--;
                    System.out.println("\tDecrement r by 1 : r = "+r);
                }
            }
            k++;
        }
        System.out.println("\nTotal number of triplets: " + count);
    }
}
