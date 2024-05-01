package Debugs.Arrays.RemoveDuplicateElementsFromSortedArray;

import java.util.ArrayList;

public class removeDuplicateElements_Approach2_Debugging {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,2,2,3,3,3,4,4};
        lengthOfNewArrayWithoutDuplicacy(nums);
    }

    private static void lengthOfNewArrayWithoutDuplicacy(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                list.add(nums[i]);
            }
        }
        System.out.println(list.size());
    }
}
