package Debugs.Arrays.RemoveDuplicateElementsFromSortedArray;

import java.util.Arrays;

public class removeDuplicateElements_Approach1_Debugging {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,2,2,3,3,3,4,4};
        lengthOfNewArrayWithoutDuplicacy(nums);
    }

    private static void lengthOfNewArrayWithoutDuplicacy(int[] nums) {
        int count = 1;
        System.out.println("Initial count: " + count);

        for (int i = 1; i < nums.length; i++) {
            System.out.println("\nLoop Iteration : " + i);
            if (nums[i] != nums[i - 1]) {
                System.out.println("\tif (nums["+i+"] != nums["+(i - 1)+"]) -> true, means nums["+i+"] = "+nums[i]+" is not equal to nums["+(i-1)+"] = "+nums[i-1]+"");
                System.out.println("\thence the element are not same means we can update the count");
                nums[count] = nums[i];
                count++;
                System.out.println("\tUpdated count: " + count);
            }
            else{
                System.out.println("\tif (nums["+i+"] != nums["+(i - 1)+"]) -> false, means nums["+i+"] = "+nums[i]+" is equal to nums["+(i-1)+"] = "+nums[i-1]+"");
                System.out.println("\tSo, we keep iterating without updating count");
            }
        }


        System.out.println("\nFinal count of element without duplicates = " + count);
    }
}
