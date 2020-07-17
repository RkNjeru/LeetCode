import java.util.Arrays;

class KokoSolution{
    public int minEatingSpeed(int[] piles, int H) {

        Arrays.sort(piles);

        int[] kSearch = new int[piles[piles.length - 1]];

        for(int i = 0; i < kSearch.length; i++){
            kSearch[i] = i + 1;
        }

        int low = 0, high = kSearch.length - 1, mid = 0, pilesIndex = 0, hours = 0, curVal = 0;

        while(low <= high){
            // try the current k (mid) (rate)
            mid = kSearch[low + ((high - low) / 2)];
            hours = H;
            pilesIndex = 0;
            curVal = piles[pilesIndex];

            while(pilesIndex < piles.length){
                hours--;
                curVal -= mid;

                if(pilesIndex == piles.length - 1 && curVal < 1){
                    pilesIndex++;
                    high = mid;
                }
                else if(hours < 1){
                    low = mid + 1;
                    break;
                }
                else if(pilesIndex == piles.length - 1){
                    continue;
                }
                else if(curVal < 1){
                    pilesIndex++;
                    curVal = piles[pilesIndex];
                }
                else{
                    continue;
                }
            }

            if(hours > 0){
                high = mid - 1;
            }
            else if(curVal == 0){
                return mid;
            }
            else if (curVal > 0 ){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }

        }

        return mid;
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
        System.out.println(classObj.minEatingSpeed(ex1, h1));
    }
}