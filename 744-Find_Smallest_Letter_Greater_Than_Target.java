class SmallestThanTargetSolution{

    public char nextGreatestLetter(char[] letters, char target) {
        boolean[] exists = new boolean[123];
        
        for(int i = 0; i < letters.length; i++){
            exists[letters[i]] = true;
        }
        
        int index = target + 1;
        
        while(true){
            if(index > 122){
                index = index - 26;
            }
            
            if(exists[index]){
                return (char) index;
            }
            else{
                index++;
            }
        }
    }

    // public char find(char[] letArray, char mTarget, b)

    public static void main(String[] args){
        SmallestThanTargetSolution classObj = new SmallestThanTargetSolution();
        char[] ex1 = {'c', 'f', 'j'};
        char aTarget = 'k';
        char ans = classObj.nextGreatestLetter(ex1, aTarget);
        System.out.println(ans);
        
    }
}