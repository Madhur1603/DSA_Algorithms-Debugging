package Debugs.Arrays.TripletSumInArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumArray_Approach2_Debugging {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int x = 0;
        tripletSum(arr,x);
    }

    private static void tripletSum(int[] nums, int x) {
        ArrayList<List<Integer>> finalList = new ArrayList<>();
        System.out.println("Initializing an ArrayList named : finalList");

        // Sort the array
        System.out.println("\nStep 1 : Sort the given array");
        Arrays.sort(nums);
        System.out.println("Sorted array: " + Arrays.toString(nums));

        // Iterate through possible three elements from the array
        System.out.println("\nStep 2 : Iterate through possible three elements from the array that sum to give = "+x);
        int k = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            System.out.println("\nLoop iteration : "+k);
            int l = 0;
            int r = i - 1;
            System.out.println("\tInitializing i = "+i);
            System.out.println("\tInitializing l = 0");
            System.out.println("\tInitializing r = i-1 = "+r);
            int y=0;
            // Use two pointers to find pairs that sum up to x - nums[i]
            while (l < r) {
                System.out.println("\tInner loop : "+(y+1));
                if (nums[l] + nums[r] + nums[i] == x) {
                    int sum = nums[l] + nums[r] + nums[i];
                    System.out.println("\tif(nums["+l+"] + nums["+r+"] + nums["+i+"] == "+x+") -> true, means "+nums[l]+" + "+nums[r]+" + "+nums[i]+" = "+sum);
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[l]);
                    list.add(nums[r]);
                    list.add(nums[i]);
                    finalList.add(list);
                    System.out.println("\tTriplet found: (" + nums[l] + ", " + nums[r] + ", " + nums[i] + ")");
                    // Move the pointers to skip duplicate elements
                    while (l < r && nums[l] == nums[l + 1]){
                        System.out.println("\t\tDuplicates found nums[l] == nums[(l + 1)], as nums["+l+"] = "+nums[l]+" is equal to nums["+(l+1)+"] = "+nums[l+1]+"");
                        l++;
                        System.out.println("\t\tSo we increment l = l + 1 = "+l);
                    }
                    while (l < r && nums[r] == nums[r - 1]){
                        System.out.println("\t\tDuplicates found nums[r] == nums[(r - 1)], as nums["+r+"] = "+nums[r]+" is equal to nums["+(r-1)+"] = "+nums[r-1]+"");
                        r--;
                        System.out.println("\t\tSo we decrement r = r - 1 = "+r);
                    }
                    l++;
                    r--;
                    System.out.println("\t\tDecrement r = r - 1 = "+r);
                    System.out.println("\t\tIncrement l = l + 1 = "+l);
                } else if (nums[l] + nums[r] + nums[i] > x) {
                    int sum = nums[l] + nums[r] + nums[i];
                    System.out.println("\t\tif(nums["+l+"] + nums["+r+"] + nums["+i+"] > "+x+") -> true, means "+nums[l]+" + "+nums[r]+" + "+nums[i]+" = "+sum+" is greater then "+x);
                    r--;
                    System.out.println("\t\tSo we decrement r = r - 1 = "+r);
                } else {
                    int sum = nums[l] + nums[r] + nums[i];
                    System.out.println("\t\tif(nums["+l+"] + nums["+r+"] + nums["+i+"] < "+x+") -> true, means "+nums[l]+" + "+nums[r]+" + "+nums[i]+" = "+sum+" is smaller then "+x);
                    l++;
                    System.out.println("\t\tSo we increment l = l + 1 = "+l);
                }
                y++;
            }
            // Skip duplicate third elements
            while (i >= 1 && nums[i] == nums[i - 1]){
                System.out.println("\t\tDuplicates found nums[i] == nums[i - 1)], as nums["+i+"] = "+nums[i]+" is equal to nums["+(i-1)+"] = "+nums[i-1]+"");
                i--;
                System.out.println("\t\tSo we decrement r = r - 1 = "+r);
            }
            k++;
        }

        System.out.println("\nFinal triplets: " + finalList);
    }
}
