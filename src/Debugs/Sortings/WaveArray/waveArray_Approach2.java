package Debugs.Sortings.WaveArray;

import java.util.Arrays;

public class waveArray_Approach2 {
    public static void main(String[] args) {
        int[] nums = {2,4,7,8,9,10};
        waveArray(nums);
    }

    private static void waveArray(int[] nums) {

        for(int i=0; i<nums.length; i+=2){
            if(i>0 && nums[i] < nums[i-1]){
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
            if(nums[i] < nums[i+1] && i<nums.length-1){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }

        }
        System.out.println(Arrays.toString(nums));
    }
}
