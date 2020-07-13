import java.util.Arrays;

class FindRIntervalSolution {

    public int[] findRightInterval(int[][] intervals) {

        if(intervals == null || intervals.length < 2){return new int[] {-1};}
        
        int[][] startSort = new int[intervals.length][2];
        int low = 0, high = startSort.length - 1, mid = 0, found = -1;

        int[] ans = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++){
            startSort[i][0] = intervals[i][0];
            startSort[i][1] = i;
        }

        Arrays.sort(startSort, (a, b) -> Integer.compare(a[0], b[0]));

        // Now the problem reduces to finding the least element which is 
        // greater than or equal to the ending point of each interval of 
        // the original array(which can be found using binary search).

        // for each int[] end, find smallest greater start

        // binary search through startSort 

        for(int i = 0; i < intervals.length; i++){
            int aEnd = intervals[i][1];
            int largerStart = -1;
            found = -1;
            low = 0;
            high = startSort.length - 1;
            
            while(low <= high){
                mid = low + ((high - low) / 2);

                if((largerStart == -1 && startSort[mid][0] >= aEnd) || (startSort[mid][0] >= aEnd && startSort[mid][0] < startSort[found][0])){
                    found = mid;
                    largerStart = startSort[mid][1];
                }
                
                if(startSort[mid][0] > aEnd){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }

            }

            ans[i] = largerStart;
        }
        
        
        return ans;
    }


    public static void main(String[] args){
        FindRIntervalSolution classObj = new FindRIntervalSolution();
        int[][] ex1 = {{1, 2}};
        int[][] ex2 = {{1, 4}, {2, 3}, {3, 4}};
        int[][] ex3 = {{3, 4}, {2, 3}, {1, 2}};
        int[][] ex4 = {{1, 2}, {2, 3}, {0, 1}, {3, 4}};
        int[][] ex5 = {{3, 4}, {2, 3}, {1, 2}};
        int[][] ex6 = {{1, 12}, {2, 9}, {3, 10}, {13, 14}, {15, 16}, {16, 17}};

        int[] result = classObj.findRightInterval(ex6);

        for(int aNum : result){
            System.out.print(aNum + " ");
        }

        System.out.println();
    }
}