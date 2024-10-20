package Debugs.LinkedList.RemoveDuplicateFromSortedLinkedList;


public class removeDuplicateFromSortedLinkedList {
    public static class ListNode {
        int val;
        ListNode next;  // Corrected type
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(5);
        ListNode node6 = new ListNode(3,node7);
        ListNode node5 = new ListNode(3,node6);
        ListNode node4 = new ListNode(2,node5);
        ListNode node3 = new ListNode(2,node4);
        ListNode node2 = new ListNode(1,node3);
        ListNode node1 = new ListNode(1,node2);

        ListNode head = node1;


        ListNode result = removeDuplicates(head);
        printList(result);
    }

    private static ListNode removeDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode current = head;

        while(current.next != null){
            if(current.val == current.next.val){
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
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
