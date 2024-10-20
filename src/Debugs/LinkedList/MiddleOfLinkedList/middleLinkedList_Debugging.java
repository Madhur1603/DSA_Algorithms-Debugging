package Debugs.LinkedList.MiddleOfLinkedList;

public class middleLinkedList_Debugging {
    public static class ListNode {
        int val;
        ListNode next;  // Corrected type
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6,node7);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        ListNode head = node1;

        ListNode result = middleNode(head);
        printList(result);
    }

    private static ListNode middleNode(ListNode head) {
        // Step 1: Check if the list is empty or has only one node
        System.out.println("\nChecking if the list is empty or has only one node -> if(head == null || head.next == null) ");
        if (head == null) {
            System.out.println("\thead is null. Returning null as the list is empty.");
            return head;
        }
        if (head.next == null) {
            System.out.println("\thead.next is null. The list contains only one node. Returning the head.");
            return head;
        }

        // Step 2: Initialize slow and fast pointers
        System.out.println("Initializing two pointers, slow and fast.");
        System.out.println("\tBoth slow and fast are initially set to the head of the list.");
        ListNode slow = head;
        ListNode fast = head;
        System.out.println("\tListNode slow = head;\n\tListNode fast = head;");

        // Step 3: Traverse the list with slow and fast pointers
        System.out.println("\nStarting traversal with slow and fast pointers.");
        int iteration = 1;
        System.out.println("while (fast != null && fast.next != null) -> true, means the loop will iterate until fast and fast.next are not null");
        while (fast != null && fast.next != null) {
            System.out.println("\n\tIteration " + iteration);

            // Move slow pointer one step forward
            System.out.println("\tslow = slow.next, moving slow pointer from node with value: " + slow.val + " to the next node.");
            slow = slow.next;
            System.out.println("\tslow is now pointing to node with value: " + slow.val);

            // Move fast pointer two steps forward
            System.out.println("\tfast = fast.next.next, moving fast pointer from node with value: " + fast.val + " to two nodes forward.");
            fast = fast.next.next;
            if (fast != null) {
                System.out.println("\tfast is now pointing to node with value: " + fast.val);
            } else {
                System.out.println("\tfast has reached the end of the list (null).");
            }

            iteration++;
        }

        // Step 4: Return the slow pointer as the middle node
        System.out.println("\nTraversal complete. Slow pointer is at the middle of the list.");
        System.out.println("Returning the node with value: '" + slow.val + "' as the middle node.");
        return slow;
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
