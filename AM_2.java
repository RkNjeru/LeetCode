import java.util.HashMap;
import java.util.List;
class PrimeAirSolution{

    public static class PairInt{
        int first, second;
        PairInt(){

        }
        PairInt(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    List<PairInt> optimalUtilization(int maxTravelDist, List<PairInt> forwardRouteList, 
                                                        List<PairInt> returnRouteList)
    {
        List<PairInt> ans = new List<PairInt>();
        HashMap<String, Integer> routeDist = new HashMap<String, Integer>();


        return ans;
    }

    public static void main(String[] args){
        PrimeAirSolution classObj = new PrimeAirSolution();
        String vals = "01";
        int aNum = vals.charAt(0) - '0';
        System.out.println(aNum);
    }
}