package Debugs.LinkedList.LinkedListCycle;

public class linkedListCycle_Debugging {
    public static class ListNode {
        int val;
        ListNode next;  // Corrected type
        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        // Now we add the address of node2 to node5 to create cycle
        node5.next = node2;

        // create the head for Linked List
        ListNode head = node1;

        boolean ans = loopDetected(head);
        System.out.println(ans);

    }

    private static boolean loopDetected(ListNode head) {
        System.out.println("\nInitial check: if the head(ListNode) is null or head.next(Next node of head ListNode) is null, there can't be a loop.");
        if (head == null || head.next == null) {
            System.out.println("\thead is null: " + (head == null) + ", head.next is null: " + (head != null && head.next == null));
            System.out.println("\tReturning false as there is no loop.");
            return false;
        }

        // Step 1: Initialize slow and fast pointers
        System.out.println("Both head and head.next are non-null, proceeding to detect the loop.");
        System.out.println("Using Floyd’s Cycle Finding Algorithm (Tortoise and Hare) to detect the cycle.");

        System.out.println("\tListNode slow = head, points to the head of the list.");
        System.out.println("\tListNode fast = head.next, points to the second node of the list.");

        ListNode slow = head;
        ListNode fast = head.next;


        int iteration = 1;
        // Step 2: Traverse the list to detect a cycle
        System.out.println("while(slow != fast) -> true, means slow and fast are not equal, if they get equal means cycle is present");
        while (slow != fast) {
            System.out.println("\nLoop iteration = " + iteration);
            System.out.println("\tChecking if slow == fast -> " + (slow == fast));
            if (slow == fast) {
                System.out.println("\t\tif(slow == fast) -> true, means");
                System.out.println("\t\tSlow and fast pointers have met. A cycle is detected.");
                break;
            }

            // Check if fast or fast.next is null, meaning no cycle is present
            if (fast == null || fast.next == null) {
                System.out.println("\t\tfast is null or fast.next is null -> " + (fast == null) + " or " + (fast != null && fast.next == null));
                System.out.println("\t\tThis means there is no cycle, returning false.");
                return false;
            }

            // Move slow pointer one step ahead
            System.out.println("\tSlow is currently pointing to node with value: " + slow.val);
            System.out.println("\tShifting slow to the next node (slow = slow.next).");
            slow = slow.next;

            // Move fast pointer two steps ahead
            System.out.println("\tFast is currently pointing to node with value: " + fast.val);
            System.out.println("\tShifting fast two nodes ahead (fast = fast.next.next).");
            fast = fast.next.next;

            iteration++;
        }

        // Step 3: If we break out of the loop, it means slow == fast, and there's a cycle
        System.out.println("\nLoop has exited because slow == fast, meaning a cycle is detected.");
        System.out.println("Returning true.");
        return true;
    }

}
