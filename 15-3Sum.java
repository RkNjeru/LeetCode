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
        
        for(int i = 0; i < nums.length; i++){
            int iVal = nums[i];

            if(iVal > 0) {break;}

            int low = i + 1;
            int high = nums.length - 1;

            while(low < high && (i == 0 || nums[i -1] != nums[i])){
                int curSum = iVal + nums[low] + nums[high];
                if(curSum < 0 || (low > i + 1 && nums[low] == nums[low - 1])){
                    low++;
                }
                else if(curSum > 0 || ((high < nums.length - 1) && nums[high] == nums[high + 1])){
                    high--;
                }
                else{
                    Integer[] temp = new Integer[] {iVal, nums[low], nums[high]};
                    List<Integer> tempList = Arrays.asList(temp);
                    mAns.add(tempList);
                    high--;
                    low++;
                }
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