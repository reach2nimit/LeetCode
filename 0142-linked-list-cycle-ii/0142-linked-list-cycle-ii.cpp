/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
       
        if(!head || !head->next) return NULL;
        
        ListNode * slow = head, *fast = head, *res = head;
        
        
        while(fast->next && fast->next->next){
            
            slow = slow->next;
            fast = fast->next->next;
            
            if(slow == fast){
                while(res != slow){
                    slow = slow->next;
                    res = res->next;
                }
                return slow;
            }
                
        }
        return NULL;
    }
};