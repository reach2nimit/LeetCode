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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        Boolean level = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            int qSize = q.size();
            List<Integer> temp = new ArrayList<>();
            
            while(qSize>0){
                
                TreeNode curr = q.remove();
                temp.add(curr.val);
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
                qSize--;
            }
            if(level)
                result.add(temp);
            else{
                Collections.reverse(temp);
                result.add(temp);
            }
            level = !level;
        }
        
        
        return result;
    }
}