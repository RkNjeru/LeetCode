class MinRotatSortArray{

    public int findMin(int[] nums) {
        int low = 0, high = nums.length -1, mid = 0;

        if(nums == null || nums.length == 0){return -1;}

        while(low <= high){
            mid = low + ((high - low) / 2);
            if(low == high){
                return nums[mid];
            }

            if(nums[mid] > nums[high]){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        MinRotatSortArray classObj = new MinRotatSortArray();
        int[] ex1 = {3,4,5,1,2};
        int[] ex2 = {4,5,6,7,0,1,2};
        System.out.println(classObj.findMin(ex2));

    }
}