import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/reorder-data-in-log-files/

class LogSolution{
    public String[] reorderLogFiles(String[] logs){

        String digRegex = "[0-9]+";
        List<String> digLogs = new ArrayList<String>();

        List<String> letSortVals = new ArrayList<String>();
        HashMap<String, String> letterMap = new HashMap<String, String>();

        for(String log : logs){
            // parse into array
            String[] logVals = log.split(" ", -1);
            
            // identify if is digit or letter
            if(logVals[1].matches(digRegex)){ // these are numbers
                digLogs.add(log);
            }
            else{
                String logSortFormat = logVals[1];
                if(logVals.length > 2){
                    for(int i = 2; i < logVals.length; i++){
                        logSortFormat += " " + logVals[i];
                    }
                }
                logSortFormat += " " + logVals[0];
                
                letterMap.put(logSortFormat, log);
                letSortVals.add(logSortFormat);
            }
            
        }

        // sort
        Collections.sort(letSortVals);
        List<String> sortedLets = new ArrayList<String>();

        for(String letVal : letSortVals){
            sortedLets.add(letterMap.get(letVal));
        }
        
        sortedLets.addAll(digLogs);

        logs = sortedLets.toArray(new String[0]);

        for(String log : logs){
            System.out.println(log);
        }
        
        return logs;

    }

    public static void main(String[] args){
        LogSolution classObj = new LogSolution();
        String[] someLogs = {"j mo", "5 m w", "g 07", "o 2 0", "t q h"};

        String[] sol = classObj.reorderLogFiles(someLogs);
    }
}