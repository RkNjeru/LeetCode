class MergeSortArrSolution{

    public void merge(int[] nums1, int m, int[] nums2, int n){
        int[] tempNums1 = new int[m];
        for(int i = 0; i < m; i++){
            tempNums1[i] = nums1[i];
        }

        int nums1Index = 0;
        int nums2Index = 0;
        int tempNums1Index = 0;

        while(tempNums1Index < m || nums2Index < n){
            if(tempNums1Index == m){
                nums1[nums1Index] = nums2[nums2Index];
                nums2Index++;
                nums1Index++;
            }
            else if(nums2Index == n){
                nums1[nums1Index] = tempNums1[tempNums1Index];
                tempNums1Index++;
                nums1Index++;
            }
            else if(tempNums1[tempNums1Index] <= nums2[nums2Index]){
                nums1[nums1Index] = tempNums1[tempNums1Index];
                tempNums1Index++;
                nums1Index++;
            }
            else if(nums2[nums2Index] < tempNums1[tempNums1Index]){
                nums1[nums1Index] = nums2[nums2Index];
                nums2Index++;
                nums1Index++;
            }

        }
        
    }

    public static void main(String[] args){
        MergeSortArrSolution classObj = new MergeSortArrSolution();
        int[] aNums1 = {1, 2, 3, 0, 0, 0};
        int[] aNums2 = {2, 5, 6};
        int aM = 3;
        int aN = 3;
        
        classObj.merge(aNums1, aM, aNums2, aN);

    }
}