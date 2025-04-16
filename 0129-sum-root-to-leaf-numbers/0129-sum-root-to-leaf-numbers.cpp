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

    int helper(TreeNode* root, int currSum){
        if(root==nullptr)
            return 0;
        currSum = currSum * 10 + root->val;    
        if(root->left==nullptr && root->right==nullptr)
            return currSum;
        return helper(root->left,currSum) + helper(root->right, currSum);    
    }

    int sumNumbers(TreeNode* root) {

        return helper(root, 0);
        
    }
};