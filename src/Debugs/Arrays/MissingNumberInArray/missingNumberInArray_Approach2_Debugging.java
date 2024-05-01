package Debugs.Arrays.MissingNumberInArray;

public class missingNumberInArray_Approach2_Debugging {
    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};
        missingNumber(arr);
    }

    private static void missingNumber(int[] arr) {
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];
        }
        int actualSum = arr.length * (arr.length + 1) / 2;

        System.out.println(actualSum - sum);
    }
}
