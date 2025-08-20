/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public boolean helper(TreeNode root, int target, Set<Integer> numSet){

        if(root == null)
            return false;

        if(numSet.contains(target - root.val))
            return true;

        numSet.add(root.val);

        return helper(root.left, target, numSet) || helper(root.right, target, numSet);
    }
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> numSet = new HashSet();
        return helper(root, k, numSet);
    }
}