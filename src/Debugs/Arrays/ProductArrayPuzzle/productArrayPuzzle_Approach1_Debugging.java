package Debugs.Arrays.ProductArrayPuzzle;

import java.util.Arrays;

public class productArrayPuzzle_Approach1_Debugging {
    public static void main(String[] args) {
        int[] nums = {12,0};
        productArray(nums);
    }

    private static void productArray(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            System.out.println("\nOuter loop iteration " + (i + 1));
            for (int j = 0; j < nums.length; j++) {
                System.out.println("\tInner loop iteration " + (j + 1));

                if (j != i) {
                    System.out.println("\t\tif(j != i) -> true, means j = "+j+" is not equal to i = "+i+"");
                    System.out.println("\t\tproduct = product * nums["+j+"] = "+product+" * "+nums[j]+"");
                    product *= nums[j];
                    System.out.println("\t\tProduct updated to " + product);
                }
                else{
                    System.out.println("\t\tif(j != i) -> false, means j = "+j+" is equal to i = "+i+"");
                    System.out.println("\t\tSo, no change to product");
                }
            }

            ans[i] = product;
            System.out.println("\tProduct for index " + i + " = " + product);
        }

        System.out.println("\nFinal product array: " + Arrays.toString(ans));
    }
}
