class SearchRotatedArraySolution{

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = 0;

        while(low <= high){
            mid = low + ((high - low) / 2);
            if(nums[mid] == target){
                return mid;
            }

            if(target > nums[mid] && target <= nums[high]){
                low = mid + 1;
            }
            else if(target >= nums[low] && target < nums[mid]){
                high = mid - 1;
            }
            // sus
            else if(target <= nums[high]){
                low = mid + 1;
            }
            else if(target >= nums[low]){
                high = mid - 1;
            }
            else{
                return -1;
            }

        }

        return -1;
    }
    
    public static void main(String[] args){
        SearchRotatedArraySolution classObj = new SearchRotatedArraySolution();
        int[] ex1 = {5, 6, 7, 8, 0, 1, 2, 3, 4};
        int tar1 = 7;
        int[] ex2 = {4, 5, 6, 7, 0, 1, 2};
        int tar2 = 3;

        int[] ex3 = {4, 5, 6, 7, 8, 1, 2, 3};
        int tar3 = 8;
        System.out.println(classObj.search(ex3, tar3));
    }
}