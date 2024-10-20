package Debugs.Queue.KthLargestSumContiguousSubarray;

import java.util.PriorityQueue;

public class kthLargestSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 2, 0, 5}; //1, 3, 1, 2, 0, 5
        int k = 2;
        int result = kthLargestSubArraySum(arr, k);

        System.out.println(result);
    }

    private static int kthLargestSubArraySum(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int sum = 0;

        for(int i=0; i<arr.length; i++){
            sum = 0;
            for(int j=i; j<arr.length; j++){
                sum = sum + arr[j];

                if(minHeap.size() < k){
                    minHeap.add(sum);
                }
                else if(minHeap.peek() < sum){
                    minHeap.poll();
                    minHeap.add(sum);
                }
            }
        }

        return minHeap.peek();
    }
}
