import java.util.HashMap;

class RomanSolution{
    public int romanToInt(String s){
        int sum = 0;
        int endInd = s.length() - 1;
        
        HashMap<Character, Integer> valueMap = new HashMap<Character, Integer>();
        valueMap.put('I', 1);
        valueMap.put('V', 5);
        valueMap.put('X', 10);
        valueMap.put('L', 50);
        valueMap.put('C', 100);
        valueMap.put('D', 500);
        valueMap.put('M', 1000);

        boolean skipflag = false;

        for(int i = 0; i < s.length(); i++){
            if(skipflag){
                skipflag = false;
                continue;
            }

            if(i != endInd && (s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X'))){
                sum += valueMap.get(s.charAt(i + 1)) - valueMap.get(s.charAt(i));
                skipflag = true;
            }
            else if(i != endInd && (s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C'))){
                sum += valueMap.get(s.charAt(i + 1)) - valueMap.get(s.charAt(i));
                skipflag = true;
            }
            else if(i != endInd && (s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M'))){
                sum += valueMap.get(s.charAt(i + 1)) - valueMap.get(s.charAt(i));
                skipflag = true;
            }
            else{
                sum += valueMap.get(s.charAt(i));
            }


        }
        
        return sum;
    }

    public static void main(String[] args){
        RomanSolution classObj = new RomanSolution();
        String testVal = "MCMXCIV";
        int ans = classObj.romanToInt(testVal);
        System.out.println(ans);
    }
}