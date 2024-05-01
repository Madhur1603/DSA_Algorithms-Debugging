package Debugs.Arrays.SubarrayGivenSum;

import java.util.ArrayList;
import java.util.HashMap;

public class subarrayGivenSum_Approach1 {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int S = 2;
        subarrayGivenSum(nums,S);
    }

    private static void subarrayGivenSum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        map.put(0,1);
        list.add(0);

        int startIndex = -1;
        int endIndex = -1;
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            list.add(sum);
            if(map.containsKey(sum - k)){
                startIndex = list.indexOf(sum-k)+1;
                endIndex = i+1;
                break;
            }
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        System.out.println(list);
        System.out.println(map);

        System.out.println("Start Position = "+startIndex);
        System.out.println("End Position = "+endIndex);
    }
}