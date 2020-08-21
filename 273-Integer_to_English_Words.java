import java.util.HashMap;

class Solution {
    
    HashMap<Long, String> ones = new HashMap<Long, String>();
    {
        ones.put(0L, "Zero");
        ones.put(1L, "One");
        ones.put(2L, "Two");
        ones.put(3L, "Three");
        ones.put(4L, "Four");
        ones.put(5L, "Five");
        ones.put(6L, "Six");
        ones.put(7L, "Seven");
        ones.put(8L, "Eight");
        ones.put(9L, "Nine");
    }
    HashMap<Long, String> teens = new HashMap<>();
    {
        teens.put(10L, "Ten");
        teens.put(11L, "Eleven");
        teens.put(12L, "Twelve");
        teens.put(13L, "Thirteen");
        teens.put(14L, "Fourteen");
        teens.put(15L, "Fifteen");
        teens.put(16L, "Sixteen");
        teens.put(17L, "Seventeen");
        teens.put(18L, "Eighteen");
        teens.put(19L, "Nineteen");
    }
    HashMap<Long, String> tensMap = new HashMap<>();
    {
        tensMap.put(0L, "");
        tensMap.put(2L, "Twenty");
        tensMap.put(3L, "Thirty");
        tensMap.put(4L, "Forty");
        tensMap.put(5L, "Fifty");
        tensMap.put(6L, "Sixty");
        tensMap.put(7L, "Seventy");
        tensMap.put(8L, "Eighty");
        tensMap.put(9L, "Ninety");
    }
    
    public String numberToWords(int num) {
        String result = "";

        if (num < 1000) {
            result = threeDigits(num);
        } // thousand
        else if (num < 1000000) {
            // 999 999
            long hundreds = num % 1000;
            if(hundreds != 0){
                result = threeDigits(hundreds);
            }
            long thousands = num / 1000;
            if(result != ""){
                result = threeDigits(thousands) + " Thousand " + result;
            }
            else{
                result = threeDigits(thousands) + " Thousand";
            }
            

        } // million 999 999 999
        else if (num < 1000000000) {
            long hundreds = num % 1000;
            if(hundreds != 0){
                result = threeDigits(hundreds);
            }
            long thousands = (num % 1000000) / 1000;
            if(thousands != 0){
                if(result != ""){
                    result = threeDigits(thousands) + " Thousand " + result;
                }
                else{
                    result = threeDigits(thousands) + " Thousand";
                }
            }
            long millions = num / 1000000;
            if(result != ""){
                result = threeDigits(millions) + " Million " + result;
            }
            else{
                result = threeDigits(millions) + " Million";
            }
            
        }
        // billion
        else if (num < 1000000000000L) {
            long hundreds = num % 1000;
            if(hundreds != 0){
                result = threeDigits(hundreds);
            }
            long thousands = (num % 1000000) / 1000;
            if(thousands != 0){
                if(result != ""){
                    result = threeDigits(thousands) + " Thousand " + result;
                }
                else{
                    result = threeDigits(thousands) + " Thousand";
                }
            }
            long millions = (num % 1000000000L) / 1000000;
            if(millions != 0){
                if(result != ""){
                    result = threeDigits(millions) + " Million " + result;
                }
                else{
                    result = threeDigits(millions) + " Million";
                }
            }
            long billions = num / 1000000000L;
            if(result != ""){
                result = threeDigits(billions) + " Billion " + result;    
            }
            else{
                result = threeDigits(billions) + " Billion";
            }
                
        }

        else{
            result = "invalid num";
        }

        // return result.replace("  ", " ");
        return result;
    }
    
    public String threeDigits(long num){
        String result = "";
        if (num >= 10) {

            long tens = num % 100;
            if (teens.containsKey(tens)) {
                // 10 - 19
                result = teens.get(tens);
            } else {
                // 20 - 99
                long onesPlace = num % 10;
                if(onesPlace != 0){    result = ones.get(onesPlace);} 
                long tensPlace = (num % 100) / 10;
                if(tensPlace != 0){
                    // result = tensMap.get(tensPlace) + " " + result;   
                    result = result == "" ? tensMap.get(tensPlace) : tensMap.get(tensPlace) + " " + result;    
                }
            }
            // hundreds place
            if (num >= 100) {
                long hundredsPlace = (num / 100);
                if(hundredsPlace != 0){
                    if(result != ""){
                        result = ones.get(hundredsPlace) + " Hundred " + result;
                    }
                    else{
                        result = ones.get(hundredsPlace) + " Hundred";
                    }
                    
                }
            }
        } 
        else {
            result = ones.get(num);
        }
        return result;
    }
    
    
}