/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        
        
        int pVal = p->val, qVal=q->val;
        TreeNode* node = root;
        
        while(node){
            
            int value = node->val;
            if(pVal<value && qVal<value)
                node = node->left;
            else if (pVal>value && qVal>value)
                node = node->right;
            else
                return node;
        }

        return NULL;
    }
};