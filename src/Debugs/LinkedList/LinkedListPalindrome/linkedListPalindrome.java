package Debugs.LinkedList.LinkedListPalindrome;

import java.util.Stack;



public class linkedListPalindrome {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        // Create individual nodes
        ListNode node8 = new ListNode(1);
        ListNode node7 = new ListNode(2, node8);
        ListNode node6 = new ListNode(3, node7);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        // The head of the linked list
        ListNode head = node1;

        boolean ans = isPalindrome(head);
        System.out.println(ans);
    }

    private static Boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode full = head;
        ListNode half = head;

        while(full != null && full.next != null){
            stack.push(half.val);
            half = half.next;
            full = full.next.next;
        }

        // If the Linked List have odd numbers of elements
        if(full != null){
            half = half.next;
        }

        while(half != null && half.next != null){
            int top = stack.pop();
            if(top != half.val){
                return false;
            }
            half = half.next;
        }

        return true;
    }
}
