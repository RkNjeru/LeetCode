// import jdk.internal.util.xml.impl.Pair;
import javafx.util.Pair;

// The campaigns we show, user can like it or dislike it. 

// Like is considered a positive event and dislike is considered a negative event. 

// Let’s say, we have shown several campaigns to a user AAA and the below 
// table shows how he interacted with the campaigns over the last several months:
// start date and end date of when the user liked the campaigns the most

// string, integer
// DateId User Interaction
// 201910 -2
// 201911 1
// 201912 -3
// 202001 4
// 202002 -1
// 202003 2
// 202004 1
// 202005 -5
// 202006 4


// output: "202001 202004" 6
// 10, 10 11, 10 11 12, 10 11 12 01, 

class Solution{
    
    public String maxIntPeriod(Pair[] interactions){

        int maxPeriod = 0;
        String result = "";
        Pair<String, Integer> aResult = new Pair<>("", Integer.MIN_VALUE);
    
        for(int i = 0; i < interactions.length(); i++){
    
            Pair<String, Integer> ansPair = recInter(interactions, i, i, aResult);
            int ans = ansPair.getValueOf1();
            String ansResult = ansPair.getValueOf0();
    
            if(ans > maxPeriod){
                maxPeriod = ans;
                result = ansResult;
            }
    
        }
    
        System.out.println(result + maxPeriod);

        return result;
    
    }
    
    // 10, 10 11, 10 11 12, 10 11 12 01, 
    // DateId User Interaction
    // 201910 -2
    // 201911 1
    // 201912 -3
    // 202001 4
    // 202002 -1
    // 202003 2
    // 202004 1
    // 202005 -5
    // 202006 4
    
    public Pair<String, Integer> recInter(Pair[] interactions, int index, int endIndex, Pair<String, Integer> result){
        if(endIndex >= interactions.length()){
            return result;
        }
    
        int sum = 0;
    
        for(int i = index; i <= endIndex; i++){
            sum += interactions[endIndex].getValueOf1();
        }
    
        if(sum > result.getValueOf1()){
            result.getValueOf1 = sum;
            result.getValueOf1 = interactions[index].getValueOf0() + " " + interactions[endIndex].getValueOf0();
        }
        
        return recInter(interactions, index, index + 1, result);
    
    }
    
}

