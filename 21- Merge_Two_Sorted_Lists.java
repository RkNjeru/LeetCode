class MergeSolution {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(final int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }
            else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        if(l1 != null){
            dummy.next = l1;
        }
        else {
            dummy.next = l2;
        }
        return head.next;

    }

    
    public static void main(final String[] args) {
        final MergeSolution classObj = new MergeSolution();
        final ListNode m1 = new ListNode(1);
        m1.next = new ListNode(2);
        m1.next.next = new ListNode(4);
        final ListNode m2 = new ListNode(1);
        m2.next = new ListNode(3);
        m2.next.next = new ListNode(4);
        ListNode finalAns = classObj.mergeTwoLists(m1, m2);
        while(finalAns != null){
            System.out.println(finalAns.val);
            finalAns = finalAns.next;
        }


    }
}