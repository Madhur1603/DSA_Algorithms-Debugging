package Debugs.Sortings.WaveArray;

import java.util.Arrays;

public class waveArray_Approach1 {
    public static void main(String[] args) {
        int[] nums = {2,4,7,8,9,10};
//        int[] nums = {10, 5, 6, 3, 2, 20, 100, 80};
        waveArray(nums);
    }

    private static void waveArray(int[] nums) {

        for(int i=0; i<nums.length-1; i++){
            int maxi = Math.max(nums[i], nums[i+1]);
            int mini = Math.min(nums[i], nums[i+1]);
            nums[i] = maxi;
            nums[i+1] = mini;
            i++;
        }

        System.out.println(Arrays.toString(nums));
    }
}
