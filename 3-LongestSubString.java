// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Given a string, find the length of the longest substring without repeating characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestLen = 0;
        int curLen = 0;

        // loop through string
        for(int i = 0; i < s.length() - 1; i++)
        {
            char curVal = s.charAt(i);
            char nextVal = s.charAt(i + 1);
            int jIndex = i;

            while (jIndex < s.length() - 1)
            {
                
            }
        }

        System.out.println("text" + s);
        return 3;
    }

    public static void main(String [] args)
    {
        Solution classObj = new Solution();
        classObj.lengthOfLongestSubstring("abcabcbb");
    }
}