package Debugs.Sortings.TripletSumEqualZero;

import java.util.Arrays;

public class tripletSumEqualZero_Approach1 {
    public static void main(String[] args) {
        int[] nums = {0,-1,-1,2};
        tripletSumZero(nums);
    }

    private static void tripletSumZero(int[] nums) {
        int sum = 0;
        boolean count = false;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[i] + nums[k] + nums[j] == sum){
                        count = true;
                        break;
                    }
                }
                if(count == true){
                    break;
                }
            }
            if(count == true){
                break;
            }
        }

        System.out.println(count);
    }
}
