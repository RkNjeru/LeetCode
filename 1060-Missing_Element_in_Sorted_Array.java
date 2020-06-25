class MissingElemSolution{

    public int missingElement(int[] nums, int k) {
        
        int arrayIndex = 0, curNumber = 0;
        int logicalCounter = nums[0];
        
        while(k > 0){
            curNumber = arrayIndex < nums.length ? nums[arrayIndex] : -1;

            if(curNumber != logicalCounter){
                k--;
                logicalCounter++;
            }
            else{
                logicalCounter++;
                arrayIndex++;
            }

        }

        return logicalCounter - 1;
    }

    public static void main(String[] args){
        MissingElemSolution classObj = new MissingElemSolution();
        int[] ex1 = {4,7,9,10};
        int k1 = 1;
        int[] ex2 = {4, 7, 9, 10};
        int k2 = 3; 
        int[] ex3 = {1, 2, 4};
        int k3 = 3;
        System.out.println(classObj.missingElement(ex1, k1));
    }
}