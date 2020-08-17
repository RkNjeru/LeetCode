class Solution {
    public String intToRoman(int num) {
        
        String result = "";
        int index = 0;
        
        // double array "2D" array -> with 1 index which creates "map" functionality 
        
        int[] number = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        while(num > 0){
            int div = num / number[index];

            while(div > 0){
                result += roman[index];
                div--;
                num -= number[index] ;
            }

            index++;

        }
        
        return result;
    }
}