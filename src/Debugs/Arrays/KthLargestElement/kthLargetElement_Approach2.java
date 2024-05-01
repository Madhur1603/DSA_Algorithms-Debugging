package Debugs.Arrays.KthLargestElement;

import java.util.PriorityQueue;

// Doing this using priority queue
public class kthLargetElement_Approach2 {
    public static void main(String[] args) {
        System.out.println("Solution using Priority Queue");
        System.out.println();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        findKthLargestElement(nums,k);
    }

    private static void findKthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++){
            pq.add(nums[i]);
        }
        System.out.println(pq);
        for(int i=k; i<nums.length; i++){
            if(pq.peek() < nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        System.out.println(pq );

        System.out.println(pq.peek());
    }
}
