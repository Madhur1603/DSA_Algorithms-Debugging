package Debugs.Sortings.SortArrayZeroOneTwo;

import java.util.Arrays;

public class sortZeroOneTwo_Approach1_Debugging {
    public static void main(String[] args) {
        int[] nums = {0, 2,2,2,2,2, 1, 2, 0, 1, 1};
        System.out.println("Original array: " + Arrays.toString(nums));
        sortedArray(nums);
    }

    private static void sortedArray(int[] nums) {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("\nLoop iteration : "+i);
            System.out.println("\tProcessing for element = " + i );
            for (int j = k; j < nums.length; j++) {
                System.out.println("\tChecking element at index " + j + " = " + nums[j]);
                if (nums[j] == i) {
                    System.out.println("\t\tEqual to currently processing element " + i);
                    // Swap the element at index k with the element at index j
                    System.out.println("\t\tswapping the element of index's : "+j+" with "+k);
                    int temp = nums[k];
                    nums[k] = nums[j];
                    nums[j] = temp;
                    k++;
                    System.out.println("\t\tArray after swapping: " + Arrays.toString(nums));
                }
                else{
                    System.out.println("\t\tNot equal to the currently processing element = "+i);
                }
            }
        }

        System.out.println("\nSorted array: " + Arrays.toString(nums));
    }
}
