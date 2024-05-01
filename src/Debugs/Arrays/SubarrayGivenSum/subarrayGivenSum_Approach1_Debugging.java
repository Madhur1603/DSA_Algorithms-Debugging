package Debugs.Arrays.SubarrayGivenSum;

import java.util.ArrayList;
import java.util.HashMap;

public class subarrayGivenSum_Approach1_Debugging {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2};
        int S = 4;
        subarrayGivenSum(nums,S);
    }

    private static void subarrayGivenSum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println("initializing HashMap named : map");
        map.put(0, 1);
        System.out.println("putting value = 1 in at key = 0");
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("initializing ArrayList named : list");
        list.add(0);
        System.out.println("adding 0 to list");


        int startIndex = -1;
        System.out.println("initializing start index : -1");
        int endIndex = -1;
        System.out.println("initializing end index : -1");
        int sum = 0;
        System.out.println("initializing sum : 0");

        for (int i = 0; i < nums.length; i++) {
            System.out.println("\nLoop iteration : "+(i+1));
            System.out.println("\tsum = sum + nums["+i+"] = "+sum+" + "+nums[i]+"");
            sum += nums[i];
            System.out.println("\tsum = "+sum);

            System.out.println("\tAdd this sum = "+sum+" into the list");
            list.add(sum);
            System.out.println("\tUpdated list: " + list);

            if (map.containsKey(sum - k)) {
                System.out.println("\tif(map.containsKey(sum - "+k+")) -> true, means map contains a key = "+sum+" - "+k+" = "+(sum-k)+" ");
                startIndex = list.indexOf(sum - k) + 1;
                endIndex = i + 1;
                System.out.println("\tFound subarray with sum " + k + " from index " + (startIndex-1) + " to " + (endIndex-1));
                break;
            }
            System.out.println("\tAdding key = "+sum+" in map and incrementing its value");
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            System.out.println("\tCurrent map: " + map);
        }

        System.out.println("\nStart Position = " + startIndex);
        System.out.println("End Position = " + endIndex);
    }
}
