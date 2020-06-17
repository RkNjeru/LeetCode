import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/3sum/
class ThreeSumSolution{
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);

        List<List<Integer>> mAns = new ArrayList<>();
        HashSet<String> found = new HashSet<String>();
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            numMap.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            int iVal = nums[i];

            if(iVal > 0){
                return mAns;
            }

            for(int j = nums.length - 1; j > i + 1; j--){
                int jVal = nums[j];
                int complement = (iVal + jVal) * -1;

                if(numMap.containsKey(complement) && numMap.get(complement) != i && numMap.get(complement) != j){
                    if(found.add(Integer.toString(iVal) + Integer.toString(jVal) + Integer.toString(complement))){
                        Integer[] temp = new Integer[] {iVal, jVal, complement};
                        List<Integer> tempList = Arrays.asList(temp);
                        mAns.add(tempList);
                    }
                }

                // if(iVal + jVal + jVal < 0) { 
                //     continue;
                // }

                // for(int k = j - 1; k > i; k--){
                //     int kVal = nums[k];
                    
                //     if( (iVal + jVal + kVal) == 0){
                //         // StringBuilder tempStr = new StringBuilder();
                //         // String theStr = Integer.toString(iVal) + Integer.toString(jVal) + Integer.toString(kVal);
                        
                //         // if(!found.contains(theStr)){
                //         //     found.add(theStr);
                //         //     Integer[] temp = new Integer[] {iVal, jVal, kVal};
                //         //     List<Integer> tempList = Arrays.asList(temp);
                //         //     mAns.add(tempList);
                //         // }
                //         if(found.add(Integer.toString(iVal) + Integer.toString(jVal) + Integer.toString(kVal))){
                //             Integer[] temp = new Integer[] {iVal, jVal, kVal};
                //             List<Integer> tempList = Arrays.asList(temp);
                //             mAns.add(tempList);
                //         }

                //     }

                // }
            }
        }
        return mAns;
    }

    public static void main(String[] args){
        ThreeSumSolution classObj = new ThreeSumSolution();
        int[] test2 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = classObj.threeSum(test2);
    }
}