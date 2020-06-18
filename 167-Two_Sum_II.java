class TwoSumIISolution{
    
    public int[] twoSum(int[] numbers, int target){
        int low = 0;
        int high = numbers.length - 1;

        while(low < high){
            int curSum = numbers[low] + numbers[high];
            if(curSum < target){
                low++;
            }
            else if (curSum > target){
                high--;
            }
            else{
                return new int[] {low + 1, high + 1};
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args){
        TwoSumIISolution classObj = new TwoSumIISolution();
        int[] aNumbers = {2,7,11,15};
        int aTarget = 9;
        classObj.twoSum(aNumbers, aTarget);
    }
}