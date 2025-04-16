/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<TreeNode, TreeNode> parentMap;
    private Set<TreeNode> visitedNode;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> result = new ArrayList();
        if(root==null)
            return result;
        
        parentMap = new HashMap();
        buildParentMap(root);
        
        visitedNode = new HashSet();
        findTarget(target, 0, k, result);

        return result;
    }

    private void findTarget(TreeNode node, int distance, int k, List<Integer> result){

        if(node==null || visitedNode.contains(node))
            return;
        
        visitedNode.add(node);
        
        if(distance==k){
            result.add(node.val);
            return;
        }

        if(node.left!=null)
            findTarget(node.left, distance+1, k, result);
        
        if(node.right!=null)
            findTarget(node.right, distance+1, k, result);

        if(parentMap.get(node)!=null)
            findTarget(parentMap.get(node), distance+1, k ,result);
    }

    private void buildParentMap(TreeNode node){

        if(node==null)
            return;
        
        if(node.left!=null){
            parentMap.put(node.left, node);
            buildParentMap(node.left);
        }

        if(node.right!=null){
            parentMap.put(node.right, node);
            buildParentMap(node.right);
        }
    }
}