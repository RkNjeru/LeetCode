import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/bulls-and-cows/
class BullsCowsSolution{

    public String getHintOld(String secret, String guess) {
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

    public String getHint(String secret, String guess) {
        HashMap < Character, Integer > a = new HashMap < Character, Integer > ();
        HashMap < Character, Integer > b = new HashMap < Character, Integer > ();
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (a.containsKey(secret.charAt(i))) {
                    int temp = a.get(secret.charAt(i));
                    temp++;
                    a.put(secret.charAt(i), temp);
                } else if (a.containsKey(secret.charAt(i)) == false) {
                    a.put(secret.charAt(i), 1);
                }
                if (b.containsKey(guess.charAt(i))) {
                    int temp = b.get(guess.charAt(i));
                    temp++;
                    b.put(guess.charAt(i), temp);
                } else if (b.containsKey(guess.charAt(i)) == false) {
                    b.put(guess.charAt(i), 1);
                }
            }
        }
        Set < Character > e = b.keySet();
        int cows = 0;
        for (char i: e) {
            if (a.containsKey(i)) {
                int tg = a.get(i);
                int mg = b.get(i);
                if (tg > mg) {
                    cows = cows + mg;
                } else {
                    cows = cows + tg;
                }
            }
        }
        return Integer.toString(bulls) + 'A' + Integer.toString(cows) + 'B';
    }

    public static void main(String[] args){
        BullsCowsSolution classObj = new BullsCowsSolution();
        String aSecret = "011", aGuess = "110";
        System.out.println(classObj.getHint(aSecret, aGuess));
    }
}