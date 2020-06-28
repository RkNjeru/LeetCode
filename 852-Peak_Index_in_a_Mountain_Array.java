class MountainPeakSolution{

    public int peakIndexInMountainArray(int[] A) {
    
        int low = 0, high = A.length, med = (low + high) / 2;
        
        while(low < high){
            med = (low + high) / 2;

            if(A[med - 1] < A[med] && A[med] > A[med + 1]){
                return med;
            }
            else if(A[med - 1] < A[med]){
                low = med;
            }
            else if(A[med] > A[med + 1]){
                high = med;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        MountainPeakSolution classObj = new MountainPeakSolution();
        int[] ex1 = {0, 1, 0};
        int[] ex2 = {0, 2, 1, 0};
        int[] ex3 = {0, 1, 5, 7, 8, 6, 3};
        int ans = classObj.peakIndexInMountainArray(ex2);
        System.out.println(ans);

    }
}