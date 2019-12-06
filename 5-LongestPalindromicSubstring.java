// https://leetcode.com/problems/longest-palindromic-substring/
// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000

class OtherSolution {
    public String longestPalindrome(String s) {
        
        //traverse through the string with indexing at each letter
        for(int i = 0; i < s.length(); i++)
        {
            for(int j = i +1; j <= s.length(); j++)
            {
                String currentWord = s.substring(i, j);
            }
        }
        
        return "text";
    }

    public boolean isPalindrome(String aWord)
    {
        // start with first and last chars
        // len of 'chars' = 5. should stop at backIndex = 3 (len/2 + 1)
        // len of 'last' = 4. should stop at backIndex = 2 (len/2)
        int strLen = aWord.length();
        boolean ans = false;
        
        int stopIndex = (strLen%2 == 0) ? strLen/2 : strLen/2 + 1;
        int frontIndex = 0;
        int backIndex = strLen - 1;

        while(backIndex >= stopIndex)
        {
            if(aWord.charAt(frontIndex) == aWord.charAt(backIndex))
            {
                frontIndex++;
                backIndex--;
                ans = true;
                continue;
            }
            else
            {
                ans = false;
                break;
            }
        }
        
        return ans;
    }

    public static void main(String [] args)
    {
        OtherSolution solObj = new OtherSolution();
        String word = "tattarrattat";
        
        // test isPalindrome
        Boolean ans = solObj.isPalindrome(word);
        String val = (ans) ? " is a palindrome" : " is not a palindrome";
        System.out.println(word + val);
        
        // String ans = solObj.longestPalindrome(word);
        // System.out.println("Longest Palindrome in: " + word + " is: " + ans);
    }
}