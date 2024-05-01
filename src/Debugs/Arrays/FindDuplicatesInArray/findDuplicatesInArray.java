package Debugs.Arrays.FindDuplicatesInArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class findDuplicatesInArray {
    public static void main(String[] args) {
//        int[] arr = {4,3,2,7,8,3,2,1};
        int[] arr = {5,5,6,6,7,7,8,8,9};
        duplicatesInArray(arr);
    }

    private static void duplicatesInArray(int[] arr) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int x : arr){
            if(!set.add(x)){
                result.add(x);
            }
        }
        System.out.println(result);
    }
}
