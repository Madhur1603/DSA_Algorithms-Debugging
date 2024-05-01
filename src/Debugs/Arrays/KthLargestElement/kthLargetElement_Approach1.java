package Debugs.Arrays.KthLargestElement;

import java.util.ArrayList;
import java.util.Arrays;

// Doing this using sorting
public class kthLargetElement_Approach1 {
    public static void main(String[] args) {
        System.out.println("Solution using Sorting");
        System.out.println();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int x = findKthLargestElement(nums,k);
        System.out.println(x);
    }

    private static int findKthLargestElement(int[] nums, int k) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                list.add(nums[i]);
            }
        }
        System.out.println(list);
        return list.get(list.size() - k);
    }
}
