package Debugs.Arrays.ProductArrayPuzzle;

import java.util.Arrays;

public class productArrayPuzzle_Approach1 {
    public static void main(String[] args) {
        int[] nums = {12,0};
        productArray(nums);
    }

    private static void productArray(int[] nums) {
        int[] ans  = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int product = 1;
            for(int j=0; j<nums.length; j++){
                if(j != i){
                    product = product * nums[j];
                }
            }
            ans[i] = product;
        }
        System.out.println(Arrays.toString(ans));
    }
}
