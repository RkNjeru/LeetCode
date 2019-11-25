// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Given a string, find the length of the longest substring without repeating characters
// longest string with unique characters

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
                if(curVal != nextVal)
                {
                    curVal = s.charAt(jIndex + 1);
                    nextVal = s.charAt(jIndex + 2);
                    jIndex++;
                    curLen++;
                }
                else
                {
                    jIndex++;
                    break;
                }

            }

            if( curLen > longestLen)
            {
                longestLen = curLen;
            }
        }

        System.out.println("text" + s);
        return longestLen;
    }

    public static void main(String [] args)
    {
        Solution classObj = new Solution();
        classObj.lengthOfLongestSubstring("abcabcbb");
    }
}