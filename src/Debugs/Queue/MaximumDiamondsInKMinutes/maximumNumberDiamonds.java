package Debugs.Queue.MaximumDiamondsInKMinutes;

import java.util.Collections;
import java.util.PriorityQueue;

public class maximumNumberDiamonds {
    public static void main(String[] args) {
        int[] arr = {100};
        int k = 10;

        int result = kMinutesMaxDiamonds(arr, k);

        System.out.println(result);
    }

    private static int kMinutesMaxDiamonds(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all diamond bags to the max-heap
        for (int diamonds : arr) {
            maxHeap.add(diamonds);
        }

        int totalDiamonds = 0;

        // Perform K operations
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) {
                break;
            }

            // Extract the bag with the maximum diamonds
            int maxDiamonds = maxHeap.poll();

            // Collect the diamonds
            totalDiamonds += maxDiamonds;

            // Put half of the diamonds back into the bag
            if (maxDiamonds / 2 > 0) {
                maxHeap.add(maxDiamonds / 2);
            }
        }

        return totalDiamonds;

    }
}
