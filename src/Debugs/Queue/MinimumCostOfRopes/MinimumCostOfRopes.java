package Debugs.Queue.MinimumCostOfRopes;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        int ans = minCost(arr);
        System.out.println(ans);
    }

    private static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int x : arr){
            pq.add(x);
        }

        int total = 0;

        while(pq.size() > 1){
            int min1 = pq.poll();
            int min2 = pq.poll();

            int cost = min1 + min2;

            total = total + cost;

            pq.add(cost);
        }

        return total;
    }
}
