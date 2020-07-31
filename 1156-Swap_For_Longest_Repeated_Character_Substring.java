class SwapSolution{

    public int maxRepOpt1(String text) {
        int curMax = 1, themax = 1;
        for(int i = 0; i < text.length(); i++){
            int tempMax = generateSwaps(text, i, 0, curMax);
            if(tempMax > themax){
                themax = tempMax;
            }
        }
        return themax;    
    }

    public int generateSwaps(String text, int beg, int swapInd, int curMax){
        char[] temp = text.toCharArray();
        char begChar = temp[beg];
        temp[beg] = temp[swapInd];
        temp[swapInd] = begChar;
        String tempStr = new String(temp);
        int curLongest = longestStreak(tempStr);
        if(curLongest > curMax){
            curMax = curLongest;
        }

        if(swapInd == text.length() - 1){
            return curMax;
        }
        else{
            return generateSwaps(text, beg, swapInd + 1, curMax);
        }

    }

    public int longestStreak(String text){
        int longest = 1, curStreak = 1;
        
        for(int i = 1; i < text.length(); i++){
            if(text.charAt(i) == text.charAt(i - 1)){
                curStreak++;
                if(curStreak >= longest){
                    longest = curStreak;
                }
            }
            else{
                curStreak = 1;
            }
        }
        
        return longest;
    }

    public static void main(String[] args){
        SwapSolution classObj = new SwapSolution();
        String ex1 = "ababa";
        String ex2 = "aaabaaa";
        String ex3 = "aaabbaaa";
        String ex4 = "aaaaa";
        String ex5 = "abcdef";
        String ex6 = "aabbbbbbbbbbabbbaabaaaaaaabababaaaaaababaaababbabbbabbbbaabbbbaabaaaaabaabbababbbaaaaaaabbbbaabbbaabaaaabaaabababaaababbbaaababaaaababbabbaabbaabbabbbabbbaabaabbabaaaaabbbbabaaabbaaabbaabbabbaabbbbaabaaababbbbaabaaaabbbaababaaaabaaaababaababbabaaaabaabaaababababaabbbbbbabbabbbabaabbabbbabaaabaabaaaabaaabbbbbbbbbaaabbababaaaabaaabbaaabbabbbaaababababbbbbbbbbbbabbbbbbaabbbaaababbaabaabbbababbaaaababaabababbbbbbababbabbaabbabababaababbbbaaaaabababbaabbaabaaabbaababaaabbbaaaabaaababbbbabbabbabaababbbabbbbbbbbaaaaabbbabbaaababaabbbbabbbabaabbabbbbaaabbbaabbaaaaaaabbbbbabaabbbaabbbaaaaabbbabaaaaabbabbabbabbaabaaaaabaabbbaaaababaaabbaabbbaabbaaaaaaaaabbbbaabbaaabaabbbbbbbaababababaabbbbbbbbabbbbabaaabaaaabbaaabbaaababbbbababaaabbbabaabaabaaaabbbaabaabbbbbabbaabbaabababbabbbbbbabaaaabbababbbababbbabbabababbbbbababaababbbabaabbbabbbaabbabaabbabaabaabbabbbaaabababbabbbabbaabbaababbbaabaabaabaaaaababbbbbaaaaaaaaaabaaaaaaaaabbbbabaababbbbaaaabbaabaaaabbbaabbaaabbaaababbbabaaabbbbaaabbbbaabbabbbbab";
        // System.out.println(classObj.longestStreak("ababa"));
        System.out.println(classObj.maxRepOpt1(ex6));
        
    }
}