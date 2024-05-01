package Debugs.Sortings.SortArrayZeroOneTwo;

import java.util.Arrays;

public class sortZeroOneTwo_Approach1 {
    public static void main(String[] args) {
        int[] nums = {0,2,1,2,0,1,1};
        sortedArray(nums);
    }

    private static void sortedArray(int[] nums) {
        int k = 0;
        for(int i=0; i<3; i++){
            for(int j=k; j<nums.length; j++){
                if(nums[j] == i){
                    int temp = nums[k];
                    nums[k] = nums[j];
                    nums[j] = temp;
                    k++;
                }
            }
        }

        System.out.println(Arrays.toString(nums));

    }
}
