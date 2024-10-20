package Debugs.LinkedList.RemoveNthNode;

import Debugs.LinkedList.IntersectionOfTwoLinkedList.intersectionOfTwoLinkedList;
import Debugs.LinkedList.MiddleOfLinkedList.middleLinkedList;

public class removeNthNode {
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
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i=0; i<=n; i++){
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

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
