class IslandSolution{
    public int numIslands(char[][] grid) {
        int mAns = 0;
        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    grid = ExhaustDir(i, j, grid);
                    mAns++;
                }
            }

        }
        
        return mAns;
    }

    public char[][] ExhaustDir(int anI, int aJ, char[][] aGrid){
        aGrid[anI][aJ] = 'l';
        
        // look left
        if(aJ - 1 >= 0 && aGrid[anI][aJ - 1] == '1'){
            aGrid = ExhaustDir(anI, aJ - 1, aGrid);
        }
        // look up
        if(anI - 1 >= 0 && aGrid[anI - 1][aJ] == '1'){
            aGrid = ExhaustDir(anI - 1, aJ, aGrid);
        }
        // look right
        if(aJ + 1 < aGrid[0].length && aGrid[anI][aJ + 1] == '1'){
            aGrid = ExhaustDir(anI, aJ + 1, aGrid);
        }
        // look down
        if(anI + 1 < aGrid.length && aGrid[anI + 1][aJ] == '1'){
            aGrid = ExhaustDir(anI + 1, aJ, aGrid);
        }

        return aGrid;
    }

    public static void main(String[] args){
        IslandSolution classObj = new IslandSolution();
        char[][] map = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        char[][] map2 = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        System.out.println(classObj.numIslands(map2));
    }
}