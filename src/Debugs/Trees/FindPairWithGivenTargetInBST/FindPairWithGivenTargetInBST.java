package Debugs.Trees.FindPairWithGivenTargetInBST;

import java.util.HashSet;
import java.util.Set;

public class FindPairWithGivenTargetInBST {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }








    public static void main(String[] args) {
        int[] nums = {5,3,8,2,4,10};
        TreeNode root = constructBST(nums, 0, nums.length-1);
        int target = 18;
        boolean ans = havePair(root, target);
        System.out.println(ans);
    }

    private static boolean havePair(TreeNode root, int target) {
        if(root == null) return false;
        Set<Integer> set = new HashSet<>();

        return pairOccur(root, set, target);
    }

    private static boolean pairOccur(TreeNode root, Set<Integer> set, int target) {
        if(root == null) return false;

        if(set.contains(target - root.val)){
            return true;
        }

        set.add(root.val);
        return pairOccur(root.left, set, target) || pairOccur(root.right, set, target); // if both are false then false occur
    }













    private static TreeNode constructBST(int[] nums, int left, int right) {
        if(left > right) return null;

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBST(nums, left, mid-1);
        root.right = constructBST(nums, mid+1, right);

        return root;
    }
}
