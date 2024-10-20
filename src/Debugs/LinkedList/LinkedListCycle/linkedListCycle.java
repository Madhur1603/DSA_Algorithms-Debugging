package Debugs.LinkedList.LinkedListCycle;

import java.util.HashSet;
import java.util.Set;

public class linkedListCycle {
    public static class ListNode {
        int val;
        ListNode next;  // Corrected type
        ListNode(int x) {
          val = x;
          next = null;
        }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        // Now we add the address of node2 to node5 to create cycle
        node5.next = node2;

        // create the head for Linked List
        ListNode head = node1;

        boolean ans = loopDetected(head);
        System.out.println(ans);

    }

    private static boolean loopDetected(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        // In this we will use tortoise and hare algorithm (also known as Floyd's Cycle Finding Algorithm)
        ListNode slow = head;
        ListNode fast = head.next;


        // at some point slow and fast will be equal hence we get out of loop and know that there i=s a cycle
        while(slow != fast){
            // if we reach the null value hence there is no cycle present
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
