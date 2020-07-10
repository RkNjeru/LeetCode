class FindPeakElemSolution{

    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;

        if(nums == null || nums.length == 0){return -1;}

        if(nums.length == 1){return 0;}

        // always go w/ highest value 

        while(low <= high){
            mid = low + ( (high - low ) / 2);

            if(mid == 0 && nums[mid] > nums[mid + 1]){
                return mid;
            }
            else if(mid == 0){
                return mid + 1;
            }
            else if(mid == nums.length - 1 && nums[mid - 1] < nums[mid]){
                return mid;
            }
            else if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            else if(nums[mid  +1 ] > nums[mid - 1]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }

        }

        return -1;
        
    }

    public static void main(String[] args){
        FindPeakElemSolution classObj = new FindPeakElemSolution();
        int[] ex1 = {1,2,3,1};
        int[] ex2 = {1,2,1,3,5,6,4};
        int[] ex3 = {1,2};
        int[] ex4 = {3, 2, 1};
        System.out.println(classObj.findPeakElement(ex4));
    }
}