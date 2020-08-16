class Solution {
    public void reverseString(char[] s) {
        
        char front = ' ';
        int mid = s.length / 2, end = s.length - 1;
        
        for(int i = 0; i < mid; i++){
            front = s[i];
            s[i] = s[end - i];
            s[end - i] = front;
        }
        
        // return s;
    }
}