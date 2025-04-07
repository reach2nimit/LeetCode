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
class BSTIterator {
    Stack<TreeNode> treeStack;

    private void pushAllLeft(TreeNode node){
        while(node!=null){
            treeStack.push(node);
            node = node.left;
        }
    }

    public BSTIterator(TreeNode root) {
        this.treeStack = new Stack<>();
        pushAllLeft(root);
    }
    
    public int next() {
        TreeNode node = treeStack.pop();
        pushAllLeft(node.right);
        return node.val;    
    }
    
    public boolean hasNext() {
        
        return !treeStack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */