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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList();
        generatePaths(result, root, targetSum, new ArrayList());
        return result;
    }

    private void generatePaths(List<List<Integer>> result, TreeNode node, int target, List<Integer> list){

        if(node==null)
            return;
        list.add(node.val);
        if(node.left==null && node.right==null){
            if(target==node.val){
                result.add(new ArrayList(list));
            }
            
        }
        else{
            generatePaths(result, node.left, target-node.val, new ArrayList(list) );
            generatePaths(result, node.right, target-node.val, new ArrayList(list));
        }
        list.remove(list.size()-1);
    }
}