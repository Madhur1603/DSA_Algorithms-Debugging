package Debugs.Queue.OperationsInPriorityQueue;

import java.util.*;

public class OperationsInPriorityQueue {
    // HashMap to store the element-value and its priority
    private HashMap<Integer, Integer> priorityMap;

    // Constructor
    public OperationsInPriorityQueue() {
        priorityMap = new HashMap<>();
    }

    // Insertion (enqueue) - Adds an element with its priority
    public void insert(int value, int priority) {
        System.out.println("Inserting element with value: " + value + " and priority: " + priority);
        priorityMap.put(value, priority);
    }

    // Extraction (dequeue) - Removes the element with the highest priority
    public void extract() {
        if (!priorityMap.isEmpty()) {
            int highestPriorityElement = getHighestPriorityElement();
            System.out.println("Extracted element with value: " + highestPriorityElement + " and priority: " + priorityMap.get(highestPriorityElement));
            priorityMap.remove(highestPriorityElement);
        } else {
            System.out.println("Queue is empty. Cannot extract.");
        }
    }

    // Peek - View the element with the highest priority without removing it
    public void peek() {
        if (!priorityMap.isEmpty()) {
            int highestPriorityElement = getHighestPriorityElement();
            System.out.println("Element with highest priority is: Value = " + highestPriorityElement + ", Priority = " + priorityMap.get(highestPriorityElement));
        } else {
            System.out.println("Queue is empty. Cannot peek.");
        }
    }

    // Change Priority - Updates the priority of an element
    public void changePriority(int value, int newPriority) {
        if (priorityMap.containsKey(value)) {
            System.out.println("Changing priority of element with value: " + value + " to new priority: " + newPriority);
            priorityMap.put(value, newPriority);
        } else {
            System.out.println("Element not found.");
        }
    }

    // Get the element with the highest priority
    private int getHighestPriorityElement() {
        return Collections.max(priorityMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    // Size - Get the number of elements
    public int size() {
        return priorityMap.size();
    }

    // isEmpty - Check if the queue is empty
    public boolean isEmpty() {
        return priorityMap.isEmpty();
    }

    // Print all elements in the queue
    public void printQueue() {
        System.out.println("Current state of the PriorityQueue (value:priority):");
        for (Map.Entry<Integer, Integer> entry : priorityMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        OperationsInPriorityQueue pq = new OperationsInPriorityQueue();

        // Inserting elements
        pq.insert(10, 2);
        pq.insert(5, 5);
        pq.insert(20, 1);
        pq.insert(15, 4);

        // Peek at the highest priority element
        pq.peek();

        // Extracting elements
        pq.extract();

        // Change priority of an element
        pq.changePriority(20, 6);

        // Peek after priority change
        pq.peek();

        // Check size
        System.out.println("Size of the queue: " + pq.size());

        // Check if queue is empty
        System.out.println("Is queue empty? " + pq.isEmpty());

        // Print remaining elements
        pq.printQueue();
    }
}

