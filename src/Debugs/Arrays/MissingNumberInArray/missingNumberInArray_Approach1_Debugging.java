package Debugs.Arrays.MissingNumberInArray;

import java.util.Arrays;

public class missingNumberInArray_Approach1_Debugging {
    public static void main(String[] args) {
        System.out.println("Approach using Sorting");
        int[] arr = {9,6,4,2,3,5,7,0,1};
        missingNumber(arr);
    }

    private static void missingNumber(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        int element = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("\nLoop iteration : "+(i+1));
            System.out.println("\tProcessing element at index " + i + ": " + arr[i]);

            if (arr[i] != i) {
                System.out.println("\tif(arr["+i+"] != "+i+") -> true, as arr["+i+"] = "+arr[i]+" is not equal to the index i = "+i);
                element = i;
                System.out.println("\tHence, Mismatch found at index " + i + ". Missing number: " + element);
                break;
            } else if (arr[arr.length - 1] == i) {
                element = i + 1;
                System.out.println("\tReached end of array. Missing number: " + element);
                break;
            }
            else{
                System.out.println("\tMatching found, as arr["+i+"] = "+arr[i]+" is equal to the index i = "+i);
                System.out.println("\tHence, keep iterating");
            }
        }

        System.out.println("\nFinal missing number: " + element);
    }
}
