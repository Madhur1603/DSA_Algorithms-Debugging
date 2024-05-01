package Debugs.Arrays.KthLargestElement;

import java.util.PriorityQueue;

public class kthLargetElement_Approach2_Debugging {
    public static void main(String[] args) {
        System.out.println("Solution using Priority Queue");
        System.out.println();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        findKthLargestElement(nums,k);
    }

    private static void findKthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int j = 0;

        // Add the first k elements to the priority queue
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        System.out.println("Priority Queue after adding first " + k + " elements: " + pq);

        // Iterate over the remaining elements and maintain the priority queue with k largest elements
        for (int i = k; i < nums.length; i++) {
            System.out.println();
            System.out.println("Loop iteration : "+(j+1));
            System.out.println("\tProcessing element: " + nums[i]);
            System.out.println("\tCurrent priority queue: " + pq);

            // If the current element is larger than the smallest element in the priority queue,
            // remove the smallest element and add the current element
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
                System.out.println("\tUpdated priority queue after adding element: " + pq);
            }
            j++;
        }

        // Print the final priority queue and the kth largest element
        System.out.println("\nFinal priority queue: " + pq);
        System.out.println("Kth largest element: " + pq.peek());
    }
}
