package Debugs.Sortings.BubbleSort;

import java.util.Arrays;

public class bubbleSort_Debugging {
    public static void main(String[] args) {
        int[] nums = {2,0,1};
        bubbleSorting(nums);
    }

    private static void bubbleSorting(int[] nums) {
        System.out.println("Original array: " + Arrays.toString(nums));

        // Iterate through the array to place the largest element at its correct position
        System.out.println("Step 1 : Iterate through the array to place the largest element at its correct position");
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println("\nLoop iteration : "+(i+1));
            // Check if the current element is greater than the next element
            if (nums[i] > nums[i + 1]) {
                System.out.println("\tif(nums["+i+"] > nums["+(i + 1)+"]) -> true, as "+nums[i]+" is greater then "+nums[i+1]+"");
                // Swap the elements
                System.out.println("\thence, we swap the element");
                int temp = nums[i + 1];
                nums[i + 1] = nums[i];
                nums[i] = temp;
                System.out.println("\tSwapping " + nums[i] + " and " + nums[i + 1] + ", Array: " + Arrays.toString(nums));
            }
        }

        System.out.println("\nSorted array: " + Arrays.toString(nums));
    }
}
