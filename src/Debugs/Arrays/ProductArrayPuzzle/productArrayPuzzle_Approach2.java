package Debugs.Arrays.ProductArrayPuzzle;

import java.util.Arrays;

public class productArrayPuzzle_Approach2 {
    public static void main(String[] args) {
        int[] nums = {10,3,5,6,2};
        productArray(nums);
    }

    private static void productArray(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for(int i=1; i<nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        System.out.println(Arrays.toString(ans));
        int suffix = 1;
        for(int j=nums.length-1; j>=0; j--){
            ans[j] = ans[j] * suffix;
            suffix = suffix * nums[j];
        }

        System.out.println(Arrays.toString(ans));
    }
}
