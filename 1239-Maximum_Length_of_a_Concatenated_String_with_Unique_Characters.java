import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class MaxConcatLenSolution {

    public int maxLength(List<String> arr) {
        if(arr == null){ return 0;}
        if(arr.size() == 1){return arr.get(0).length();}
        // int[] are passed by reference so will get updated w/ recursive calls
        int[] result = new int[1];

        maxUnique(arr, 0, "", result);

        return result[0];

    }

    public void maxUnique(List<String> anArr, int index, String curStr, int[] result){

        if(index == anArr.size() && isUnique(curStr) > result[0]){
            result[0] = curStr.length();
            return;
        }
        if(index == anArr.size()){
            return;
        }

        maxUnique(anArr, index + 1, curStr, result);
        maxUnique(anArr, index + 1, curStr + anArr.get(index), result);
        
        
    }

    public int isUnique(String str){
        char[] alpha = new char[26];

        for(char c : str.toCharArray()){
            if(alpha[c - 'a'] == 1){
                return -1;
            }
            alpha[c - 'a'] = 1;
        }
        return str.length();
    }

    public static void main(String[] args){
        List<String> ex1 = Arrays.asList("un", "iq", "ue");
        MaxConcatLenSolution classObj = new MaxConcatLenSolution();
        System.out.println(classObj.maxLength(ex1));
    }
}