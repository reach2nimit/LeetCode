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

        List<List<Integer>> result = new ArrayList();
        if(root==null)
            return result;
        Queue<TreeNode> zigZagQ = new LinkedList();
        boolean flag = true;
        zigZagQ.add(root);

        while(!zigZagQ.isEmpty()){
            int qSize = zigZagQ.size();
            List<Integer> temp = new ArrayList<>();

            while(qSize>0){
                TreeNode node = zigZagQ.remove();
                temp.add(node.val);
                if(node.left!=null)
                    zigZagQ.add(node.left);
                
                if(node.right!=null)
                    zigZagQ.add(node.right);
                
                
                qSize--;
            }

            if(flag)
                result.add(temp);
            else{
                Collections.reverse(temp);
                result.add(temp);
            }
                

            flag=!flag;
        }

        return result;
        
    }
}
















