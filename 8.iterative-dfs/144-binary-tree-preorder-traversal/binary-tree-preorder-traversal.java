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
import java.util.*;
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        // //recursive approach
        // dfs(root, result);

        //Iterative method
        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.push(root);

        while(!treeStack.isEmpty()){
            TreeNode node = treeStack.pop();
            result.add(node.val);

            if(node.right != null)
                treeStack.push(node.right);
            
            if(node.left != null)
                treeStack.push(node.left);
        }

        return result;
    }

    private void dfs(TreeNode root, List<Integer> result){

        if(root == null)
            return;
        
        result.add(root.val);
        dfs(root.left, result);
        dfs(root.right, result);
    }
}