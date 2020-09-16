// valid implementation
// time exceeds error
// 93 / 103 test cases passed

// https://leetcode.com/problems/longest-palindromic-substring/
// Given a string s, find the longest palindromic substring in s. You may assume that the 
// maximum length of s is 1000

class OtherSolution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        String maxPal = "";
        
        for(int i = 0; i < s.length(); i++){
            
            Pair<Integer, String> pairOdd = longest(s, i, i + 1);
            
            if(pairOdd.getKey() > maxLength){
                maxLength = pairOdd.getKey();
                maxPal = pairOdd.getValue();
            }
            
            Pair<Integer, String> pairEven = longest(s, i , i);
            
            if(pairEven.getKey() > maxLength){
                maxLength = pairEven.getKey();
                maxPal = pairEven.getValue();
            }
        }
        
        return maxPal;
        
    }
    
    public Pair<Integer, String> longest(String str, int beg, int end){
        
        int thisMax = 0;
        String thisStr = "";
        
        String temp = str.substring(beg, end);

        while(beg >= 0 && end <= str.length() && isPalindrome(temp)){
            if(temp.length() > thisMax){
                thisMax = temp.length();
                thisStr = temp;
            }
            beg--;
            end++;
            if(beg < 0 || end > str.length()){break;}
            temp = str.substring(beg, end);

        }
        
        return new Pair(thisMax, thisStr);
    }
    
    public boolean isPalindrome(String s){
        if(s == null || s.length() == 0){return true;}
        for(int i = 0; i <= (s.length() - 1 ) / 2; i++){
            if(s.charAt(i) == s.charAt(s.length() - 1 - i)){
                continue;
            }
            else{
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        OtherSolution solObj = new OtherSolution();
        String word = "";

        String ans = solObj.longestPalindrome(word);
        System.out.println(ans + " is the longest Palindrome in " + word);
    }
}