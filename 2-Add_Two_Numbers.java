/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result = new ListNode();
        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;
        
        ListNode resEnd = result;
        
        int sum = 0, rem = 0;
        
        while(l1Pointer != null || l2Pointer != null){
            sum += rem;
            
            if(l1Pointer != null){
                sum += l1Pointer.val;
                l1Pointer = l1Pointer.next;
            }
            if(l2Pointer != null){
                sum += l2Pointer.val;
                l2Pointer = l2Pointer.next;
            }
            if(sum >= 10){
                rem = 1;
                sum -= 10;
            }
            else{
                rem = 0;
            }
            
            resEnd.val = sum;
            
            if(l1Pointer != null || l2Pointer != null){
                resEnd.next = new ListNode();
                resEnd = resEnd.next;
            }
            // resEnd = resEnd.next;
            
            sum = 0;
        }
        
        // factor in still existing rem
        if(rem != 0){   
            resEnd.next = new ListNode(rem);
        }
        
        return result;
    }
}