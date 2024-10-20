package Debugs.Trees.ArrayToBST;

import com.sun.source.util.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArrayToBst {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};
        TreeNode root = arrayToBST(arr);
        System.out.println(Trees.toString(root));
    }

    private static TreeNode arrayToBST(int[] arr) {
        return conversionArrayToBST(arr, 0, arr.length-1);
    }

    private static TreeNode conversionArrayToBST(int[] arr, int left, int right) {
        if(left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = conversionArrayToBST(arr, left , mid-1);
        root.right = conversionArrayToBST(arr, mid+1, right);

        return root;
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
}
