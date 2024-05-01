package Debugs.Arrays.KadanesAlgorithm;

public class kadanesAlgorithm_Debugging {
    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, -4};
        kadanesAlgoMax(arr);
    }

    private static void kadanesAlgoMax(int[] arr) {
        int sum = 0;
        int currentStart = 0;
        int indexStart = 0;
        int indexEnd = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            System.out.println("Loop iteration : "+(i+1));
            if(sum == 0){
                System.out.println("\tif(sum == 0) -> true, means now we have to re-initialize the currentStart.");
                currentStart = i;
                System.out.println("\tso now currentStart = "+currentStart);
            }
            System.out.println();
            System.out.println("\tsum = sum + arr["+i+"] = "+sum+" + "+arr[i]);
            sum += arr[i];
            System.out.println("\tsum = "+sum);

            if (sum > max) {
                System.out.println();
                System.out.println("\tif (sum > max) -> true, means sum = "+sum+" is greater then max = "+max);
                max = sum;
                System.out.println("\tSo we update max, max = "+sum);
                indexStart = currentStart;
                indexEnd = i;
                System.out.println("\tSo index start = " + indexStart+" and index end = "+ indexEnd);
            }
            else {
                System.out.println();
                System.out.println("\tif (sum > max) -> false, means sum = "+sum+" is not greater then max = "+max);
                System.out.println("\tSo sum remains same ");
            }

            if (sum < 0) {
                System.out.println();
                System.out.println("\tif (sum < 0) -> true, means sum = "+sum+" is smaller then 0");
                sum = 0;
                System.out.println("\tSum is negative. Hence Resetting sum = 0");
            }
        }

        System.out.println();
        System.out.println("Results :");
        System.out.println("Max sum = " + max);
        System.out.println("Starting index of subarray for max sum = " + indexStart);
        System.out.println("Ending index of subarray for max sum = " + indexEnd);
    }

}
