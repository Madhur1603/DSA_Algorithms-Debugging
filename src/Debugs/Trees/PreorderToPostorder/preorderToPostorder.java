package Debugs.Trees.PreorderToPostorder;

import java.util.*;

public class preorderToPostorder {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 1; i < arr.length; i++) {
            TreeNode currentNode = queue.poll();
            if (arr[i] != null) {
                currentNode.left = new TreeNode(arr[i]);
                queue.add(currentNode.left);
            }
            // Move to the next index for the right child
            if (++i < arr.length && arr[i] != null) {
                currentNode.right = new TreeNode(arr[i]);
                queue.add(currentNode.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {15, 10, 20, 5, 12};
        TreeNode root = buildTree(nums);
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        System.out.println(list);
    }

    private static void postorderTraversal(TreeNode root, List<Integer> list) {
        if(root != null){
            postorderTraversal(root.left, list);
            postorderTraversal(root.right, list);
            list.add(root.val);
        }
    }
}
