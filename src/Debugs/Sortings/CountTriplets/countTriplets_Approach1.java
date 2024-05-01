package Debugs.Sortings.CountTriplets;

import java.util.ArrayList;

public class countTriplets_Approach1 {
    public static void main(String[] args) {
        int[] nums = {2,4,6,8,10};
        countTripletsOutput(nums);
    }

    private static void countTripletsOutput(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;

        for(int i=0 ;i<nums.length; i++){
            list.add(nums[i]);
        }
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                sum = nums[i] + nums[j];
                if(list.contains(sum)){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
