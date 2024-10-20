package Debugs.LinkedList.ReverseLinkedListInGroups;

public class reverseLinkedListInGroups_Debugging {
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
        // Start the process of reversing the list in groups
        System.out.println("\nStarting group-wise reversal with group size: " + k);

        System.out.println("Initializing 2 nodes temp, lstOfPrev :");
        System.out.println("ListNode temp = head\nListNode lastOfPrev = null");
        ListNode temp = head;
        ListNode lastOfPrev = null;

        int iterate = 1;
        System.out.println("\nwhile(temp != null) -> true, means loop will iterate until temp is not null");
        while (temp != null) {
            System.out.println("\nLoop iteration : "+iterate);
            System.out.println("\tCurrent group starts at node: " + temp.val);

            // Find the kth node from temp
            System.out.println("\tGet the kth node : ListNode kthNode = getKthNode(temp, k)");
            ListNode kthNode = getKthNode(temp, k);

            if (kthNode == null) {
                System.out.println("\t\tif(kthNode == null) -> true, means the kthNode does not have a value and is null");
                // If there aren't enough nodes left to form a complete group
                System.out.println("\t\tLess than " + k + " nodes remaining, no more reversal.");
                if (lastOfPrev != null) {
                    System.out.println("\t\t\tif(lastOfPrev != null) -> true, means lastOfPrev is not null");
                    System.out.println("\t\t\tSo, updating last node of previous to the temp, lastOfPrev.next = temp");
                    lastOfPrev.next = temp;
                }
                break;
            }


            System.out.println("\tKth node in this group is: " + kthNode.val);

            // Store the node after the kth node to continue processing the next group
            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            // Reverse the current group from temp to kthNode
            System.out.println("\tReversing current group from " + temp.val + " to " + kthNode.val);
            reverseLinkedList(temp);

            // If we're processing the first group, update the head
            if (temp == head) {
                head = kthNode;
                System.out.println("\t\tThis is the first group, updating the head to: " + head.val);
            } else {
                // Connect the last node of the previous reversed group to the current group's kthNode
                lastOfPrev.next = kthNode;
                System.out.println("\t\tConnecting previous group's last node to: " + kthNode.val);
            }

            // Update the pointers for the next iteration
            lastOfPrev = temp;
            System.out.println("\tLast node of the current group is now: " + lastOfPrev.val);

            temp = nextNode;
            System.out.println("\tMoving to the next group starting at: " + (temp != null ? temp.val : "null"));
            iterate++;
        }

        System.out.println("\nGroup-wise reversal complete. Returning new head.");
        return head;
    }

    private static ListNode getKthNode(ListNode temp, int k) {
        System.out.println("\t\tk = k - 1 = "+k+" - 1");
        k = k - 1; // already on the 1st node
        System.out.println("\t\tk = "+k);

        System.out.println("\t\tFinding the " + k + "th node from current node = " + temp.val);
        System.out.println("\t\twhile(temp != null && k > 0) -> true, means until temp is not null and k is greater then zero the loop will iterarte");
        int iterate = 1;
        while (temp != null && k > 0) {
            System.out.println("\t\t\tLoop iteration : "+iterate);
            temp = temp.next;
            System.out.println("\t\t\ttemp = temp.next");
            k--;
            if (temp != null) {
                System.out.println("\t\t\tif(temp != null) -> true, means the temp is not null");
                System.out.println("\t\t\tMoved to node: " + temp.val);
            }
            iterate++;
        }

        System.out.println("\t\tReturning kth node: " + (temp != null ? temp.val : "null"));
        System.out.println();
        return temp;
    }

    private static void reverseLinkedList(ListNode temp) {
        ListNode prev = null;
        ListNode current = temp;
        ListNode front = null;

        System.out.println("\t\tStarting to reverse linked list starting at node: " + current.val);
        System.out.println("\t\twhile(current != null) -> true, means the loop will iterate until current does not get null");
        int iterate = 1;
        while (current != null) {
            System.out.println("\t\t\tLoop iteration : "+iterate);
            front = current.next;
            current.next = prev;
            System.out.println("\t\t\tReversing node: " + current.val + ", it now points to: " + (prev != null ? prev.val : "null"));
            prev = current;
            current = front;
            iterate++;
        }

        System.out.println("\t\tLinked list reversed.");
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
