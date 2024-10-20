package Debugs.Queue.IPLMatch2021;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class iplMatch2021_Debugging {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        System.out.println("Initializing variables:");
        System.out.println("1. ArrayList<Integer> ans = new ArrayList<>(); - This will store the maximum values for each subarray.");
        ArrayList<Integer> ans = new ArrayList<>();

        System.out.println("2. Deque<Integer> deque = new LinkedList<>(); - This will track the indices of elements in the current window.");
        Deque<Integer> deque = new LinkedList<>();

        int iterate = 1;
        for (int i = 0; i < n; i++) {
            System.out.println("\nLoop iteration : " + iterate + " (i = " + i + ")");
            System.out.println("\tCurrent window: [" + Math.max(0, i - k + 1) + ", " + i + "] (size = " + Math.min(i + 1, k) + ")");
            System.out.println("\tDeque before operations: " + deque);

            // Remove indices that are out of this window
            System.out.println("\twhile (!deque.isEmpty() && deque.peek() < (i - k + 1)), means the loop will iterate until deque get empty and checks the index at front of deque is outside the current window of size k.");
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                System.out.println("\t\tdeque.poll(), removing index " + deque.peek() + " from deque, because it's out of the window.");
                deque.poll();
            }

            System.out.println("\tDeque after removing out-of-window elements: " + deque);

            // Remove elements that are less than the current element from the deque
            System.out.println("\twhile (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]), means the loop will iterate until deque get empty and removes elements smaller than arr[i] as they are no longer useful for the maximum.");
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                System.out.println("\t\tRemoving index " + deque.peekLast() + " from deque, because arr[" + deque.peekLast() + "] = " + arr[deque.peekLast()] + " is smaller than or equal to arr[" + i + "] = " + arr[i] + " (deque.pollLast())");
                deque.pollLast();
            }

            System.out.println("\tDeque after removing smaller elements: " + deque);

            // Add current element index to the deque
            System.out.println("\tdeque.offer(" + i + "), adding current index " + i + " to the deque.");
            deque.offer(i);
            System.out.println("\tDeque after adding the current element : " + deque);

            // Once we have processed at least k elements, we add the max (front of deque) to the answer
            if (i >= k - 1) {
                System.out.println("\t\tif(i >= k - 1) -> true, means i = "+i+" is greater then (k-1) = "+(k-1));
                System.out.println("\t\tReached a full window. Adding the max element for this window:");
                System.out.println("\t\tans.add(arr[deque.peek()]) = ans.add(arr[" + deque.peek() + "]) = ans.add(" + arr[deque.peek()] + ")");
                ans.add(arr[deque.peek()]);
                System.out.println("\t\tCurrent answer list: " + ans);
            }

            iterate++;
        }

        System.out.println("\nFinal list of maximums for each subarray: " + ans);
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        ArrayList<Integer> result = max_of_subarrays(arr, arr.length, k);
    }
}
