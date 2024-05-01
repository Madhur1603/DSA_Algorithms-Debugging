package Debugs.Sortings.WaveArray;

import java.util.Arrays;

public class waveArray_Approach2_Debugging {
    public static void main(String[] args) {
        int[] nums = {2,4,7,8,9,10};
        waveArray(nums);
    }

    private static void waveArray(int[] nums) {
        int k=1;
        for (int i = 0; i < nums.length; i += 2) {
            System.out.println("\nLoop iteration : "+k);
            // Check if the current index is greater than 0 and the current element is less than the previous element
            if (i > 0 && nums[i] < nums[i - 1]) {
                System.out.println("\tif(i > 0 && nums["+i+"] < nums["+(i - 1)+"]) -> true, as i="+i+" and nums["+i+"] = "+nums[i]+" , nums["+(i-1)+"] = "+nums[i-1]);
                System.out.println("\tSwapping elements at indices " + i + " and " + (i - 1));
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
                System.out.println("\tArray after swapping: " + Arrays.toString(nums));
            }
            // Check if the current element is less than the next element and if it's not the last element
            if (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                System.out.println("\tif(i < "+(nums.length - 1)+" && nums["+i+"] < nums["+(i + 1)+"]) -> true, as i="+i+" and nums["+i+"] = "+nums[i]+" , nums["+(i+1)+"] = "+nums[i+1]);
                System.out.println("\tSwapping elements at indices " + i + " and " + (i + 1));
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                System.out.println("\tArray after swapping: " + Arrays.toString(nums));
            }
            k++;
        }
        System.out.println("\nWave array: " + Arrays.toString(nums));
    }
}
