import java.util.Arrays;

class MaxSubArraySolution{
    public int maxSubArray(int[] nums){
        int largSum = nums[0];
        int testSum = nums[0];
        for(int i = 0; i < nums.length; i++){
            testSum = nums[i];
            
            for(int j = i + 1; j < nums.length; j++)
            {
                if(testSum > largSum){
                    largSum = testSum;
                }

                testSum += nums[j];
                
                if(testSum > largSum){
                    largSum = testSum;
                }
            }

            if(testSum > largSum){
                largSum = testSum;
            }

        }
        
        return largSum;
    }

    public static void main(String[] args){
        MaxSubArraySolution classObj = new MaxSubArraySolution();
        // int[] testArray = {-2,1,-3,4,-1,2,1,-5,4};
        int[] testArray = {-2, 1};
        System.out.println(classObj.maxSubArray(testArray));
    }
}