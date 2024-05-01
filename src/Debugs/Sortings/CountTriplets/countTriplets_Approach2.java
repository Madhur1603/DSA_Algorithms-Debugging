package Debugs.Sortings.CountTriplets;

import java.util.ArrayList;
import java.util.Arrays;

public class countTriplets_Approach2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        countTripletsOutput(nums);
    }

    private static void countTripletsOutput(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        for(int i=nums.length-1; i>=2; i--){
            int l=0;
            int r = i-1;

            while(l<r){
                if(nums[l] + nums[r] == nums[i]){
                    count++;
                    l++;
                    r--;
                }
                else if(nums[l] + nums[r] < nums[i]){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        System.out.println(count);
    }
}
