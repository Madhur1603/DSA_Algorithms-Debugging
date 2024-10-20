package Debugs.Queue.KthLargestSumContiguousSubarray;

import java.util.PriorityQueue;

public class kthLargestSum_Debugging {
    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 2, 0, 5}; //1, 3, 1, 2, 0, 5
        int k = 2;
        int result = kthLargestSubArraySum(arr, k);

        System.out.println(result);
    }

    private static int kthLargestSubArraySum(int[] arr, int k) {
        // We use a PriorityQueue (Min Heap) to store the k largest sums
        System.out.println("\nInitializing : ");
        System.out.println("minHeap = new PriorityQueue<>(), because in this queue, elements are ordered based on their natural order (smallest first).");
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // sum will hold the sum of the subarray
        System.out.println("sum = 0;");
        int sum = 0;

        System.out.println("\nStarting the algorithm to find the " + k + "-th largest subarray sum.");

        // Outer loop will consider every possible starting point of subarrays
        int iterate = 1;
        System.out.println("Starting for-loop from 0 to arr.length = "+(arr.length-1));
        for (int i = 0; i < arr.length; i++) {
            System.out.println("\nOuter Loop : "+iterate);
            System.out.println("\tConsidering subarrays starting at index " + i + " (value: " + arr[i] + ").");

            // Reset sum to 0 for each new subarray starting at index i
            sum = 0;

            // Inner loop will consider every possible ending point of subarrays starting from index i
            int inner = 1;
            for (int j = i; j < arr.length; j++) {
                System.out.println("\n\tInner Loop : "+inner);
                // Incrementally add arr[j] to the current sum of the subarray
                System.out.println("\t\tsum = sum + arr["+j+"] = "+sum+" + "+arr[j]+", adding element at index " + j + " (value: " + arr[j] + ").");
                sum = sum + arr[j];
                System.out.println("\t\tsum = "+sum+", means new subarray sum from index " + i + " to index " + j + " is : " + sum);

                // If the heap size is less than k, directly add the sum to the heap
                if (minHeap.size() < k) {
                    System.out.println("\t\t\tif(minHeap.size() < k) -> true, means size of minHeap = "+minHeap.size()+" is smaller then k = "+k);
                    minHeap.add(sum);
                    System.out.println("\t\t\tminHeap.add(sum), minHeap size is less than " + k + ". Adding sum: " + sum);
                }
                // Otherwise, check if the current sum is larger than the smallest element in the heap
                else if (minHeap.peek() < sum) {
                    System.out.println("\t\t\tif(minHeap.peek() < sum) -> true, means peek of minHeap = "+minHeap.peek()+" is smaller then sum = "+sum);
                    int smallestSumInHeap = minHeap.peek();
                    System.out.println("\t\t\tSo, smallestSumInHeap = minHeap.peek() = "+smallestSumInHeap);
                    System.out.println("\t\t\tCurrent sum " + sum + " is larger than the smallest sum in the heap (" + smallestSumInHeap + ").");
                    System.out.println("\t\t\tminHeap.poll(), remove the smallest sum in the heap.");
                    minHeap.poll();
                    System.out.println("\t\t\tRemoved smallest sum: " + smallestSumInHeap);
                    // Add the new larger sum to the heap
                    minHeap.add(sum);
                    System.out.println("\t\t\tAdded new sum: " + sum);
                }

                // Print the current state of the heap after each addition
                System.out.println("\t\tCurrent heap: " + minHeap.toString());
                inner++;
            }
            iterate++;
        }

        // The root of the heap will be the k-th largest sum
        System.out.println("\nThe " + k + "-th largest subarray sum is: " + minHeap.peek());

        // Return the k-th largest sum
        return minHeap.peek();
    }

}
