/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    vector<vector<int>> ans;
    
    void utilPathSum(TreeNode* r, int T, vector<int> temp){
        
        if(!r) return;
        temp.push_back(r->val);
        T-=r->val;
        
        if(!r->left and !r->right and T==0){
            ans.push_back(temp);
            return;
        }
        
      utilPathSum(r->left, T, temp);
      utilPathSum(r->right, T, temp);  
    }
    
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
    
        vector<int> temp;
        utilPathSum(root, targetSum, temp);
        
        return ans;
    }
};