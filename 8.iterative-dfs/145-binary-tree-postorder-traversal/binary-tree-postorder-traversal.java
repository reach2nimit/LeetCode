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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        // //recursive approach
        // dfs(root, result);

        //Iterative method
        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.push(root);

        while(!treeStack.isEmpty()){

            TreeNode node = treeStack.peek();
            
            if(node!=null && node.left == null && node.right== null){
                TreeNode popNode = treeStack.pop();
                result.add(popNode.val);
            }
            else {

                if(node.right!=null){
                    treeStack.push(node.right);
                    node.right=null;
                }

                if(node.left!=null){
                    treeStack.push(node.left);
                    node.left=null;
                }
            }  
        }

        return result;
    }

    private void dfs(TreeNode root, List<Integer> result){

        if(root == null)
            return;
        
        
        dfs(root.left, result);
        dfs(root.right, result);
        result.add(root.val);
    }
}