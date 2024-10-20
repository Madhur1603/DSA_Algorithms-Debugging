package Debugs.LinkedList.IntersectionOfTwoLinkedList;

public class intersectionOfTwoLinkedList_Debugging {
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

//        printList(result);

    }

    private static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        System.out.println("\nInitial check: if either head1 or head2 is null, return null.");
        if(head1 == null || head2 == null) {
            System.out.println("\tif(head1 == null || head2 == null) -> true, means either one or both the head is null");
            System.out.println("\tOne of the heads is null (head1: " + (head1 == null) + ", head2: " + (head2 == null) + ").");
            System.out.println("\tReturning null as there can't be an intersection.");
            return null;
        }

        // Step 1: Initialize two pointers to the start of each list
        System.out.println("Both heads are non-null, proceeding with the algorithm.");
        System.out.println("Initializing two pointers:");
        System.out.println("\tListNode ptr1 = head1, which points to head of first list.");
        System.out.println("\tListNode ptr2 = head2, which points to head of second list.");

        ListNode ptr1 = head1;
        ListNode ptr2 = head2;

        int iteration = 1;
        // Step 2: Traverse both lists
        while (ptr1 != ptr2) {
            System.out.println("\n\tLoop iteration = " + iteration);
            if (ptr1 == ptr2) {
                System.out.println("\tif(ptr1 == ptr2) -> true, means the intersection is found");
                break;
            }
            else{
                System.out.println("\tif(ptr1 == ptr2) -> false, means no intersection is found, hence continue");
            }

            // Check if ptr1 is null, meaning end of first list is reached, so switch to head2
            if (ptr1 == null) {
                System.out.println("\tif(ptr1 == null) -> ture, means ptr1 is null, switching to head2.");
                System.out.println("\tptr1 = head2");
                ptr1 = head2;
            } else {
                System.out.println("\tptr1 is currently pointing to node with value: " + ptr1.val);
                System.out.println("\tShifting ptr1 to the next node.");
                ptr1 = ptr1.next;
            }

            // Check if ptr2 is null, meaning end of second list is reached, so switch to head1
            if (ptr2 == null) {
                System.out.println("\tif(ptr2 == null) -> ture, means ptr2 is null, switching to head1.");
                System.out.println("\tptr2 = head1");
                ptr2 = head1;
            } else {
                System.out.println("\tptr2 is currently pointing to node with value: " + ptr2.val);
                System.out.println("\tShifting ptr2 to the next node.");
                ptr2 = ptr2.next;
            }

            iteration++;
        }

        // Step 3: Return the intersection node or null
        if (ptr1 == ptr2) {
            if (ptr1 != null) {
                System.out.println("\nPointers have met at a node with value: " + ptr1.val);
                System.out.println("Intersection found, returning the node.");
            } else {
                System.out.println("\nBoth pointers are null, no intersection found.");
            }
        }

        return ptr1;  // Will return either the intersection node or null if no intersection.
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
