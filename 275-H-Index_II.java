class HIndexIISolution{
    public int hIndex(int[] citations){

        int low = 0, high = citations.length - 1, med = 0;
        int nMore, hTemp = 0, nLess;

        while(low < high){
            med = (low + high) / 2;
            nMore = citations.length - med;
            if(citations[med] == nMore){
                return citations[med];
            }
            else if(citations[med] > nMore){
                high = med - 1;
            }
            else if(citations[med] < nMore){
                low = med - 1;
            }
        }
    
        return citations.length;
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