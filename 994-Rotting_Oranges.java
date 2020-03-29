import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/rotting-oranges/

class OrangesSolition{

    public int orangesRotting(int[][] grid){
        int minutes = 0;

        HashSet<String> fresh = new HashSet<String>();
        HashSet<String> rotten = new HashSet<String>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){ // fresh
                    fresh.add(i + "" + j);
                }
                else if(grid[i][j] == 2){
                    rotten.add(i + "" + j);
                }
            }
        }

        int[][] moves = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

        while (fresh.size() > 0){
            // iterate through rotten oranges and see if 
            // we can infect an existing fresh orange
            HashSet<String> infected = new HashSet<String>();
            for(String rIndex : rotten){
                int iPos = rIndex.charAt(0) - '0';
                int jPos = rIndex.charAt(1) - '0';
                for(int[] move : moves){
                    int iMove = move[0];
                    int jMove = move[1];

                    int iCheck = iPos + iMove;
                    int jCheck = jPos + jMove;

                    if(fresh.contains(iCheck + "" + jCheck)){
                        fresh.remove(iCheck + "" + jCheck);
                        infected.add(iCheck + "" + jCheck);
                    }
    
                }
            }

            if(infected.size() == 0){ return -1;}
            
            minutes++;
            rotten = infected;
        }

        
        return minutes;
    }

    public static void main(String[] args){
        OrangesSolition classObj = new OrangesSolition();
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int ans = classObj.orangesRotting(grid);
        System.out.println(ans);
        

    }
}