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
    public int goodNodes(TreeNode root) {

        if(root==null)
            return 0;
        
        if(root.left==null && root.right==null)
            return 1;
        
        return utilGoodNode(root, root.val);
        
    }

    private int utilGoodNode(TreeNode node, int max){

        if(node==null)
            return 0;
        
        int count=0;
        if(node.val>=max)
            count++;
        
        max = Math.max(max, node.val);

        return utilGoodNode(node.left, max) + utilGoodNode(node.right, max) + count;
    }
}