// solution accepted -- done

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Given a string, find the length of the longest substring without repeating characters
// ie. longest string with unique characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestLen = 0;
        if (s.length() >= 1) {
            longestLen = 1;
        }

        for (int i = 0; i <= s.length() - 2; i++) {
            int jIndex = i + 1;
            String curStr = s.substring(i, jIndex);
            String nextChar = s.substring(jIndex, jIndex + 1);
            int uniqueCounter = 1;

            while (i <= s.length() - 2) {

                if (!curStr.contains(nextChar)) {
                    jIndex++;
                    curStr = s.substring(i, jIndex);
                    uniqueCounter++;
                    if (jIndex < s.length()) {
                        nextChar = s.substring(jIndex, jIndex + 1);
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

            if (uniqueCounter > longestLen) {
                longestLen = uniqueCounter;
            }
        }

        return longestLen;
    }

    public static void main(String[] args) {
        Solution classObj = new Solution();
        int ans = classObj.lengthOfLongestSubstring("abcabcbb");
        System.out.println("length of longest substring: " + ans);
    }
}