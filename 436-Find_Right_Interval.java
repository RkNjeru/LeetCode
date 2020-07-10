class FindRIntervalSolution{

    public int[] findRightInterval(int[][] intervals) {
        
        if(intervals == null || intervals.length <= 1){
            return new int[] {-1};
        }

        int[] ans = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++){
            boolean found = false;

            for(int j = 0; j < intervals.length; j++){
                if(j == i){continue;}

                int iRight = intervals[i][1];
                int jLeft = intervals[j][0];

                if(jLeft >= iRight && (!found || (found && jLeft < intervals[ans[i]][0]))){
                    found = true;
                    ans[i] = j;
                }
            }

            if(!found){
                ans[i] = -1;
            }

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

        int[] result = classObj.findRightInterval(ex4);

        for(int aNum : result){
            System.out.print(aNum + " ");
        }

        System.out.println();
    }
}