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
   //Recursive solution
  /* public TreeNode invertTree(TreeNode root) {
        
        if(root== null)
            return null;
        
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        return root;
        
    }*/
    
    // Iterative solution
    
    public TreeNode invertTree(TreeNode root){
        
        if(root == null)
            return null;
        
        Queue<TreeNode> treeQueue = new LinkedList();
        treeQueue.add(root);
        
        while(!treeQueue.isEmpty()){
            
            TreeNode curr= treeQueue.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            
            if(curr.left != null) treeQueue.add(curr.left);
            if(curr.right != null) treeQueue.add(curr.right);
        }
        return root;
    }
}