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
    String result = null;
    public String smallestFromLeaf(TreeNode root) {
        
        dfs(root, new StringBuilder());
        return result;
    }

    public void dfs(TreeNode root, StringBuilder sb){
        if(root == null)
            return;
        
        sb.append((char)('a' + root.val));
        if(root.left == null && root.right == null ){

            String candidate = sb.reverse().toString();
            sb.reverse();

            if(result == null || candidate.compareTo(result)<0)
                result = candidate;
        }

        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);

    }
}