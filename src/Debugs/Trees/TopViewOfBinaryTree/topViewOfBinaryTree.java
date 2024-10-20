package Debugs.Trees.TopViewOfBinaryTree;

import java.util.*;

public class topViewOfBinaryTree {
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
        Integer[] nums = {1, 2, 3, null, 4, null, 5};
        TreeNode root = buildTree(nums);
        ArrayList<Integer> result = topView(root);
        System.out.println(result);
    }

    static class Pair {
        TreeNode node;
        int hd;  // horizontal distance
        public Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    private static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int hd = current.hd;

            // If no node is added at this horizontal distance, add it to the map
            if (!map.containsKey(hd)) {
                map.put(hd, node.val);
            }

            // Add the left and right children to the queue with updated horizontal distances
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        // Collect the top view nodes from the map
        for (int value : map.values()) {
            ans.add(value);
        }

        return ans;
    }
}
