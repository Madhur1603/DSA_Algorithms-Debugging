package Debugs.Queue.MinimumCostOfRopes;
import java.util.PriorityQueue;

public class MinimumCostOfRopes_Debugging {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        int ans = minCost(arr);
    }

    private static int minCost(int[] arr) {
        System.out.println("\nInitialize : ");
        System.out.println("PriorityQueue<Integer> pq = new PriorityQueue<>(), means a priority queue that will store integer value in ascending order");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        System.out.println("total = 0, an integer variable initializing with 0");
        int total = 0;

        System.out.println("Insert all elements from the array into the PriorityQueue 'pq'");
        for(int x : arr) {
            System.out.println("\tpq.add("+x+"), inserting element: " + x + " into pq.");
            pq.add(x);
        }

        System.out.println("Current state of PriorityQueue after inserting all elements: " + pq);

        System.out.println("\nNow we find the maximum cost\nwhile(pq.size() > 1) -> ture, means the loop will iterate ");
        int iterate = 1;
        while (pq.size() > 1) {
            System.out.println("\nLoop iteration : "+iterate);

            int min1 = pq.poll();
            System.out.println("\tmin1 = pq.poll(), removing smallest element from pq : min1 = " + min1);

            int min2 = pq.poll();
            System.out.println("\tmin2 = pq.poll(), removing second smallest element from pq : min2 = " + min2);

            int cost = min1 + min2;
            System.out.println("\tcost = min1 + min2 = " + min1 + " + " + min2 + " = " + cost);

            total = total + cost;
            System.out.println("\ttotal = total + cost = " + (total - cost) + " + " + cost + " = " + total);

            System.out.println("\tpq.add(cost), add the combined rope (with length = cost) back into the PriorityQueue.");
            pq.add(cost);
            System.out.println("\tPriorityQueue (pq) after adding the combined rope: " + pq);
            iterate++;
        }

        System.out.println("\nFinal total cost to connect all ropes = " + total);

        return total;
    }
}
