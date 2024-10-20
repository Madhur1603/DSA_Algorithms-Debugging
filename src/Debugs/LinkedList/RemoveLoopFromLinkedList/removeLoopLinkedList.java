package Debugs.LinkedList.RemoveLoopFromLinkedList;

public class removeLoopLinkedList {

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

        node7.next = node4;
        ListNode head = node1;


        ListNode result = removeLoop(head);
        printList(result);
    }

    private static ListNode removeLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        boolean hasLoop = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }

        if (hasLoop) {
            slow = head;
            // If the loop starts at the head node
            if (slow == fast) {
                while (fast.next != slow) {
                    fast = fast.next;
                }
            } else {
                // Move both pointers at the same speed to find the start of the loop
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            fast.next = null; // Remove the loop
        }

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
