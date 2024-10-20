package Debugs.Trees.FindFirstAndLastOccuranceInSortedArray;

import java.util.Arrays;

public class FirstAndLastOccuranceSortedArray {
    public static void main(String[] args) {
        int[] nums = {2, 4, 4, 4, 6, 7, 9};
        int target = 4;
        int[] index = occuranceRange(nums, target);
        System.out.println(Arrays.toString(index));
    }

    private static int[] occuranceRange(int[] nums, int target) {
        int[] index = {-1,-1};
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            if(nums[left] == target && nums[right] == target){
                index[0] = left;
                index[1] = right;
                break;
            }
            if(nums[left] != target){
                left++;
            }
            if(nums[right] != target){
                right--;
            }
        }

        return index;
    }
}
