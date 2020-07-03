class SearchRotatedArraySolution{

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = 0;

        // explanation: https://www.youtube.com/watch?v=QdVrY3stDD4
        
        // 1. find pivot (smallest element)

        // 2. determine which side of pivot target exists

        // 3. binary search on know correct portion of array

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