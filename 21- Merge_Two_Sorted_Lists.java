class MergeSolution {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 != null && l2 != null){
            ListNode ansNode = new ListNode(l1.val);
            l1 = l1.next;
            ansNode.next = new ListNode(l2.val);
            l2 = l2.next;
            return mergePrime(l1, l2, ansNode.next);
        }
        else if(l1 == null && l2 != null){
            ListNode ansNode = new ListNode(l2.val);
            l2 = l2.next;
            return mergePrime(l1, l2, ansNode);
        }
        else if(l1 != null && l2 == null){
            ListNode ansNode = new ListNode(l1.val);
            l1 = l1.next;
            return mergePrime(l1, l2, ansNode.next);
        }
        else{
            return null;
        }
        
    }

    public ListNode mergePrime(ListNode m1, ListNode m2, ListNode ans){
        if(m1 == null && m2 == null){
            return ans;
        }
        else if(m1 == null && m2 != null){
            ans.next = new ListNode(m2.val);
            mergePrime(m1, m2.next, ans.next);
        }
        else if(m1 != null && m2 == null){
            ans.next = new ListNode(m1.val);
            mergePrime(m1.next, m2, ans.next);
        }
        else {
            ans.next = new ListNode(m1.val);
            ans.next.next = new ListNode(m2.val);
            mergePrime(m1.next, m2.next, ans.next.next);
        }

        return ans;
    }

    public static void main(String[] args) {
        MergeSolution classObj = new MergeSolution();
        ListNode m1 = new ListNode(1);
        m1.next = new ListNode(2);
        m1.next.next = new ListNode(4);
        ListNode m2 = new ListNode(1);
        m2.next = new ListNode(3);
        m2.next.next = new ListNode(4);
        classObj.mergeTwoLists(m1, m2);

    }
}