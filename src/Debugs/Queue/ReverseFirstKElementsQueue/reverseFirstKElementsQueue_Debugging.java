package Debugs.Queue.ReverseFirstKElementsQueue;
import java.util.*;

public class reverseFirstKElementsQueue_Debugging {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int K = 5;

        for (int element : elements) {
            queue.add(element);
        }

        reverseFirstKElements(queue, K);


    }

    private static void reverseFirstKElements(Queue<Integer> queue, int k) {
        if (queue == null || k > queue.size() || k <= 0) {
            System.out.println("\nif(queue == null || k > queue.size() || k <= 0) -> true");
            System.out.println("Invalid input: Either queue is null, k is larger than the queue size, or k is non-positive.");
            return;
        }

        System.out.println("\nInitial queue: " + queue);
        System.out.println("Have to reverse the first " + k + " elements.");

        Stack<Integer> stack = new Stack<>();
        System.out.println("Stack<Integer> stack = new Stack<>(), initialized a stack");
        System.out.println("\nStep 1 : Starting a loop and putting first k elements of queue in a stack");
        int iterate = 1;
        for (int i = 0; i < k; i++) {
            System.out.println("Loop : "+iterate);
            int polledElement = queue.poll();
            System.out.println("\tpolledElement = queue.poll() = "+polledElement+", polled the element from queue and stored it.");
            System.out.println("\tstack.push(polledElement) = stack.push("+polledElement+"), pushed that element inside the stack");
            stack.push(polledElement);
            System.out.println("\tPolled " + polledElement + " from queue and pushed to stack.\n");
            iterate++;
        }

        System.out.println("Stack after pushing first " + k + " elements: " + stack);
        System.out.println("Queue after polling first " + k + " elements: " + queue);

        // Step 2: Add the elements from the stack back into the queue.
        System.out.println("\nStep 2 : Putting the elements from the stack back into the queue");
        iterate = 1;
        for (int i = 0; i < k; i++) {
            System.out.println("Loop : "+iterate);
            int poppedElement = stack.pop();
            System.out.println("\tpoppedElement = stack.pop() = "+poppedElement+", popped the element from stack");
            queue.add(poppedElement);
            System.out.println("\tqueue.add(poppedElement) = queue.add("+poppedElement+"), add it into the queue");
            System.out.println("\tPopped " + poppedElement + " from stack and added back to queue.\n");
            iterate++;
        }

        System.out.println("Queue after adding reversed elements back: " + queue);

        int remainingElements = queue.size() - k;
        System.out.println("\nStep 3 : Rotating the remaining " + remainingElements + " elements to the back of the queue.");
        iterate = 1;
        for (int i = 0; i < remainingElements; i++) {
            System.out.println("Loop : "+iterate);
            int movedElement = queue.poll();
            System.out.println("\tmovedElement = queue.poll() = "+movedElement+", polled element from queue and stored it in movedElement");
            queue.add(movedElement);
            System.out.println("\tqueue.add(movedElement) = queue.add("+movedElement+"), adding back that polled element in the stack from back");
            System.out.println("\tMoved " + movedElement + " from front to back of the queue.\n");
            iterate++;
        }

        System.out.println("Final queue after reversing first " + k + " elements: " + queue);
    }
}
