class FirstBadSolution{

    public int firstBadVersion(int n) {
        int low = 1, high = n, med = 0;

        while(low < high){
            med = low + (high - low) / 2;

            if(isBadVersion(med)){
                high = med;
            }
            else{
                low = med + 1;
            }
        }

        return low;
    }

    public boolean isBadVersion(int aArg){
        return false;
    }

    public static void main(String[] args){
        FirstBadSolution classObj = new FirstBadSolution();
        
    }
}