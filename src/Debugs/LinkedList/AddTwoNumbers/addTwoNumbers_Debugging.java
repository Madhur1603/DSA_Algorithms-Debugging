package Debugs.LinkedList.AddTwoNumbers;

public class addTwoNumbers_Debugging {
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
        // Step 1: Initialize result node and pointer
        System.out.println("Initial Setup: ");
        System.out.println("ListNode result = new ListNode(0) , Creating a new list to store the result");
        ListNode result = new ListNode(0);
        System.out.println("Now make a pointer of ListNode and point it to result");
        ListNode ptr = result;

        // Step 2: Initialize carry to 0
        System.out.println("Initialized carry = 0");
        int carry = 0;

        // Step 3: Loop through both lists
        int iteration = 1;
        while (l1 != null || l2 != null) {
            System.out.println("\n");
            System.out.println("while (l1 != null || l2 != null) -> true, means any one of the linkedlist is not empty");
            System.out.println("Loop iteration = "+iteration);
            int sum = carry;  // Start with carry value
            System.out.println("\tStarting sum = carry = " + sum);

            // Add value from l1 if it exists
            if (l1 != null) {
                System.out.println("\t\tif (l1 != null) -> true, means l1 have a value");
                System.out.println("\t\tSo, adding l1.val: " + l1.val + " to sum.");
                sum += l1.val;
                System.out.println("\t\tThen shifting l1 to next node of it by, l1 = l1.next");
                l1 = l1.next;
            } else {
                System.out.println("\t\tif (l1 != null) -> false, means l1 does not have any value");
                System.out.println("\t\tl1 is null, skipping.");
            }

            // Add value from l2 if it exists
            if (l2 != null) {
                System.out.println("\n\t\tif (l2 != null) -> true, means l2 have a value");
                System.out.println("\t\tAdding l2.val: " + l2.val + " to sum.");
                sum += l2.val;
                System.out.println("\t\tThen shifting l2 to next node of it by, l2 = l2.next");
                l2 = l2.next;
            } else {
                System.out.println("\t\tif (l2 != null) -> false, means l2 does not have any value");
                System.out.println("\t\tl2 is null, skipping.");
            }

            // Calculate carry and update sum
            System.out.println("\tNow we calculate carry and update sum");
            System.out.println("\tcarry = sum / 10 = "+sum+"/10");
            carry = sum / 10;
            System.out.println("\tcarry = "+carry);
            System.out.println("\tupdating sum = sum % 10 = "+sum+"%10");
            sum = sum % 10;

            System.out.println("\tUpdated sum after carry: " + sum);
            System.out.println("\tNew carry: " + carry);

            // Add new node to result linked list
            System.out.println("\tnow we add our sum to ptr next node");
            System.out.println("\tptr.next = new ListNode(sum)");
            ptr.next = new ListNode(sum);
            System.out.println("\tCreated new ListNode with value: " + sum);
            ptr = ptr.next; // Move pointer to the new node
            System.out.println("\tPointer moved to the new node.");
            iteration++;
        }

        // Step 4: If there's any remaining carry, add it as a new node
        if (carry != 0) {
            System.out.println("\nif (carry != 0) -> true, means the carry still holds the value");
            System.out.println("Final carry detected, adding new ListNode with carry value: " + carry);
            ptr.next = new ListNode(carry);
        }

        System.out.println("Final result linked list created.\n");

        // Return the next node of result (skipping the dummy node)
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
