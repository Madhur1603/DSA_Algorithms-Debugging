package Debugs.LinkedList.RemoveDuplicateFromSortedLinkedList;

public class removeDuplicateFromSortedLinkedList_Debugging {
    public static class ListNode {
        int val;
        ListNode next;  // Corrected type
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(5);
        ListNode node6 = new ListNode(3,node7);
        ListNode node5 = new ListNode(3,node6);
        ListNode node4 = new ListNode(2,node5);
        ListNode node3 = new ListNode(2,node4);
        ListNode node2 = new ListNode(1,node3);
        ListNode node1 = new ListNode(1,node2);

        ListNode head = node1;


        ListNode result = removeDuplicates(head);
        printList(result);
    }

    private static ListNode removeDuplicates(ListNode head) {
        // Step 1: Check if the list is empty or has only one node
        System.out.println("\nChecking if the list is empty or has only one node. if(head == null || head.next == null)");
        if (head == null) {
            System.out.println("\thead is null. The list is empty. Returning null.");
            return head;
        }
        if (head.next == null) {
            System.out.println("\thead.next is null. The list contains only one node. Returning the head.");
            return head;
        }

        // Step 2: Initialize the current pointer to the head
        System.out.println("List contains more than one node. \nInitializing current pointer to head.");
        System.out.println("\tListNode current = head");
        ListNode current = head;
        System.out.println("\tCurrent is pointing to node with value: " + current.val);

        // Step 3: Traverse the list and remove duplicates
        System.out.println("\nStarting traversal of the list to remove duplicates.");
        int iteration = 1;
        System.out.println("while(current.next != null) -> true, means until current.next is not equal to null the loop will iterate.");
        while (current.next != null) {
            System.out.println("\n\tIteration " + iteration);

            // Check if the current node's value equals the next node's value
            System.out.println("\tChecking if current node value current.val = " + current.val + " equals next node value current.next.val = " + current.next.val);
            if (current.val == current.next.val) {
                // If they are equal, skip the next node by adjusting the `next` pointer
                System.out.println("\tValues are equal. Removing duplicate node by skipping it by its ahead node: current.next = current.next.next");
                current.next = current.next.next;
                System.out.println("\tSkipped to the next node.");
            } else {
                // Otherwise, move the current pointer to the next node
                System.out.println("\tValues are not equal. Moving current pointer to the next node.");
                current = current.next;
                System.out.println("\tCurrent is now pointing to node with value: " + current.val);
            }

            iteration++;
        }

        // Step 4: Return the modified list
        System.out.println("\nTraversal complete. Duplicates removed from the list.");
        System.out.println("Returning the modified list starting with node value: " + head.val);
        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
