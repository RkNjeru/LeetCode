class FirstLastSoluiton{

    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1, med = 0;
        boolean found = false;

        while (low <= high){
            med = (low + high) / 2;
            if(nums[med] == target){
                low = med;
                high = med;
                found = true;
                break;
            }
            if(nums[med] < target){
                low = med + 1;
                continue;
            }
            if(nums[med] > target){
                high = med - 1;
                continue;
            }
        }
        if(!found){
            return new int[] {-1, -1};
        }

        // find Ubound
        while((high <= (nums.length - 2)) && (nums[high + 1] == target)){
            high++;
        }

        // find Lbound
        while(low > 0 && nums[low - 1] == target){
            low--;
        }

        
        return new int[] {low, high};
    }


    public static void main(String[] args){
        FirstLastSoluiton classObj = new FirstLastSoluiton();
        int[] ex1 = {5, 7, 7, 8, 8, 10};
        int[] ex2 = {2, 2};
        int aTar = 2;
        int[] ans = classObj.searchRange(ex2, aTar);
        System.out.println(ans);
    }
}