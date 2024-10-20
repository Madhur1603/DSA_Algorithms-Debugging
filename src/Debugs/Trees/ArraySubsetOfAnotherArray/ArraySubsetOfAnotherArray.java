package Debugs.Trees.ArraySubsetOfAnotherArray;

import java.util.HashMap;
import java.util.Map;

public class ArraySubsetOfAnotherArray {
    public static void main(String[] args) {
        int[] arr1 = {11, 1,1, 13, 21, 3, 7};
        int[] arr2 = {11, 1,1};
        boolean ans = isSubset(arr1, arr2);
        System.out.println(ans);
    }

    private static boolean isSubset(int[] arr1, int[] arr2) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr1.length; i++){
            map.put(arr1[i], map.getOrDefault(arr1[i], 0)+1);
        }

        for(int i=0; i<arr2.length; i++){
            if(map.get(arr2[i]) > 0){
                map.put(arr2[i],map.get(arr2[i]) - 1);
            }
            else{
                return false;
            }
        }


        return true;



//        boolean[] flag = new boolean[arr1.length];
//
//        int count = 0;
//
//        for(int i=0; i<arr2.length; i++){
//            for(int j=0; j<arr1.length; j++){
//                if(flag[j] == true) continue;
//                if(arr2[i] == arr1[j]){
//                    flag[j] = true;
//                    count++;
//                }
//            }
//        }
//
//        if(count == arr2.length){
//            ans = true;
//        }
//
//        return ans;
    }
}
