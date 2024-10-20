package Debugs.Queue.QueueUsingStack;
import java.util.*;

public class QueueUsingStack_Debugging {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStack_Debugging() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public static void main(String[] args) {
        QueueUsingStack_Debugging queue = new QueueUsingStack_Debugging();
        queue.enqueue(1);
        System.out.println(queue.dequeue());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
    }

    private boolean isEmpty() {
        boolean emptyState = stack1.isEmpty() && stack2.isEmpty();
        System.out.println("\nChecking if the queue is empty (when both stack1 and stack2 are empty then only queue is considered empty) :-");
        System.out.println("stack1 is empty : " + stack1.isEmpty());
        System.out.println("stack2 is empty : " + stack2.isEmpty());
        System.out.println("Queue empty state : " + emptyState);
        return emptyState;
    }

    private int peek() {
        System.out.println("\nPeeking at the front element :-");
        if (stack2.isEmpty()) {
            System.out.println("\tif(stack2.isEmpty()) -> true, means stack2 is empty and does not have any element inside it");
            System.out.println("\tSo, transferring elements from stack1 to stack2.");
            System.out.println("\twhile(!stack1.isEmpty()) -> true, means until the stack 1 get empty the loop will iterate");
            int iterate = 1;
            while (!stack1.isEmpty()) {
                System.out.println("\tLoop : "+iterate);
                int popped = stack1.pop();
                System.out.println("\t\tpopped = stack1.pop(), popping the element from stack and storing it in popped = "+popped);
                stack2.push(popped);
                System.out.println("\t\tstack2.push(popped) = stack2.push("+popped+")");
                System.out.println("\t\tMoved " + popped + " from stack1 to stack2");
                iterate++;
                System.out.println();
            }
        }

        if (stack2.isEmpty()) {
            System.out.println("\tif(stack2.isEmpty()) -> true, means the stack2 is still empty");
            throw new RuntimeException("Queue is empty");
        }

        int peekedElement = stack2.peek();
        System.out.println("\tpeekedElement = stack2.peek()");
        System.out.println("Peeked " + peekedElement + " from stack2");
        return peekedElement;
    }

    private int dequeue() {
        System.out.println("\nDequeuing :-");
        if (stack2.isEmpty()) {
            System.out.println("\tif(stack2.isEmpty()) -> true, means stack2 is empty");
            System.out.println("\tstack2 is empty, transferring elements from stack1 to stack2.");
            System.out.println("\twhile(!stack1.isEmpty()) -> true, means until the stack1 gets empty the loop will iterate");
            int iterate = 1;
            while (!stack1.isEmpty()) {
                System.out.println("\tLoop : "+iterate);
                int popped = stack1.pop();
                System.out.println("\t\tpopped = stack1.pop(), popping the element from stack and storing it in popped = "+popped);
                stack2.push(popped);
                System.out.println("\t\tstack2.push(popped) = stack2.push("+popped+")");
                System.out.println("\t\tMoved " + popped + " from stack1 to stack2");
                iterate++;
            }
        }

        if (stack2.isEmpty()) {
            System.out.println("\tif(stack2.isEmpty()) -> true, means the stack2 is still empty");
            throw new RuntimeException("Queue is empty");
        }

        int dequeuedElement = stack2.pop();
        System.out.println("Dequeued " + dequeuedElement + " from stack2");
        System.out.println("stack2 after dequeuing: " + stack2);
        return dequeuedElement;
    }

    private void enqueue(int i) {
        System.out.println("\nEnqueuing " + i + " to stack1");
        System.out.println("stack1.push("+i+")");
        stack1.push(i);
        System.out.println("stack1 after enqueuing: " + stack1);
    }
}
