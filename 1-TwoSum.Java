class TwoSumSolution{

    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> indexer = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            
            if(indexer.containsKey(complement)){
                return new int[] {i, indexer.get(complement)};
            }
            indexer.put(nums[i], i);
        }
        
        return new int[2];
        
    }

    public static void main(String[] args){
        TwoSumSolution classObj = new TwoSumSolution();
        int[] ex1 = {3,2,4};
        int ex = 6;
        System.out.println(classObj.twoSum(ex1, ex));

    }

}