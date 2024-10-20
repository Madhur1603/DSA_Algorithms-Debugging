package Debugs.Queue.PrintBinaryTreeLevelsInSortedOrder;

import java.util.*;



public class printBinaryTreeLevelsInSortedOrder {

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static List<List<Integer>> levelOrderSorted(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level

            // Using PriorityQueue to keep the elements sorted
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                pq.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // Convert PriorityQueue to List
            List<Integer> currentSortedList = new ArrayList<>();
            while (!pq.isEmpty()) {
                currentSortedList.add(pq.poll());
            }
            result.add(currentSortedList);
        }

        return result;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrderSorted(root);

        System.out.println(result);
    }
}