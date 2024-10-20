package Debugs.Queue.IPLMatch2021;
import java.util.*;

public class iplMatch2021 {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                ans.add(arr[deque.peek()]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        ArrayList<Integer> result = max_of_subarrays(arr, arr.length, k);
        System.out.println(result); // Output: [3, 3, 5, 5, 6, 7]
    }
}
