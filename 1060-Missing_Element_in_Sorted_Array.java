class MissingElemSolution{

    public int missingElementOld(int[] nums, int k) {
        
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

    public int missingElement(int[] nums, int k) {
        
        for(int i = 0; i < nums.length - 1; i++){
            int between = nums[i + 1] - nums[i] - 1;
            
            if(between == 0){
                continue;
            }
            else{
                k = k - between;
            }
            if(k == 0){
                return nums[i] + between;
            }
            else if( k < 0){
                int ans = nums[i] + between + k;
                return ans;
            }
            
        }
        if(k > 0){
            return nums[nums.length - 1] + k;
        }
        return -1;
    }

    public static void main(String[] args){
        MissingElemSolution classObj = new MissingElemSolution();
        int[] ex1 = {4,7,9,10};
        int k1 = 1;
        int[] ex2 = {4, 7, 9, 10};
        int k2 = 3; 
        int[] ex3 = {1, 2, 4};
        int k3 = 3;
        System.out.println(classObj.missingElement(ex3, k3));
    }
}