package Debugs.Trees.LCAInBST;

import java.util.*;

public class LCAinBST {
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
        Integer[] nums = {15,10,20,5,12,null,25,null,null,11};
        TreeNode root = buildTree(nums);
        TreeNode p = new TreeNode(10);
        TreeNode q = new TreeNode(11);
        TreeNode ans = findLCA(root,p,q);

        System.out.println(ans.val);
    }

    private static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else{ // here the divergence occur hence the first common point
                return root;
            }
        }

        return null;

    }


}
