class Solution {
    public boolean isPalindrome(String s) {
        if(s == null){return false;}
        
        s = s.trim();
        s = s.toLowerCase();
        
        if(s.length() == 0){return true;}
        
        int begIndex = 0, endIndex = s.length() - 1;
        
        while(begIndex <= endIndex){
            while(begIndex < s.length() - 1 && !isAlpha(s.charAt(begIndex))){
                begIndex++;
            }
            while(endIndex > 0 && !isAlpha(s.charAt(endIndex))){
                endIndex--;
            }
            
            if((!isAlpha(s.charAt(begIndex)) && !isAlpha(s.charAt(endIndex))) || (s.charAt(begIndex) == s.charAt(endIndex))){
                begIndex++;
                endIndex--;
            }
            else{
                return false;
            }
        }
        
        return true;
        
    }
    
    public boolean isAlpha(char c){
        if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')){
            return true;
        }
        else{return false;}

    }
}