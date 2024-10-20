package Debugs.LinkedList.ReverseLinkedListInGroups;

public class reverseLinkedListInGroups {
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
        int k = 2;

        ListNode result = reverseListInGroups(head, k);
        printList(result);
    }

    private static ListNode reverseListInGroups(ListNode head, int k) {
        ListNode temp = head;
        ListNode lastOfPrev = null;

        while(temp != null){
            ListNode kthNode = getKthNode(temp, k);
            if(kthNode == null){
                if(lastOfPrev != null){
                    lastOfPrev.next = temp;
                }
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            reverseLinkedList(temp);

            if(temp == head){
                head = kthNode;
            }
            else{
                lastOfPrev.next = kthNode;
            }

            lastOfPrev = temp;
            temp = nextNode;
        }

        return head;
    }

    private static ListNode getKthNode(ListNode temp, int k) {
        k = k - 1; // already in the 1st node

        while(temp != null && k > 0){
            k--;
            temp = temp.next;
        }
        return temp;
    }

    private static ListNode reverseLinkedList(ListNode temp) {
        ListNode prev = null;
        ListNode current = temp;
        ListNode front = null;

        while(current != null){
            front = current.next;
            current.next = prev;
            prev = current;
            current = front;
        }

        return temp;
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
