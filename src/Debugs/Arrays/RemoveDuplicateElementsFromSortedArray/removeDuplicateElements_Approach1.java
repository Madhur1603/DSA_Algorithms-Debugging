package Debugs.Arrays.RemoveDuplicateElementsFromSortedArray;

public class removeDuplicateElements_Approach1 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,2,2,3,3,3,4,4};
        lengthOfNewArrayWithoutDuplicacy(nums);
    }

    private static void lengthOfNewArrayWithoutDuplicacy(int[] nums) {
        int count = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[count] = nums[i];
                count++;
            }
        }
        System.out.println(count);
    }
}
