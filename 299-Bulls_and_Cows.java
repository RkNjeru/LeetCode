import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/bulls-and-cows/
class BullsCowsSolution{

    public String getHint(String secret, String guess) {
        String ans = "val";
        String jVal;
        int mBulls = 0, mCows = 0;
        
        HashMap<Integer, String> secretMap = new HashMap<>();
        HashMap<Integer, String> cowMap = new HashMap<>();

        for(int i = 0; i < secret.length(); i ++){
            secretMap.put(i, secret.substring(i, i+1));
        } 

        for(int j = 0; j < guess.length(); j++){
            jVal = guess.substring(j, j+1);
            // if correct value and position
            if(secretMap.containsKey(j) && secretMap.get(j).equals(jVal)){
                mBulls++;
                secretMap.remove(j);
                if(cowMap.containsKey(j)){
                    mCows--;
                    cowMap.remove(j);
                }
            }
            else if(cowMap.containsKey(j) && cowMap.get(j).equals(jVal)){
                mBulls++;
                mCows--;
                cowMap.remove(j);
                //secretMap.remove(j);
            }
            else{
                // elseif correct value bad position 
                for (Map.Entry<Integer, String> entry : secretMap.entrySet()) {
                    if (entry.getValue().equals(jVal) && !cowMap.containsKey(j) ) {
                        mCows++;
                        cowMap.put(entry.getKey(), jVal);
                        //secretMap.remove(entry.getKey());
                        continue;
                    }
                    else if (entry.getValue().equals(jVal)) {
                        cowMap.put(entry.getKey(), jVal);
                        // mCows++;
                        secretMap.remove(entry.getKey());
                        break;
                    }
                }
                // else neither
            }
            
        }

        return mBulls + "A" + mCows + "B";
    }

    public static void main(String[] args){
        BullsCowsSolution classObj = new BullsCowsSolution();
        String aSecret = "011", aGuess = "110";
        System.out.println(classObj.getHint(aSecret, aGuess));
    }
}