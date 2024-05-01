package Debugs.Arrays.IntersectionTwoArrays;

import java.util.HashSet;

public class intersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {7,7,7,7,7};
        int[] arr2 = {7,7,7,7};
        intersectionCount(arr1,arr2);
    }

    private static void intersectionCount(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int j=0; j<arr2.length; j++){
            if(set.contains(arr2[j])){
                set.remove(arr2[j]);
                count++;
            }
        }

        System.out.println(count);
    }
}
