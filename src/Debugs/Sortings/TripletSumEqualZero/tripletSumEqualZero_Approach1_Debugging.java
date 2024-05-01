package Debugs.Sortings.TripletSumEqualZero;

public class tripletSumEqualZero_Approach1_Debugging {
    public static void main(String[] args) {
        int[] nums = {0,-1,-1,2};
        tripletSumZero(nums);
    }

    private static void tripletSumZero(int[] nums) {
        int l = 1;
        boolean count = false;
        // Outer loop iterates over all elements of nums
        for (int i = 0; i < nums.length; i++) {
            // Inner loop iterates over elements after the current element
            for (int j = i + 1; j < nums.length; j++) {
                // Another inner loop iterates over elements after the second element
                for (int k = j + 1; k < nums.length; k++) {
                    System.out.println("\nLoop iteration : "+l);
                    System.out.println("\tThree elements are : nums["+i+"] = "+nums[i]+" , nums["+j+"] = "+nums[j]+" , nums["+k+"] = "+nums[k]);
                    System.out.println("\tsum = nums["+i+"] + nums["+j+"] + nums["+k+"] = "+nums[i]+" + "+nums[j]+" + "+nums[k]);
                    System.out.println("\tsum = "+(nums[i] + nums[j] + nums[k]));
                    // Check if the sum of the current triplet equals zero
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        System.out.println("\tAs we can see sum is equal to 0");
                        System.out.println("\tTriplets are : "+nums[i]+", "+nums[j]+", "+nums[k]);
                        System.out.println("\tStop iterating");
                        // If the sum is zero, set count to true and break out of the innermost loop
                        count = true;
                        break;
                    }
                    else{
                        System.out.println("\tAs we can see sum is not equal to 0");
                    }
                    l++;
                }
                // If count is true, break out of the second loop
                if (count) {
                    break;
                }
            }
            // If count is true, break out of the outer loop
            if (count) {
                break;
            }
        }
        // Print the value of count
        System.out.println("\nDoes array have triplets equal to 0 : "+count);
    }
}
