package Debugs.LinkedList.RemoveNthNode;

public class removeNthNode_Debugging {
    public static class ListNode {
        int val;
        ListNode next;  // Corrected type
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
        int n = 3;

        ListNode result = removeNthFromEnd(head,n);
        printList(result);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        // Check if the list is empty
        System.out.println("\nCheck if the list is empty,if(head == null)");
        if (head == null) {
            System.out.println("The list is empty, returning null.");
            return null;
        }
        System.out.println("The list is not empty, continuing.");

        System.out.println("\nCreating a dummy node to handle edge cases (like removing the first node)");
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        System.out.println("ListNode dummy = new ListNode(0)\ndummy.next = head");
        System.out.println("Dummy node created. Dummy.next points to the head node: " + head.val);

        // Initialize the fast and slow pointers to the dummy node
        System.out.println("\nInitialize the fast and slow pointers to the dummy node :");
        System.out.println("ListNode fast = dummy\nListNode slow = dummy");
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move the fast pointer n steps ahead
        System.out.println("\nMoving the fast pointer " + (n+1) + " steps ahead.");
        for (int i = 0; i <= n; i++) {
            if (fast != null) {
                fast = fast.next;
                System.out.println("\n\tStep " + (i + 1) + ": Fast pointer moved to node with value: " + (fast != null ? fast.val : "null"));
            }
        }

        // Move both fast and slow pointers until fast reaches the end of the list
        System.out.println("\nMoving both fast and slow pointers until fast reaches the end of the list.");
        System.out.println("while(fast != null) -> true, means the loop will iterate until fast is not null.");
        int iterate = 1;
        while (fast != null) {
            System.out.println("\n\tLoop iteration : "+iterate);
            fast = fast.next;
            slow = slow.next;
            System.out.println("\tFast pointer moved to node: " + (fast != null ? fast.val : "null"));
            System.out.println("\tSlow pointer moved to node: " + slow.val);
        }

        // Slow pointer is now just before the node to be removed
        System.out.println("Slow pointer is now just before the node to be removed. Slow is at node: " + slow.val);

        // Skip the nth node from the end
        System.out.println("\nNow we skip the nth node from the end");
        if (slow.next != null) {
            System.out.println("\tif(slow.next != null) -> true, means slow.next is not equal to null, hence there is a node to skip");
            System.out.println("\tRemoving node with value: " + slow.next.val);
            System.out.println("\tslow.next = slow.next.next;");
            slow.next = slow.next.next;
        } else {
            System.out.println("\tif(slow.next != null) -> false, means slow.next is equal to null");
            System.out.println("\tError: slow.next is null, cannot remove node.");
        }

        // Return the new head of the list
        System.out.println("\nReturning the new head of the list with value: " + dummy.next.val);
        return dummy.next;
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
