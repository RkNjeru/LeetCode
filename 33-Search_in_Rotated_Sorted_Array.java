class SearchRotatedArraySolution{

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = 0, pivot = 0;

        if(nums == null || nums.length == 0){
            return -1;
        }

        // explanation: https://www.youtube.com/watch?v=QdVrY3stDD4
        
        // 1. find pivot (smallest element)
        while(low < high){
            mid = low + ((high - low) / 2);
            if(nums[mid] > nums[high]){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }

        pivot = low;
        // System.out.println(pivot);
        low = 0;
        high = nums.length - 1;
        

        // 2. determine which side of pivot target exists

        if(nums[pivot] <= target && nums[high] >= target){
            low = pivot;
        }
        else{
            high = pivot - 1;
        }

        // 3. binary search on know correct portion of array

        while(low <= high){
            mid = low + ((high - low) / 2);
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
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

        int[] ex4 = {5, 1, 2, 3, 4};
        int tar4 = 1;
        System.out.println(classObj.search(ex4, tar4));
    }
}