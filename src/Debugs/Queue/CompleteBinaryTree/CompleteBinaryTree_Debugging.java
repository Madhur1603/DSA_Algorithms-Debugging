package Debugs.Queue.CompleteBinaryTree;

import java.util.*;

public class CompleteBinaryTree_Debugging {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static TreeNode constructTree(Integer[] array) {
        if (array.length == 0 || array[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < array.length) {
            TreeNode currentNode = queue.poll();

            // Insert the left child
            if (i < array.length && array[i] != null) {
                currentNode.left = new TreeNode(array[i]);
                queue.add(currentNode.left);
            }
            i++;

            // Insert the right child
            if (i < array.length && array[i] != null) {
                currentNode.right = new TreeNode(array[i]);
                queue.add(currentNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = constructTree(array);
        printTree(root);

        boolean result = isComplete(root);
        System.out.println("Is the tree complete? " + result);
    }

    private static boolean isComplete(TreeNode root) {
        // It can be solved using BFS traversal (level-order)
        System.out.println("\nChecking if the tree is empty or not : if(root == null)");
        if (root == null) {
            System.out.println("if (root == null) -> true, The tree is empty. A complete tree. returning true");
            return true;
        }
        System.out.println("if (root == null) -> false, Tree is not empty, continuing.");

        System.out.println("Initializing a queue and a boolean variable to ensure encountering a null value before :");
        System.out.println("Queue<TreeNode> queue = new LinkedList<>()\nqueue.add(root) -> adding the tree root node to the queue\nboolean encounteredNull = false");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean encounteredNull = false;

        System.out.println("\nStarting BFS traversal to check if the tree is complete...");
        System.out.println("while(!queue.isEmpty()) -> true, means the reverse of queue is empty, means when the queue gets empty the statement gets false and the loop stop iterating");
        int iterate = 1;
        while (!queue.isEmpty()) {
            System.out.println("\n\tLoop iteration : "+iterate);
            printQueue(queue);
            TreeNode currentNode = queue.poll();
            System.out.println("\tTreeNode currentNode = queue.poll() -> removing the top element of queue");

            if (currentNode == null) {
                System.out.println("\t\tif(currentNode == null) -> true, means currentNode is null");
                System.out.println("\t\tEncountered a null node.");
                encounteredNull = true; // From this point, no non-null node should appear
            } else {
                System.out.println("\t\tif(currentNode == null) -> false, means currentNode is not null");
                if (encounteredNull) {
                    System.out.println("\t\t\tif(encounteredNull) -> true, means non-null node found after a null node! The tree is not complete.");
                    // If a null node was seen before and now we see a non-null node, tree is not complete
                    System.out.println("\t\t\treturn false");
                    return false;
                }

                System.out.println("\t\tProcessing node with value: " + currentNode.val);
                System.out.println("\t\tAdding left child: queue.add(currentNode.left) = " + (currentNode.left != null ? currentNode.left.val : "null"));
                System.out.println("\t\tAdding right child: queue.add(currentNode.right) =" + (currentNode.right != null ? currentNode.right.val : "null"));

                // Add the left and right children to the queue for further BFS
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
            iterate++;
        }

        System.out.println("\nTree is complete. No issues found.");
        return true;
    }

    public static void printQueue(Queue<TreeNode> queue) {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }

        System.out.print("\tqueue = ");
        for (TreeNode node : queue) {
            if (node != null) {
                System.out.print(node.val + " ");
            } else {
                System.out.print("null ");
            }
        }
        System.out.println(); // For newline after the queue elements
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int currentLevelNodeCount = 1;
        while (!queue.isEmpty()) {
            int nextLevelNodeCount = 0;
            for (int i = 0; i < currentLevelNodeCount; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    System.out.print(current.val + " ");
                    if (current.left != null) {
                        queue.add(current.left);
                        nextLevelNodeCount++;
                    }
                    if (current.right != null) {
                        queue.add(current.right);
                        nextLevelNodeCount++;
                    }
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println();
            currentLevelNodeCount = nextLevelNodeCount;
        }
    }



}
