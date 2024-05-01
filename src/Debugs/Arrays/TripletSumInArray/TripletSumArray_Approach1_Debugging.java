package Debugs.Arrays.TripletSumInArray;

public class TripletSumArray_Approach1_Debugging {
    public static void main(String[] args) {
        int[] arr = {1,4,45,6,10,8};
        int x = 13;
        tripletSum(arr,x);
    }

    private static void tripletSum(int[] arr, int x) {
        System.out.println("Need to find a triplet which sum give = "+x);
        int count = 0;
        // Iterate through each possible triplet
        System.out.println("\nIterating through each possible triplet :");
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("\nLoop iteration "+(i+1));
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    // Check if the sum of the triplet equals x
                    int sum = arr[i] + arr[j] + arr[k];
                    System.out.println("\tChecking triplet (" + arr[i] + ", " + arr[j] + ", " + arr[k] + ") with sum = " + sum);
                    if (sum == x) {
                        count++;
                        System.out.println("!! Triplet found: (" + arr[i] + ", " + arr[j] + ", " + arr[k] + ") !!");
                    }
                    else{
                        System.out.println("\tTriplet not with required sum.");
                    }
                }
            }
        }
        System.out.println("\nTotal number of triplets with sum " + x + ": " + count);
    }
}
