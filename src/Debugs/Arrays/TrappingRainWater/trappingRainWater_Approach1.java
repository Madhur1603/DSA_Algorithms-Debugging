package Debugs.Arrays.TrappingRainWater;

public class trappingRainWater_Approach1 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        trappingWater(nums);
    }

    private static void trappingWater(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int sum = 0;

        left[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            left[i] = Math.max(left[i-1], nums[i]);
        }

        right[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            right[i] = Math.max(right[i+1],nums[i]);
        }

        for(int i=0; i<nums.length; i++){
            sum = sum + (Math.min(left[i], right[i]) - nums[i]);
        }

        System.out.println(sum);
    }
}
