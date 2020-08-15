import java.util.HashMap;

class Solution{

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
        tensMap.put(4L, "Fourty");
        tensMap.put(5L, "Fifty");
        tensMap.put(6L, "Sixty");
        tensMap.put(7L, "Seventy");
        tensMap.put(8L, "Eighty");
        tensMap.put(9L, "Ninety");
    }

    public String putInWords(long number) {
        String result = "";

        if (number < 1000) {
            result = threeDigits(number);
        } // thousand
        else if (number < 1000000) {
            // 999 999
            long hundreds = number % 1000;
            if(hundreds != 0){
                result = threeDigits(hundreds);
            }
            long thousands = number / 1000;
            if(result != ""){
                result = threeDigits(thousands) + " Thousand, " + result;
            }
            else{
                result = threeDigits(thousands) + " Thousand";
            }
            

        } // million 999 999 999
        else if (number < 1000000000) {
            long hundreds = number % 1000;
            if(hundreds != 0){
                result = threeDigits(hundreds);
            }
            long thousands = (number % 1000000) / 1000;
            if(thousands != 0){
                if(result != ""){
                    result = threeDigits(thousands) + " Thousand, " + result;
                }
                else{
                    result = threeDigits(thousands) + " Thousand";
                }
            }
            long millions = number / 1000000;
            if(result != ""){
                result = threeDigits(millions) + " Million, " + result;
            }
            else{
                result = threeDigits(millions) + " Million";
            }
            
        }
        // billion
        else if (number < 1000000000000L) {
            long hundreds = number % 1000;
            if(hundreds != 0){
                result = threeDigits(hundreds);
            }
            long thousands = (number % 1000000) / 1000;
            if(thousands != 0){
                if(result != ""){
                    result = threeDigits(thousands) + " Thousand, " + result;
                }
                else{
                    result = threeDigits(thousands) + " Thousand";
                }
            }
            long millions = (number % 1000000000L) / 1000000;
            if(millions != 0){
                if(result != ""){
                    result = threeDigits(millions) + " Million, " + result;
                }
                else{
                    result = threeDigits(millions) + " Million";
                }
            }
            long billions = number / 1000000000L;
            if(result != ""){
                result = threeDigits(billions) + " Billion, " + result;    
            }
            else{
                result = threeDigits(billions) + " Billion";
            }
                
        }

        else{
            result = "invalid number";
        }

        return result.replace("  ", " ");
    }

    public String threeDigits(long number){
        String result = "";
        if (number >= 10) {

            long tens = number % 100;
            if (teens.containsKey(tens)) {
                // 10 - 19
                result = teens.get(tens);
            } else {
                // 20 - 99
                long onesPlace = number % 10;
                if(onesPlace != 0){    result = ones.get(onesPlace);} 
                long tensPlace = (number % 100) / 10;
                if(tensPlace != 0){
                    result = tensMap.get(tensPlace) + " " + result;    
                }
            }
            // hundreds place
            if (number >= 100) {
                long hundredsPlace = (number / 100);
                if(hundredsPlace != 0){
                    if(result != ""){
                        result = ones.get(hundredsPlace) + " Hundred and " + result;
                    }
                    else{
                        result = ones.get(hundredsPlace) + " Hundred";
                    }
                    
                }
            }
        } 
        else {
            result = ones.get(number);
        }
        return result;
    }

}