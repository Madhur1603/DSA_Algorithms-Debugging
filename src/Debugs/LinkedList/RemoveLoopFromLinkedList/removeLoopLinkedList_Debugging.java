package Debugs.LinkedList.RemoveLoopFromLinkedList;

public class removeLoopLinkedList_Debugging {
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
        System.out.println("\nChecking if the list is empty or has only one node, if (head == null || head.next == null).");
        if (head == null || head.next == null) {
            return null;
        }

        System.out.println("Initializing 2 nodes slow and fast that are initially set to the head of the list.");
        System.out.println("ListNode slow = head\nListNode fast = head");
        ListNode slow = head;
        ListNode fast = head;
        System.out.println("\nInitializing a boolean, hasLoop = false");
        boolean hasLoop = false;

        System.out.println("\nwhile(fast != null && fast.next != null) -> true, means the loop will iterate until fast and fast.next are not null");
        int iterate = 1;
        while (fast != null && fast.next != null) {
            System.out.println("\n\tLoop iteration : "+iterate);
            System.out.println("\tslow = slow.next, moving slow pointer from node with value: " + slow.val + " to the next node.");
            slow = slow.next;
            System.out.println("\tslow is now pointing to node with value: " + slow.val);

            System.out.println("\tfast = fast.next.next, moving fast pointer from node with value: " + fast.val + " to two nodes forward.");
            fast = fast.next.next;
            if (fast != null) {
                System.out.println("\t\tfast is now pointing to node with value: " + fast.val);
            } else {
                System.out.println("\t\tfast has reached the end of the list (null).");
            }

            if (slow == fast) {
                System.out.println("\n\t\tif(slow == fast) -> true, means slow is equal to fast, hence the loop is detected");
                System.out.println("\t\tupdated hasLoop = true");
                hasLoop = true;
                System.out.println("\t\tget out of loop");
                break;
            }

            iterate++;
        }

        System.out.println("\nChecking if the hasloop is true or false, if(hasLoop)");
        if (hasLoop) {
            System.out.println("\tif(hasLoop) -> true, means the cycle has loop");
            System.out.println("\tnow again initialize slow with head, slow = head");
            slow = head;
            // If the loop starts at the head node
            if (slow == fast) {
                System.out.println("\t\tif(slow == fast) -> true, means the loop starts at the head node");
                System.out.println("\t\twhile(fast.next != slow) -> true, means until it is true the loop will iterate until the fast.next gets equal to slow");
                iterate = 1;
                while (fast.next != slow) {
                    System.out.println("\n\t\tloop iteration : "+iterate);
                    System.out.println("\t\tMoving fast pointer. Currently at node: " + fast.val);
                    fast = fast.next;
                    iterate++;
                }
            } else {
                System.out.println("\t\tif(slow == fast) -> false, means the loop does not starts at the head node");
                System.out.println("\t\twhile(slow.next != fast.next) -> true, means until it is true the loop will iterate, until the slow.next gets equal to fast.next");
                // Move both pointers at the same speed to find the start of the loop
                iterate = 1;
                while (slow.next != fast.next) {
                    System.out.println("\n\t\tloop iteration : "+iterate);
                    System.out.println("\t\tSlow is at node: " + slow.val + ", Fast is at node: " + fast.val);
                    slow = slow.next;
                    System.out.println("\t\tShift slow a node ahead : slow = slow.next");
                    fast = fast.next;
                    System.out.println("\t\tShift fast a node ahead : fast = fast.next");
                    iterate++;
                }
                System.out.println("\tStart of the loop found at node: " + slow.next.val);
            }
            System.out.println("\nTo remove loop fast.next = null, as the last will face to the null nowand no cyle will be formed");
            fast.next = null; // Remove the loop
        }
        System.out.println("\nLoop removed. The next pointer of node: " + fast.val + " is now set to null.");
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
