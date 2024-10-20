package Debugs.Queue.ReverseFirstKElementsQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseFirstKElementsQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int K = 5;

        for (int element : elements) {
            queue.add(element);
        }

        reverseFirstKElements(queue, K);

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");  // Output: 30 20 10 40 50
        }
    }

    private static void reverseFirstKElements(Queue<Integer> queue, int k) {
        if(queue == null || k > queue.size() || k <= 0){
            return;
        }

        // poll retrieves the head of the queue and remove it whereas peek retrieves the head without removing it.

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<k; i++){
            stack.push(queue.poll());
        }

        for(int i=0; i<k; i++){
            queue.add(stack.pop());
        }

        for(int i=0; i<queue.size()-k; i++){
            queue.add(queue.poll());
        }

    }
}
