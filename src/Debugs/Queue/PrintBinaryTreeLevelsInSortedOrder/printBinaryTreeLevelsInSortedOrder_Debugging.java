package Debugs.Queue.PrintBinaryTreeLevelsInSortedOrder;
import java.util.*;

public class printBinaryTreeLevelsInSortedOrder_Debugging {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static List<List<Integer>> levelOrderSorted(TreeNode root) {
        System.out.println("\nInitializing : ");
        System.out.println("List<List<Integer>> result = new ArrayList<>(), means result is a list of (list of integer).");
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            System.out.println("\tif(root == null), means root is null");
            System.out.println("\tThe tree is empty, no levels to process.");
            return result;
        }
        System.out.println("Queue<TreeNode> queue = new LinkedList<>()");
        System.out.println("queue.add(root), add the root to the queue");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.println("\nwhile(!queue.isEmpty()) -> true, until the queue is not empty the loop will iterate");
        int iterate = 1;
        while (!queue.isEmpty()) {
            System.out.println("\nOuter Loop : "+iterate);
            int levelSize = queue.size(); // as at starting queue has only root but by iterating more element will get add into the queue and hence the current level size increases

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            System.out.println("\tInitializing : pq = new PriorityQueue<>(), as we store the value from the queue to this priority queue so that all elements get sorted");

            int inner = 1;
            for (int i = 0; i < levelSize; i++) {
                System.out.println("\n\tInner loop : "+inner);
                TreeNode currentNode = queue.poll(); // Get the front node from the queue
                System.out.println("\t\tcurrentNode = queue.poll(), processing node with value: " + currentNode.val);

                // Add the node's value to the priority queue (for sorting)
                pq.add(currentNode.val);
                System.out.println("\t\tpq.add(currentNode.val), added value " + currentNode.val + " to the priority queue for sorting.");

                // If the current node has a left child, add it to the queue
                if (currentNode.left != null) {
                    System.out.println("\t\t\tif(currentNode.left != null) -> true, means left node of the currentNode is not null and have a value");
                    queue.add(currentNode.left);
                    System.out.println("\t\t\tqueue.add(currentNode.left), added left child with value " + currentNode.left.val + " to the queue.");
                }

                // If the current node has a right child, add it to the queue
                if (currentNode.right != null) {
                    System.out.println("\t\t\tif(currentNode.right != null) -> true, means right node of the currentNode is not null and have a value");
                    queue.add(currentNode.right);
                    System.out.println("\t\t\tAdded right child with value " + currentNode.right.val + " to the queue.");
                }
                inner++;
            }

            List<Integer> currentSortedList = new ArrayList<>();
            System.out.println("\tInitialized an empty list = currentSortedList");
            System.out.println("\twhile(!pq.isEmpty()) -> true, means the loop will iterate until pq does not get empty");
            int x = 1;
            while (!pq.isEmpty()) {

                System.out.println("\t\tloop : "+x);
                int smallestElement = pq.poll();
                System.out.println("\t\tsmallestElement = pq.poll(), means extracting smallest element from pq: " + smallestElement);
                currentSortedList.add(smallestElement);
                System.out.println("\t\tcurrentSortedList.add(smallestElement), adding " + smallestElement + " to currentSortedList: " + currentSortedList);
                x++;
                System.out.println();
            }
            System.out.println("\tSorted current level values: " + currentSortedList);
            System.out.println("\tresult.add(currentSortedList), adding the currentSortedList to result");
            result.add(currentSortedList);
            System.out.println("\tUpdated result list = "+result);

            iterate++;
        }

        System.out.println("\nLevel-order traversal complete. Final sorted result: " + result);
        return result;
    }



    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrderSorted(root);

    }
}
