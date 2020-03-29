import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

// https://leetcode.com/problems/most-common-word/

class CommonWordSolution{

    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedList = new HashSet<String>();
        for(String aWord : banned) { bannedList.add(aWord);}
        HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
        ArrayList<String> uniqueGoodWords = new ArrayList<String>();

        paragraph = paragraph.replaceAll("[^a-zA-Z]", " ");
        paragraph = paragraph.replaceAll("[ ]+", " ");

        paragraph = paragraph.toLowerCase();

        String mostCommon = "";
        int maxAppearance = 0;

        // split paragraph into array of only words

        String[] wordArray = paragraph.split(" ");

        // for each word, if word is not in bannedList, count its occurrence
        // if occurence is greater than maxAppearance, update mostCommon and maxAppearance

        for(String word : wordArray){
            if(!bannedList.contains(word)){
                if(wordCounts.containsKey(word)){
                    wordCounts.put(word, wordCounts.get(word) + 1);
                }
                else{
                    wordCounts.put(word, 1);
                    uniqueGoodWords.add(word);
                }
            }
        }

        for(String unique : uniqueGoodWords){
            if(wordCounts.get(unique) > maxAppearance) { 
                maxAppearance = wordCounts.get(unique);
                mostCommon = unique;
            }
        }

        return mostCommon;
    }

    public static void main(String[] args){
        CommonWordSolution classObj = new CommonWordSolution();

        String aParagraph = "Bob. hIt, baLl";
        String[] aBanned = {"bob", "hit"};

        System.out.println(classObj.mostCommonWord(aParagraph, aBanned));

    }
}