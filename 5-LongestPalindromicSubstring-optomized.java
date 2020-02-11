// valid implementation
// time exceeds error
// 59 / 103 test cases passed

// https://leetcode.com/problems/longest-palindromic-substring/
// Given a string s, find the longest palindromic substring in s. You may assume that the 
// maximum length of s is 1000

class OtherSolutionG {
    public String longestPalindrome(String s) {
        if(s.length() == 0){
            return "";
        }

        String curMaxPalindrome = s.substring(0,1);
        StringBuilder sb = new StringBuilder(s);

        String revString = sb.reverse().toString();

        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j < s.length() + 1; j++){
                String curString = s.substring(i, j);
                if(revString.contains(curString) & isPalindrome(curString) & curString.length() > curMaxPalindrome.length()){
                    curMaxPalindrome = curString;
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
        OtherSolutionG solObj = new OtherSolutionG();
        String word = "aacdefcaa";
        
        String ans = solObj.longestPalindrome(word);
        System.out.println(ans + " is the longest Palindrome in " + word);
    }
}