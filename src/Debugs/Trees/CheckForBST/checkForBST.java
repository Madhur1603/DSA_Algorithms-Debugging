package Debugs.Trees.CheckForBST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class checkForBST {
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
        Integer[] arr = {2,1,3};
        TreeNode root = buildTree(arr);
        boolean ans = isValidBST(root);
        System.out.println(ans);
    }

    private static boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inorderTraversal(root,list);

        int prev = list.get(0);
        for(int i=1; i<list.size(); i++){
            if(list.get(i) <= prev){
                return false;
            }
            prev = list.get(i);
        }

        return true;
    }

    private static void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root != null){
            inorderTraversal(root.left, list);
            list.add(root.val);
            inorderTraversal(root.right, list);
        }
    }


}
