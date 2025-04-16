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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root == null)
            return result;
        
        Queue<TreeNode> rightViewQ = new LinkedList();
        rightViewQ.add(root);

        while(!rightViewQ.isEmpty()){
            int qSize = rightViewQ.size();
            TreeNode temp = null;

            while(qSize>0){
                temp = rightViewQ.poll();
                if(temp!=null && temp.left!=null)
                    rightViewQ.add(temp.left);
                
                if(temp!=null && temp.right!=null)
                    rightViewQ.add(temp.right);
                qSize--;
            }
            result.add(temp.val);
        }

        return result;
    }
}