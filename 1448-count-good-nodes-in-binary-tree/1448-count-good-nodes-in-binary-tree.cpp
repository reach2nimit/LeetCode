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

#define rl r->left
#define rr r->right
class Solution {
public:
    
    int utilGood(TreeNode* r , int value){
        
        if(!r) return 0;
        int a =0,b=0;
        if(value<=r->val){
            
            if(rl)
                a=utilGood(rl,r->val);
            if(rr)
                b=utilGood(rr,r->val);
            return 1+a+b;
            
        }
        else{
            
            if(rl)
                a=utilGood(rl,value);
            if(rr)
                b=utilGood(rr,value);
            return a+b;
            
        }
     
    }
    
    int goodNodes(TreeNode* r) {
        
        if(!rl and !rr)
            return 1;
        
        return utilGood(r, r->val);
        
    }
};