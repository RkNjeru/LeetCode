// https://leetcode.com/problems/repeated-substring-pattern/
// 72 / 120 test cases passed - Time Limit Exceeded
class ReapPatternSolution {

    public boolean repeatedSubstringPattern(String s) {
        boolean ans = false;

        int keyMultiple;
        String testS;
        int frontInd = 0;
        int backInd = 1;
        int jIndex;
        String subStr = s.substring(frontInd, backInd);

        if(s.length() == 1){
            return false;
        }
        // check for aa case
        testS = s.substring(0, 1) + s.substring(0, 1);
        if(testS.equals(s)){
            return true;
        }

        for(int i = 0; i < s.length()/2; i++){

            jIndex = i + 1;
            subStr = s.substring(i, jIndex);

            while(subStr.length() * 2 <= s.length()){
                if(s.length() % subStr.length() != 0){
                    // update value of subStr
                    jIndex++;
                    subStr = s.substring(i, jIndex);
                    continue;
                }
    
                keyMultiple = s.length() / subStr.length();
                testS = subStr;
                for(int k = 1; k < keyMultiple; k++){
                    testS += subStr;
                }
    
                if(testS.equals(s)) {return true;}

                // else not equal 
                jIndex++;
                subStr = s.substring(i, jIndex);
    
                continue;
            }
        }
        
        return ans;
    }

    public static void main(String[] args){
        ReapPatternSolution classObj = new ReapPatternSolution();
        String val1 = "abcabcabcabc";
        boolean ansVal = classObj.repeatedSubstringPattern(val1);
        System.out.println(ansVal);

    }
}