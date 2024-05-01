package Debugs.Sortings.CountTriplets;

import java.util.ArrayList;

public class countTriplets_Approach1_Debugging {
    public static void main(String[] args) {
        int[] nums = {2,4,6,8,10};
        countTripletsOutput(nums);
    }

    private static void countTripletsOutput(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Initializing an ArrayList named list, and add all elements of given array to this list");
        int count = 0;

        // Add elements of the array to the list
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        System.out.println("List: " + list);

        System.out.println("\nStep 1 : Iterate through each pair of elements");
        // Iterate through each pair of elements
        for (int i = 0; i < nums.length; i++) {
            System.out.println("\nLoop iteration : "+(i+1));
            for (int j = i + 1; j < nums.length; j++) {
                // Calculate the sum of the pair
                System.out.println("\n\tInner loop ");
                int sum = nums[i] + nums[j];
                System.out.println("\tsum = nums["+i+"] + nums["+j+"]");
                System.out.println("\tsum = "+nums[i] + " + " + nums[j] + " = " + sum);
                // Check if the sum exists in the list
                if (list.contains(sum)) {
                    System.out.println("\t\tif(list.contains("+sum+")) -> true, means list contains the sum = "+sum);
                    System.out.println("\t\tTriplet found: " + nums[i] + ", " + nums[j] + ", " + sum +", as "+ nums[i] +" + "+ nums[j] +" = "+sum);
                    count++;
                    System.out.println("\t\tIncrement count = count + 1 = "+count);
                }
            }
        }

        System.out.println("\nTotal number of triplets in the array = " + count);
    }
}
