package Debugs.Sortings.InsertionSort;

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] nums = {2,3,4,1,5,6};
        sorting(nums);
    }

    private static void sorting(int[] nums) {
        for(int i=1; i<nums.length; i++){
            int j = i-1;
            int key = nums[i];

            while(j>=0 && nums[j] > key){
                nums[j+1] = nums[j];
                j--;
            }

            nums[j+1] = key;
        }

        System.out.println(Arrays.toString(nums));
    }
}
