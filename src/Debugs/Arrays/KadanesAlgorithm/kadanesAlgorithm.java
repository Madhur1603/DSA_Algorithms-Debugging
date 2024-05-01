package Debugs.Arrays.KadanesAlgorithm;

public class kadanesAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, -4};
        kadanesAlgoMax(arr);
    }

//    private static void kadanesAlgoMax(int[] arr) {
//        int sum = 0;
//        int start = 0;
//        int indexStart = 0;
//        int indexEnd = 0;
//        int max = Integer.MIN_VALUE;
//        for(int i=0; i<arr.length; i++){
//            if(sum == 0){
//                start = i;
//            }
//
//            sum = sum + arr[i];
//            if(sum > max){
//                max = sum;
//                indexStart = start;
//                indexEnd = i;
//            }
//
//            if(sum < 0){
//                sum = 0;
//            }
//        }
//
//        System.out.println("Max sum = "+max);
//        System.out.println("Index start = "+indexStart);
//        System.out.println("Index end = "+indexEnd);
//    }

    private static void kadanesAlgoMax(int[] arr) {
        int sum = 0;
        int currentStart = 0;
        int indexStart = 0;
        int indexEnd = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(sum == 0){
                currentStart = i;// Reset currentStart when sum becomes negative
            }

            sum = sum + arr[i];
            if (sum > max) {
                max = sum;
                indexStart = currentStart;
                indexEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.println("Max sum = " + max);
        System.out.println("Index start = " + indexStart);
        System.out.println("Index end = " + indexEnd);
    }

}
