package Debugs.LinkedList.IntersectionOfTwoLinkedList;


import Debugs.LinkedList.MiddleOfLinkedList.middleLinkedList;

public class intersectionOfTwoLinkedList {
    public static class ListNode {
        int val;
        ListNode next;  // Corrected type
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        // first linked list
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        // second linked list
        ListNode nodeB3 = new ListNode(13, node6);
        ListNode nodeB2 = new ListNode(12, nodeB3);  // Intersecting at node6
        ListNode nodeB1 = new ListNode(11, nodeB2);

        ListNode head1 = node1;
        ListNode head2 = nodeB1;

        ListNode result = getIntersectionNode(head1,head2);

        printList(result);

    }

    private static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null){
            return null;
        }

        ListNode ptr1 = head1;
        ListNode ptr2 = head2;

        while(ptr1 != ptr2){
            ptr1 = ptr1 == null ? head2 : ptr1.next;
            ptr2 = ptr2 == null ? head1 : ptr2.next;
        }

        return ptr1;
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
