package Debugs.LinkedList.ReverseLinkedList;

public class reverseALinkedList_Debugging {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode head = node1;

        ListNode result = reverseList(head);
        printList(result);
    }

    private static ListNode reverseList(ListNode head) {
        System.out.println("\nCheck if the list is empty,if(head == null)");
        // Initial check: Is the list empty?
        if (head == null) {
            System.out.println("The list is empty, returning null.");
            return null;
        }
        System.out.println("The list is not empty, continuing.");

        System.out.println("\nInitializing three nodes prev, current and front :");
        System.out.println("ListNode prev = null\nListNode current = head\nListNode front = null");
        ListNode prev = null;
        ListNode current = head;
        ListNode front = null;

        System.out.println("\nStarting list reversal...");
        System.out.println("Initial Head Node: " + head.val + "\n");

        // Loop through the list to reverse it
        System.out.println("while(current != null) -> true, means the loop will iterate until the current does not get null");
        int iterate = 1;
        while (current != null) {
            // Log the current, previous, and next (front) nodes before changing anything
            System.out.println("\n\tLoop iteration : "+iterate);
            System.out.println("\tCurrent Node (current) = " + current.val);
            System.out.println("\tPrevious Node (prev) = " + (prev != null ? prev.val : "null"));
            System.out.println("\tNext Node (front) = " + (current.next != null ? current.next.val : "null"));

            // Save the next node (front) before modifying current.next
            front = current.next;
            System.out.println("\tStoring the next node (front) to the current node (current), front = current.next = " + (front != null ? front.val : "null"));

            // Reverse the current node's next pointer to point to the previous node
            current.next = prev;
            System.out.println("\tReversing the current node's pointer to previous, current.next = prev");
            System.out.println("\tNow, Current Node " + current.val + " points to = " + (prev != null ? prev.val : "null"));

            // Move the 'prev' and 'current' pointers one step forward
            prev = current;
            System.out.println("\tMoving 'prev' to Current Node, prev = current = " + prev.val);

            current = front;
            System.out.println("\tMoving 'current' to the Next Node, current = front = " + (current != null ? current.val : "null"));
            iterate++;
        }

        // The loop ends, 'prev' is the new head of the reversed list
        head = prev;
        System.out.println("\nReversal completed.");
        System.out.println("New head of the reversed list: " + head.val);

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
