package Debugs.Arrays.MissingNumberInArray;

import java.util.Arrays;

public class missingNumberInArray_Approach1 {
    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};
        missingNumber(arr);
    }

    private static void missingNumber(int[] arr) {
        Arrays.sort(arr);
        int element = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != i){
                element = i;
                break;
            }
            else if(arr[arr.length-1] == i){
                element = i+1;
                break;
            }
        }
        System.out.println(element);
    }
}
