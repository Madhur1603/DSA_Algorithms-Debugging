package Debugs.Sortings.BubbleSort;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] nums = {2,0,1};
        bubbleSorting(nums);
    }

    private static void bubbleSorting(int[] nums) {
        // placing the first largest element at correct position
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                int temp = nums[i+1];
                nums[i+1] = nums[i];
                nums[i] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
