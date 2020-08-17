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
    
    // rev, head
    // {}, {1->2->3->4->5}
    // {1}, {2->3->4->5}
    // {2->1}, {3->4->5}
    // {3->2->1}, {4->5}
    // {4->3->2->1}, {5}
    // {5->4->3->2->1}, {}

    public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
    
    public ListNode reverseList(ListNode head) {
        ListNode rev = null;
        
        while(head != null){
            ListNode headNext = head.next;
            ListNode revNext = rev;
            rev = head;
            rev.next = revNext;
            head = headNext;
        }
        
        return rev;
    }
}