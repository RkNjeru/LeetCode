// https://leetcode.com/problems/longest-palindromic-substring/
// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000

class Solution {
    public String longestPalindrome(String s) {
        return "text";
    }
    
    public boolean isPalindrome(String aWord)
    {
        return false;
    }

    public static void main(String [] args)
    {
        Solution solObj = new Solution();
        String word = "babad";
        String ans = solObj.longestPalindrome(word);
        System.out.println("Longest Palindrome in: " + word + " is: " + ans);
    }
}