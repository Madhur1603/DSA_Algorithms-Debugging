package Debugs.Trees.InsertNodeINBST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InsertNodeInBST {
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

    public static void main(String[] args) {
        Integer[] nums = {4,2,7,1,3};
        TreeNode root = buildTree(nums);
        int val = 5;
        TreeNode ans = insertInBST(root, val);
        System.out.println(Trees.toString(ans));

    }

    private static TreeNode insertInBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode currentNode = root;

        while(true){
            if(currentNode.val <= val){
                if(currentNode.right != null) currentNode = currentNode.right;
                else{
                    currentNode.right = new TreeNode(val);
                    break;
                }
            }
            else{
                if(currentNode.left != null) currentNode = currentNode.left;
                else{
                    currentNode.left = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }

}
