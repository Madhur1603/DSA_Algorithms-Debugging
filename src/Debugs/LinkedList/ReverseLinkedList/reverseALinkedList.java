package Debugs.LinkedList.ReverseLinkedList;

import java.util.Stack;

public class reverseALinkedList {
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
        ListNode prev = null;
        ListNode current = head;
        ListNode front = null;

        while(current != null){
            front = current.next;
            current.next = prev;
            prev = current;
            current = front;
        }

        head = prev;
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
