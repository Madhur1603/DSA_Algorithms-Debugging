package Debugs.Sortings.InsertionSort;

import java.util.Arrays;

public class insertionSort_Debugging {
    public static void main(String[] args) {
        int[] nums = {2,3,4,1,5,6};
        sorting(nums);
    }

    private static void sorting(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            System.out.println("\nLoop iteration : "+i);
            int j = i - 1;
            int key = nums[i];
            // Store the current element as key
            System.out.println("\tCurrent element (key): " + key);
            // Print the array before each iteration
            System.out.println("\tArray before iteration " + i + ": " + Arrays.toString(nums));

            // Move elements of nums[0..i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && nums[j] > key) {
                System.out.println("\tShifting " + nums[j] + " to the right");
                nums[j + 1] = nums[j];
                j--;
                // Print the array after each shift
                System.out.println("\tArray after shifting: " + Arrays.toString(nums));
            }

            // Place the key at the correct position in the sorted array
            nums[j + 1] = key;
            System.out.println("\tPlacing key (" + key + ") at index " + (j + 1) + " in the array");

            // Print the array after each iteration
            System.out.println("\tArray after iteration " + i + ": " + Arrays.toString(nums));
        }

        System.out.println("\nSorted array: " + Arrays.toString(nums));
    }
}
