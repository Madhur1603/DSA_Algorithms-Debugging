package Debugs.Arrays.SubarraysWhereMaxElementAppearsKTimes;

import java.util.HashMap;

public class subarrayCountMaxElement {
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,3};
        int k = 2;
        countSubarrayWithMaxElement(nums,k);
    }

    private static void countSubarrayWithMaxElement(int[] nums, int k) {
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
        }

        int start = 0;
        int end = 0;
        long count = 0;
        int maxElementFrequency = 0;

        while(end<nums.length){
            // expansion
            if(nums[end] == maxi){
                maxElementFrequency++;
            }
            // shrinking
            while(maxElementFrequency == k){
                count = count + nums.length-end;
                if(nums[start] == maxi){
                    maxElementFrequency--;
                }
                start++;
            }
            end++;
        }

        System.out.println(count);
    }
}
