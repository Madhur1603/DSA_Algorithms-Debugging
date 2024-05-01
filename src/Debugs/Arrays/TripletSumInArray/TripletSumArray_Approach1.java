package Debugs.Arrays.TripletSumInArray;

public class TripletSumArray_Approach1 {
    public static void main(String[] args) {
        int[] arr = {1,4,45,6,10,8};
        int x = 13;
        tripletSum(arr,x);
    }

    private static void tripletSum(int[] arr, int x) {
        int count = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                for(int k=j+1; k<arr.length; k++){
                    if(arr[i] + arr[j] + arr[k] == x){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
