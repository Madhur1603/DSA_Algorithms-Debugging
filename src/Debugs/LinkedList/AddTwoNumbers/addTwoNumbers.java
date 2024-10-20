package Debugs.LinkedList.AddTwoNumbers;

public class addTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        // Create individual nodes for both linked list
        ListNode node23 = new ListNode(4);
        ListNode node22 = new ListNode(6, node23);
        ListNode node21 = new ListNode(5, node22);

        ListNode node13 = new ListNode(3);
        ListNode node12 = new ListNode(4, node13);
        ListNode node11 = new ListNode(2, node12);

        // The head of the linked list 1
        ListNode l1 = node11;
        // The head of the linked list 2
        ListNode l2 = node21;


        ListNode ans = addedList(l1,l2);

        System.out.print("list l1 = ");
        printList(l1);
        System.out.print("list l2 = ");
        printList(l2);
        System.out.print("Result list = ");
        printList(ans);
    }


    private static ListNode addedList(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode ptr = result;

        int carry = 0;

        while(l1 != null && l2 != null){
            int sum = 0 + carry;

            if(l1 != null){
                sum = sum +  l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // this gives the quotient
            sum = sum % 10; // this gives the remainder
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }

        if(carry != 0){
            ptr.next = new ListNode(carry);
        }

        // Shift it one node as we don't want the first '0' node.
        return result.next;
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
