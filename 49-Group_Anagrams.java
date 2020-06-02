import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class AnagramSolution{

    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> result = new ArrayList<>();

        HashMap<Integer, String> passed = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++){
            if(passed.containsKey(i)){
                continue;
            }
            if(passed.size() == strs.length){
                break;
            }
            String curWord = strs[i];

            passed.put(i, curWord);

            List<String> curSet = new ArrayList<>();
            curSet.add(curWord);

            for(int j = i + 1; j < strs.length; j++){
                if(passed.containsKey(j)){
                    continue;
                }

                String testAnagram = strs[j];
                if(isAnagram(curWord, testAnagram)){
                    passed.put(j, testAnagram);
                    curSet.add(testAnagram);
                }
            }


            result.add(curSet);
        }
        return result;
    }

    public boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        else{
            char[] ArrayS1 = str1.toCharArray();
            char[] ArrayS2 = str2.toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            return Arrays.equals(ArrayS1, ArrayS2);
        }
    }

    public static void main(String[] args){
        AnagramSolution classObj = new AnagramSolution();

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = classObj.groupAnagrams(input);
        
        for(List<String> group : ans){
            System.out.println(group);
        }
    }
}