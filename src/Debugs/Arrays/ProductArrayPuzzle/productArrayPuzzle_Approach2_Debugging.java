package Debugs.Arrays.ProductArrayPuzzle;

import java.util.Arrays;

public class productArrayPuzzle_Approach2_Debugging {
    public static void main(String[] args) {
        int[] nums = {10,3,5,6,2};
        productArray(nums);
    }

    private static void productArray(int[] nums) {
        int[] ans = new int[nums.length];
        System.out.println("Step 0 : Initialize the an array named: ans");

        // Initialize the first element of ans array as 1
        System.out.println("Initialize the first element of ans array as 1, ans[0] = 1");
        ans[0] = 1;

        // Calculate prefix products
        System.out.println("\nStep 1 : Calculate prefix products");
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
            System.out.println("\tPrefix product for index " + i + ": " + ans[i]);
        }

        System.out.println("Prefix products = " + Arrays.toString(ans));

        System.out.println("\nStep 2 : Calculate suffix products and update ans array");
        // Initialize suffix as 1
        int suffix = 1;
        System.out.println("Initial suffix value: " + suffix);


        for (int j = nums.length - 1; j >= 0; j--) {
            System.out.println("\n\tans["+j+"] = ans["+j+"] * suffix = "+ans[j]+" * "+suffix+"");
            ans[j] = ans[j] * suffix;
            System.out.println("\tUpdated ans[" + j + "] = " + ans[j]);
            System.out.println("\tsuffix = suffix * nums["+j+"] = "+suffix+" * "+nums[j]+"");
            suffix = suffix * nums[j];
            System.out.println("\tUpdated suffix value = " + suffix);
        }

        System.out.println("\nFinal product array = " + Arrays.toString(ans));
    }
}
