/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public int listLength(ListNode n){
        if(n == null)
            return 0;
        else
            return 1 + listLength(n.next);
    }
    
    public ListNode add(ListNode l1, ListNode l2){
        
        Stack<Integer> l1_s = new Stack<>();
        Stack<Integer> l2_s = new Stack<>();
        
        while(l1!=null && l2!=null){
            l1_s.push(l1.val);
            l2_s.push(l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        
        ListNode sum = null;
        
        boolean plus = false;
        
        while(l1_s.size()!=0 && l2_s.size()!=0){
            int l1_val = l1_s.pop();
            int l2_val = l2_s.pop();
            int val_sum = l1_val + l2_val;
            
            if(plus){
                val_sum += 1;
                if(val_sum >= 10){
                    val_sum = val_sum%10;
                }
                else
                    plus = false;
            }
            else{
                if(val_sum >= 10){
                    val_sum = val_sum % 10;
                    plus = true;
                }
            }
            
            ListNode new_sum = new ListNode(val_sum);
            new_sum.next = sum;
            sum = new_sum;
        }
        
        return sum;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.val == 0 && l1.next == null)
            return l2;
        if(l2.val == 0 && l2.next == null)
            return l1;
        
        int length1 = listLength(l1);
        int length2 = listLength(l2);
        
        ListNode resNode = new ListNode(0);
        if(length1 > length2){
            ListNode extended_l2 = new ListNode(0);
            ListNode extended_l2_iter = extended_l2;
            for(int i = 0; i < length1-length2 - 1;i++){
                extended_l2_iter.next = new ListNode(0);
                extended_l2_iter = extended_l2_iter.next;
            }
            
            ListNode l1_temp = new ListNode(0);
            ListNode l2_temp = new ListNode(0);
            
            l1_temp.next = l1;
            l2_temp.next = extended_l2;
            
            extended_l2_iter.next = l2;
            ListNode sum = add(l1_temp, l2_temp);
            
            if(sum.val == 0)
                return sum.next;
            else
                return sum;
        }
        else if(length1 < length2){
            ListNode extended_l1 = new ListNode(0);
            ListNode extended_l1_iter = extended_l1;
            for(int i = 0; i < length2-length1 - 1;i++){
                extended_l1_iter.next = new ListNode(0);
                extended_l1_iter = extended_l1_iter.next;
            }
            
            ListNode l1_temp = new ListNode(0);
            ListNode l2_temp = new ListNode(0);
            
            l2_temp.next = l2;
            l1_temp.next = extended_l1;
            
            extended_l1_iter.next = l1;
            ListNode sum = add(l1_temp, l2_temp);
            
            if(sum.val == 0)
                return sum.next;
            else
                return sum;
                
        }
        else{
            ListNode l1_temp = new ListNode(0);
            ListNode l2_temp = new ListNode(0);
            l1_temp.next = l1;
            l2_temp.next = l2;
            ListNode res = add(l1_temp, l2_temp);
            if(res.val == 0)
                return res.next;
            else
                return res;
        }
        
    }
}