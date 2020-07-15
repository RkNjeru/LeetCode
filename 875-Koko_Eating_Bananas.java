import java.math.BigInteger;
import java.util.Arrays;

class KokoSolution{
    public int minEatingSpeed(int[] piles, int H) {
        
        // non-optimal solution:

        // sort piles array

        Arrays.sort(piles);

        int sum = 0, rate, index = 0, curVal, hours = 0;
        boolean found = false;
        
        // find sum
        for(int num : piles){
            sum += num;
        }

        // find sum/hours
        // use average as starting point
        rate = sum % H == 0 ? sum / H : (sum / H) + 1;

        curVal = piles[index];

        // find first possible rate (will be minimum)
        while(!found){
            if(index == 0){hours = H;}

            // curVal = piles[index];

            curVal -= rate;
            hours--;

            if(index == piles.length - 1 && curVal <= 0){
                found = true;
                return rate;
            }
            else if(hours <= 0){
                rate += 1;
                index = 0;
            }
            else if(index == piles.length - 1 && hours >= 0){
                continue;
            }
            else if(curVal <= 0 && index < piles.length - 1){
                index++;
                curVal = piles[index];
            }
            else if(curVal > 0 && index < piles.length - 1){
                continue;
            }
            else{
                rate += 1;
                index = 0;
            }
        }


        return rate;
    }
    
    public static void main(String[] args){
        KokoSolution classObj = new KokoSolution();
        int[] ex1 = {3,6,7,11};
        int h1 = 8;
        int[] ex2 = {30,11,23,4,20};
        int h2 = 5;
        int[] ex3 = {30,11,23,4,20};
        int h3 = 6;
        int[] ex4 = {332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
        int h4 = 823855818;
        System.out.println(classObj.minEatingSpeed(ex4, h4));
    }
}