package Debugs.Arrays.TripletSumInArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumArray_Approach2 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int x = 0;
        tripletSum(arr,x);
    }

    private static void tripletSum(int[] nums, int x) {
        ArrayList<List<Integer>> finalList = new ArrayList<>();

        Arrays.sort(nums);

        // here we are comparing it from 2 becasue we gave starting 2 numbers to l and r
        for(int i=nums.length-1; i>=2; i--){
            int l=0;
            int r = i-1;
            while(l < r){
                List<Integer> list = new ArrayList<>();
                if(nums[l] + nums[r] + nums[i] == x){
                    list.add(nums[l]);
                    list.add(nums[r]);
                    list.add(nums[i]);
                    finalList.add(list);
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
                else if(nums[l] + nums[r] + nums[i] > x){
                    r--;
                }
                else{
                    l++;
                }
            }
            while (i >= 1 && nums[i] == nums[i - 1]) i--;
        }

        System.out.println(finalList);
    }
}
