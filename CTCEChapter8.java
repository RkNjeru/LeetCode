class CTCEChapter8Solution{

    // a magic index is an array A[1, ...n-1] st A[i] == i
    // given a sorted array of distinct integers, write a method
    // to find a magic index, if one exists, in array A
    public int magicIndex(int[] mArray){
        int low = 0, high = mArray.length - 1, mid = 0, midVal = 0;

        while(low <= high){
            mid = (low + high) / 2;
            midVal = mArray[mid];
            if(midVal > mid){
                high = mid + 1;
            }
            else if (midVal < mid){
                low = mid - 1;
            }
            else{
                return mid;
            }
            
        }
        return -1;
    }

    public static void main(String[] args){
        CTCEChapter8Solution classObj = new CTCEChapter8Solution();
        int[] ex1 = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        System.out.println(classObj.magicIndex(ex1));
    }
}