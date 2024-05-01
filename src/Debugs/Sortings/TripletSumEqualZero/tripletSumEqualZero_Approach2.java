package Debugs.Sortings.TripletSumEqualZero;

import java.util.Arrays;

public class tripletSumEqualZero_Approach2 {
    public static void main(String[] args) {
        int[] nums = {-1,-1,0,2};
        tripletSumZero(nums);

    }

    private static void tripletSumZero(int[] nums) {
        boolean count = false;
        int sum = 0;
        Arrays.sort(nums);
        for(int i=nums.length-1; i>=2; i--){
            int l = 0;
            int r = i-1;
            while(l<r){
                if(sum == (nums[i] + nums[l] + nums[r])){
                    count=true;
                    break;
                }
                else if(sum > (nums[i] + nums[l] + nums[r])){
                    l++;
                }
                else{
                    r--;
                }
            }
            if(count == true){
                break;
            }
        }
        System.out.println(count);
    }
}
