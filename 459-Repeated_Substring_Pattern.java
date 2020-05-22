// https://leetcode.com/problems/repeated-substring-pattern/
class ReapPatternSolution {

    public boolean repeatedSubstringPattern(String s){
        String testStr = "";
        int sLength = s.length();
        for(int i = 1; i < sLength/2 + 1; i++){
            String curSubStr = s.substring(0, i);
            int multVal = sLength/curSubStr.length();
            for(int j = 0; j < multVal; j++){
                testStr += curSubStr;
            }
            if(testStr.equals(s)){
                return true;
            }
            else{
                testStr = "";
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args){
        ReapPatternSolution classObj = new ReapPatternSolution();
        String val1 = "aba";
        boolean ansVal = classObj.repeatedSubstringPattern(val1);
        System.out.println(ansVal);

    }
}