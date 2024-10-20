package Debugs.Queue.MaximumDiamondsInKMinutes;

import java.util.*;

public class maximumNumberDiamonds_Debugging {
    public static void main(String[] args) {
        int[] arr = {100};
        int k = 10;

        int result = kMinutesMaxDiamonds(arr, k);

        System.out.println(result);
    }

    private static int kMinutesMaxDiamonds(int[] arr, int k) {
        // Create a max-heap (priority queue) to store the diamonds in each bag
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all diamond bags to the max-heap
        System.out.println("\nStep 1: Initializing : ");
        System.out.println("maxHeap = new PriorityQueue<>(Collections.reverseOrder()), creating a priority queue in reverse Order");
        System.out.println("Adding all diamond bags to the max-heap.");
        for (int diamonds : arr) {
            System.out.println("\tmaxHeap.add("+diamonds+")");
            maxHeap.add(diamonds);
            System.out.println("\tAdded bag with " + diamonds + " diamonds to the maxHeap.");
        }

        System.out.println("totalDiamonds = 0");
        int totalDiamonds = 0; // Total diamonds collected

        // Perform k operations (where k is the number of minutes)
        System.out.println("\nStep 2: Starting the process of collecting diamonds, initializing the for-loop will go on for "+k+" times");
        for (int i = 0; i < k; i++) {
            System.out.println("\n\tMinute " + (i + 1) + ":");

            // Check if the heap is empty, break the loop if no bags are left
            if (maxHeap.isEmpty()) {
                System.out.println("\tif(maxHeap.isEmpty()) -> true, means maxHeap is empty.");
                System.out.println("\tNo more bags left. Exiting early.");
                break;
            }

            // Extract the bag with the maximum diamonds (the largest element in the heap)
            int maxDiamonds = maxHeap.poll();
            System.out.println("\tmaxDiamonds = maxHeap.poll(), means assigning maxDiamonds with the largest element in the heap");
            System.out.println("\tThe bag with the most diamonds contains " + maxDiamonds + " diamonds.");

            // Collect the diamonds
            totalDiamonds += maxDiamonds;
            System.out.println("\ttotalDiamonds = totalDiamonds + maxDiamonds");
            System.out.println("\tSo, total diamonds collected so far: " + totalDiamonds);

            // Put half of the diamonds back into the bag (rounded down)
            int remainingDiamonds = maxDiamonds / 2;
            System.out.println("\tPutting " + remainingDiamonds + " diamonds back into the bag.");
            if (remainingDiamonds > 0) {
                System.out.println("\t\tif(remainingDiamonds > 0) -> true, means remaining diamonds = "+remainingDiamonds+" are greater then 0");
                maxHeap.add(remainingDiamonds);
                System.out.println("\t\tBag with " + remainingDiamonds + " diamonds added back to the heap.");
            }
        }

        System.out.println("\nStep 3: Collection complete.");
        System.out.println("Total diamonds collected after " + k + " minutes: " + totalDiamonds);

        return totalDiamonds; // Return the total number of diamonds collected
    }

}
