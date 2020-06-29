class HIndexIISolution{
    public int hIndex(int[] citations){

        int n = citations.length;
        int low = 0, high = n - 1, mid = 0;

        while(low <= high){
            mid = low + (high - low) / 2;
            if(citations[mid] < n - mid){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
    
        return n - low;
    }
    public static void main(String[] args){
        HIndexIISolution classObj = new HIndexIISolution();
        int[] ex1 = {0, 1, 3, 5, 6};
        int[] ex2 = {0};
        int[] ex3 = {0, 1, 4, 5, 6, 10, 11};
        int ans = classObj.hIndex(ex3);
        System.out.println(ans);
    }
}