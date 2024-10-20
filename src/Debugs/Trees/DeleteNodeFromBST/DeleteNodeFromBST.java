package Debugs.Trees.DeleteNodeFromBST;

import Debugs.Trees.ArrayToBST.ArrayToBst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeleteNodeFromBST {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }



    private static TreeNode constructBST(int[] arr, int left, int right) {
        if(left > right){
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(arr[mid]);

        root.left = constructBST(arr, left, mid-1);
        root.right = constructBST(arr, mid+1, right);

        return root;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,7};
        TreeNode root = constructBST(arr, 0, arr.length - 1);
        int key = 3;
        TreeNode result = deleteNode(root, key);
        System.out.println(Trees.toString(result));

    }

    private static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }

        if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            root.val = minimumNode(root.right);
            root.right = deleteNode(root.right, root.val);
        }


        return root;
    }

    private static int minimumNode(TreeNode rightNode) {
        int minV = rightNode.val;
        while(rightNode.left != null){
            minV = rightNode.left.val;
            rightNode = rightNode.left;
        }
        return minV;
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
