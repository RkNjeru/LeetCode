class ValidPalinSolution{

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int low = 0, high = s.length() - 1, uBound = s.length() - 1;
        
        while(low <= high){
            while(!isAlpha(s.charAt(low))){
                low++;
                if(low > uBound){return false;}
            }
            while(!isAlpha(s.charAt(high))){
                high--;
                if(high < 0){return false;}
            }
            if(s.charAt(low) == s.charAt(high)){
                low++;
                high--;
            }
            else{
                return false;
            }
        }
        return true;
        
    }
    
    
    public boolean isAlpha(char c){
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        ValidPalinSolution classObj = new ValidPalinSolution();
        System.out.println(classObj.isPalindrome(" "));
    }
}