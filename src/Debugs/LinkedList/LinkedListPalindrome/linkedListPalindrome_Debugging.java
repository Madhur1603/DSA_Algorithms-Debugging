package Debugs.LinkedList.LinkedListPalindrome;

import java.util.Stack;

public class linkedListPalindrome_Debugging {
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
        System.out.println("\nChecking if the head is null or the list contains only one element -> if(head == null || head.next == null)");
        if(head == null || head.next == null){
            System.out.println("if(head == null || head.next == null) -> true, means we return");
            return true;
        }
        System.out.println("List contains more than one element, proceeding to check for palindrome.");

        System.out.println("initializing a stack and two ListNode pointer full (fast) and half (slow)");
        Stack<Integer> stack = new Stack<>();
        ListNode full = head;
        ListNode half = head;
        System.out.println("ListNode full = head;\nListNode half = head;");

        System.out.println("\nStarting traversal of the linked list, pushing values from the first half into the stack.");
        int iteration = 1;
        System.out.println("while(full != null && full.next != null) -> true, means loop will keep on going until full and full.next does not become null");
        while(full != null && full.next != null){
            System.out.println("\n\tLoop iteration : "+iteration);
            System.out.println("\tPushing half.val (" + half.val + ") to the stack.");
            stack.push(half.val);
            System.out.println("\tMoving half pointer to the next node (half = half.next).");
            half = half.next;
            System.out.println("\tMoving full pointer two nodes ahead (full = full.next.next).");
            full = full.next.next;
            iteration++;
        }

        // If the Linked List have odd numbers of elements
        if(full != null){
            System.out.println("\tif(full != null) -> true, means there is still a node left in full");
            System.out.println("\tAs the list has an odd number of elements, so skipping the middle element.");
            System.out.println("\thalf = half.next;");
            half = half.next;
        }

        System.out.println("\nStarting comparison of the second half of the list with values from the stack.");
        System.out.println("while(half != null && half.next != null) -> true, means loop will keep on going until half and half.next does not become null");
        iteration = 1;
        while(half != null && half.next != null){
            System.out.println("\n\tLoop iteration : "+iteration);
            int top = stack.pop();
            System.out.println("\ttop = stack.pop(), taking out the top element of stack for comparing with half .val");
            System.out.println("\ttop = "+top);
            if(top != half.val){
                System.out.println("\tif(top != half.val) -> true, means top is not equal to the half.val, hence no palindrome is present");
                System.out.println("Returning false");
                return false;
            }
            System.out.println("\tMoving half pointer to the next node (half = half.next).");
            half = half.next;
            iteration++;
        }

        System.out.println("Returning true");
        return true;
    }
}
