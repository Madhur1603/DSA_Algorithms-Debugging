package Debugs.Arrays.KthLargestElement;

import java.util.ArrayList;
import java.util.Arrays;

public class kthLargetElement_Approach1_Debugging {
    public static void main(String[] args) {
        System.out.println("Solution using Sorting");
        System.out.println();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int x = findKthLargestElement(nums, k);
        System.out.println();
        System.out.println("Kth largest element = " + x);
    }

    private static int findKthLargestElement(int[] nums, int k) {
        // Sort the array
        Arrays.sort(nums);
        System.out.println("Step 1 : Sort the actual array");
        System.out.println("Sorted array: " + Arrays.toString(nums));
        System.out.println();
        System.out.println("Step 2 : Remove duplicates and store unique elements in a list");
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("initialize an ArrayList named : list");
        list.add(nums[0]);
        System.out.println("Add nums[0] to arraylist");
        System.out.println("So our arraylist, list = "+list);
        for (int i = 1; i < nums.length; i++) {
            System.out.println();
            System.out.println("Loop iteration : "+i);
            if (nums[i] != nums[i - 1]) {
                System.out.println("if (nums["+i+"] != nums["+(i - 1)+"]) -> true, means nums["+i+"] = "+nums[i]+" is not equal to nums["+(i - 1)+"] = "+nums[i-1]+"");
                System.out.println("So we add nums["+i+"] to list");
                list.add(nums[i]);
                System.out.println("Updated list = "+list);
            }
        }
        System.out.println("Unique elements list: " + list);

        // Find the kth largest element from the unique elements list
        System.out.println();
        System.out.println("Step 3 : Find the kth largest element from the unique elements list");
        System.out.println("Get the element at the kth positon from end of the list and store it into a variable");
        int kthLargest = list.get(list.size() - k);
        System.out.println("kthLargest = list.get(list.size() - k) -> means geting element at the position = "+list.size()+" - "+k+" = "+(list.size()-k)+"");
        System.out.println("Hence kthLargest = "+kthLargest);
        return kthLargest;
    }
}
