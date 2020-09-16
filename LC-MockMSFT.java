import java.util.ArrayList;
import java.util.List;

class MockMSFTSolution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public String reverseWords(String s) {
        
        int beg = 0, end = 0, endIndexer = 0, revIndexer = 0;
        
        if(s == null || s.length() == 1){
            return "";
        }
        
        char[] wordReverser = new char[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            
            if(s.charAt(i) == ' ' || i == s.length() - 1){
                // found end of word
                end = i == s.length() - 1 ? i :  i - 1;
                revIndexer = beg;
                endIndexer = end;
                
                while(revIndexer <= end){
                    wordReverser[revIndexer] = s.charAt(endIndexer);
                    endIndexer--;
                    revIndexer++;
                }
                
                if(i != s.length() - 1 ) {wordReverser[i] = ' ';};
                
                beg = i + 1;
            }
            else{
                continue;
            }
        }
        
        return new String(wordReverser);
        
    }

    public ListNode swapPairs(ListNode head) {
        
        // 1 -> 2 -> 3 -> 4
        // 2 -> 3 -> 4
        // 2 -> 1 ->2 -> 3 -> 4
        // 2 -> 1 -> 3 -> 4
        
        // 2 -> 1 -> 3 -> 4
        // 2 -> 1 -> 4 -> 3
    
        ListNode temp = new ListNode();
        
        temp = head;
        
        while(temp != null && temp.next != null){
            
            //referencing temp
            head = temp.next;
            
            head.next = temp;
            
            head.next.next = temp.next.next;
            
            temp = temp.next.next;
        }
        
        return head;
        
    }

    public static void main(String[] args){

        MockMSFTSolution classObj = new MockMSFTSolution();
        // String ex1 = "Let's take LeetCode contest";
        // System.out.println(classObj.reverseWords(ex1));

        // 1 -> 2 -> 3 -> 4

        List<String> test = new ArrayList<String>();
        

        MockMSFTSolution.ListNode ex1Node = classObj.new ListNode(1);
        ex1Node.next = classObj.new ListNode(2);
        ex1Node.next.next = classObj.new ListNode(3);
        ex1Node.next.next.next = classObj.new ListNode(4);

        MockMSFTSolution.ListNode ans = classObj.swapPairs(ex1Node);

    }
}