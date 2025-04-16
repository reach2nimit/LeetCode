
class Solution {
public:
    TreeNode* prev = NULL;
    
    bool inorderUtil(TreeNode* r){
        if(r == NULL)
            return true;
        
        if (!inorderUtil(r->left))
            return false;
        if(prev != NULL && prev->val>=r->val)
            return false;
        
        prev = r;
        
        return inorderUtil(r->right);
        
    }
    
    bool isValidBST(TreeNode* root) {
        
        return inorderUtil(root);
    }
};