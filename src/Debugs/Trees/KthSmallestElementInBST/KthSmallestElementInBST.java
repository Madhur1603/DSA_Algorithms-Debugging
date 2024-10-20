package Debugs.Trees.KthSmallestElementInBST;

import java.util.*;

public class KthSmallestElementInBST {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static class Trees {
        public static String toString(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root == null) {
                return result.toString();
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    result.add("null");
                } else {
                    result.add(String.valueOf(node.val));
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            // Remove trailing "null"s
            while (result.size() > 0 && result.get(result.size() - 1).equals("null")) {
                result.remove(result.size() - 1);
            }
            return result.toString();
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
        Integer[] arr = {5,3,6,2,4,null,null,1};
        TreeNode root = buildTree(arr);
        System.out.println(Trees.toString(root));
        int k = 3;
        int ans = kthSmallest(root, k);
        System.out.println(ans);
    }

    private static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        inOrderTraversal(root, list);
        System.out.println(list);

        return list.get(k-1);
    }

    private static void inOrderTraversal(TreeNode root, List<Integer> list) {
        if(root != null){
            inOrderTraversal(root.left, list);
            list.add(root.val);
            inOrderTraversal(root.right, list);
        }
    }
}
