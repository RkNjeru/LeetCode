// solution accepted -- done
// time exceeds error

// https://leetcode.com/problems/longest-palindromic-substring/
// Given a string s, find the longest palindromic substring in s. You may assume that the 
// maximum length of s is 1000

class OtherSolution {
    public String longestPalindrome(String s) {
        if(s.length() == 0){
            return "";
        }

        String curMaxPalindrome = s.substring(0,1);
        
        //traverse through the string with indexing at each letter
        for(int i = 0; i < s.length(); i++)
        {
            for(int j = i +1; j <= s.length(); j++)
            {
                String currentWord = s.substring(i, j);
                if(isPalindrome(currentWord) & currentWord.length() > curMaxPalindrome.length()){
                    curMaxPalindrome = currentWord;
                }
            }
        }
        
        return curMaxPalindrome;
    }

    public boolean isPalindrome(String aWord)
    {
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
        String word = "";
        
        String ans = solObj.longestPalindrome(word);
        System.out.println(ans + " is the longest Palindrome in " + word);
    }
}