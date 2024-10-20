package Debugs.Queue.QueueUsingStack;

import java.util.Stack;


public class QueueUsingStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
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
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }

        return stack2.peek();
    }

    private int dequeue() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }

        return stack2.pop();
    }

    private void enqueue(int i) {
        stack1.push(i);
    }
}
