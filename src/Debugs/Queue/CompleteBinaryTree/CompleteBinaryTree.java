package Debugs.Queue.CompleteBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

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
        // It can be solved using the BFS traversal;
        if(root == null){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean encounteredNull = false;

        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();

            if(currentNode == null){
                encounteredNull = true;
            }
            else{
                if(encounteredNull){
                    return false;
                }
                else{
                    queue.add(currentNode.left);
                    queue.add(currentNode.right);
                }
            }

        }
        return true;
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