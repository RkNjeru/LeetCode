class Solution {
    public int myAtoi(String str) {
        
        if(str == null || str.length() == 0){ return 0;}
        
        str = str.trim();
        if(str.length() == 0){ return 0;}
        
        int begIndex = 0, multiplier = 1, endIndex = 0;
        
        
        if(str.charAt(begIndex) == '-'){
            multiplier = -1;
            begIndex++;
        }
        else if(str.charAt(begIndex) == '+'){
            begIndex++;
        }
        
        if(begIndex < str.length() && (str.charAt(begIndex) >= '0' && str.charAt(begIndex) <= '9')){
            endIndex = begIndex + 1;
            
            while(endIndex < str.length() && (str.charAt(endIndex) >= '0' && str.charAt(endIndex) <= '9')){
                endIndex++;
            }
            
            String numStr = str.substring(begIndex, endIndex);
            
            try{
                return multiplier * Integer.parseInt(numStr);    
            }
            catch(Exception e){
                if(multiplier == -1){
                    return Integer.MIN_VALUE;
                }
                else{
                    return Integer.MAX_VALUE;
                }
            }
                    
        }
        else{
            return 0;
        }
        
    }
}