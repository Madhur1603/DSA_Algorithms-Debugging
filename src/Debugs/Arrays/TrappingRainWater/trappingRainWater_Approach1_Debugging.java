package Debugs.Arrays.TrappingRainWater;

import java.util.Arrays;

public class trappingRainWater_Approach1_Debugging {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        trappingWater(nums);
    }

    private static void trappingWater(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int sum = 0;

        left[0] = nums[0];

        // Calculate the maximum height of buildings to the left of each index
        System.out.println("\nStep 1 : Calculate the maximum height of buildings to the left of each index");
        for (int i = 1; i < nums.length; i++) {
            left[i] = Math.max(left[i - 1], nums[i]);
        }
        System.out.println("Left array: " + Arrays.toString(left));

        right[nums.length - 1] = nums[nums.length - 1];

        // Calculate the maximum height of buildings to the right of each index
        System.out.println("\nStep 2 : Calculate the maximum height of buildings to the right of each index");
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], nums[i]);
        }
        System.out.println("Right array: " + Arrays.toString(right));

        // Calculate the amount of water trapped between the buildings
        System.out.println("\nStep 3 : Calculate the amount of water trapped between the buildings");
        for (int i = 0; i < nums.length; i++) {
            System.out.println("\nLoop iteration : "+(i+1));
            System.out.println("\tComparing left["+i+"] = "+left[i]+" and right["+i+"] = "+right[i]+"");
            System.out.println("\tand giving the minimum from both to variable named : min");
            int min = Math.min(left[i], right[i]);
            System.out.println("\tSo, min = "+min);
            System.out.println("\tNow, sum = sum + (min - nums["+i+"])");
            System.out.println("\tSo, sum = "+sum+" + ("+min+" - "+nums[i]+")");
            sum = sum + (min - nums[i]);
            System.out.println("\tsum = "+sum);

        }

        System.out.println("\nTotal trapped water: " + sum);
    }
}
