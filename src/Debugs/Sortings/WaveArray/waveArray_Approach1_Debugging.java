package Debugs.Sortings.WaveArray;

import java.util.Arrays;

public class waveArray_Approach1_Debugging {
    public static void main(String[] args) {
        int[] nums = {2,4,7,8,9,10};
        waveArray(nums);
    }

    private static void waveArray(int[] nums) {
        int k = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println("\nLoop iteration : "+k);
            // Find the maximum and minimum elements between consecutive pairs
            int maxi = Math.max(nums[i], nums[i + 1]);
            int mini = Math.min(nums[i], nums[i + 1]);
            // Print the current pair of elements and their maximum and minimum values
            System.out.println("\tChecking for pair at indices " + i + " and " + (i + 1) + ": [" + nums[i] + ", " + nums[i + 1] + "]");
            System.out.println("\tMax value = " + maxi + ", Min value = " + mini);
            // Swap the elements to create the wave pattern
            System.out.println("\tPutting max value at index = "+i+" and min value at index = "+(i+1));
            nums[i] = maxi;
            nums[i + 1] = mini;
            // Print the array after each swap
            System.out.println("\tArray after swapping: " + Arrays.toString(nums));
            // Increment i by 1 to move to the next pair of elements
            i++;
            k++;
        }

        System.out.println("\nWave array: " + Arrays.toString(nums));
    }
}
