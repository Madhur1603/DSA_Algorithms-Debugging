package Debugs.Sortings.TripletSumEqualZero;

import java.util.Arrays;

public class tripletSumEqualZero_Approach2_Debugging {
    public static void main(String[] args) {
        System.out.println("Approach Using Sorting");
        int[] nums = {-2,1,4,-3,5,0};
        tripletSumZero(nums);

    }

    private static void tripletSumZero(int[] nums) {
        boolean count = false;
        int sum = 0;
        Arrays.sort(nums);
        System.out.println("\nStep 1 : Sort the given array");
        System.out.println("Sorted array: " + Arrays.toString(nums));

        int k = 1;
        int m = 1;
        System.out.println("\nStep 2 : Checking for triplets");
        for (int i = nums.length - 1; i >= 2; i--) {
            System.out.println("\nOuter Loop iteration : "+m);
            int l = 0;
            int r = i - 1;
            System.out.println("Initializing l = 0, r = i - 1 = "+r);
            while (l < r) {
                System.out.println("\n\tLoop iteration : "+k);
                System.out.println("\t\twhile (l < r) -> true, as l = "+l+", r = "+r);
                System.out.println("\t\tChecking sum for element at index's : "+i+", "+l+", "+r);
                sum = nums[i] + nums[l] + nums[r];
                System.out.println("\t\tsum = nums["+i+"] + nums["+l+"] + nums["+r+"] = "+nums[i]+", " + nums[l]+", " + nums[r]);
                System.out.println("\t\tsum = "+sum);
                if (sum == 0) {
                    count = true;
                    System.out.println("\t\tTriplet found!");
                    break;
                } else if (sum < 0) {
                    System.out.println("\t\tif(sum < 0) -> true, as sum = "+sum);
                    l++;
                    System.out.println("\t\tIncrement l = l + 1 = "+l);
                } else {
                    System.out.println("\t\tif(sum > 0) -> true, as sum = "+sum);
                    r--;
                    System.out.println("\t\tDecrement r = r - 1 = "+r);
                }
                k++;
            }
            if (count) {
                break;
            }
            m++;
        }
        System.out.println("\nResult: " + count);
    }
}
