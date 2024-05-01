package Debugs.Arrays.MissingNumberInArray;

public class missingNumberInArray_Approach2 {
    public static void main(String[] args) {
        System.out.println("Approach using Addition");
        int[] arr = {9,6,4,2,3,5,7,0,1};
        missingNumber(arr);
    }

    private static void missingNumber(int[] arr) {
        int sum = 0;
        System.out.println("\nStep 1 : Adding all the element of the array to get the actual sum");
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            System.out.println("\tAdding " + arr[i] + " to the sum. Current sum: " + sum);
        }
        System.out.println("Actual sum = "+sum);

        System.out.println("\nStep 2 : comparing expected sum and the actual sum");
        int expectedSum = arr.length * (arr.length + 1) / 2;
        System.out.println("Expected sum = " + expectedSum);
        System.out.println("Actual sum = "+sum);
        int missingNum = expectedSum - sum;
        System.out.println("So, missing number = Expected sum - Actual sum");
        System.out.println("Missing number = " + missingNum);
    }
}
