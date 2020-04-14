import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class MergeFIleSolution{

    public int minimumTime(int numOfSubFiles, List<Integer> fileSizes){

        int minTime = 0;

        Collections.sort(fileSizes);

        while(fileSizes.size() > 0){
            if(fileSizes.size() == 1){
                minTime += fileSizes.get(0);
                fileSizes.remove(0);
                return minTime;
            }
            else{
                int val1 = fileSizes.get(0);
                int val2 = fileSizes.get(1);
                minTime += val1 + val2;
                fileSizes.remove(0);
                fileSizes.remove(0);
                if(fileSizes.size() == 0){return minTime;}
                fileSizes.add(val1 + val2);
                Collections.sort(fileSizes);
            }

        }



        return minTime;
    }

    public static void main(String[] args){
        MergeFIleSolution classObj = new MergeFIleSolution();
        int testNum = 4;
        ArrayList<Integer> testList = new ArrayList<Integer>();
        testList.add(20);
        testList.add(4);
        testList.add(8);
        testList.add(2);
        System.out.println(classObj.minimumTime(testNum, testList));

    }
}