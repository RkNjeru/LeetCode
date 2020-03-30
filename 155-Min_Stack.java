import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

// https://leetcode.com/problems/min-stack/

class MinStackSolution{

    public static class MinStack{
        /** initialize your data structure here. */

        private int stackCount = 0;

        private HashMap<Integer, Integer> theStack = new HashMap<Integer, Integer>();

        private ArrayList<Integer> sortedValues = new ArrayList<Integer>();

        private int minVal = Integer.MAX_VALUE;

        private int minValIndex = 0;

        public MinStack() {
            
        }
        
        public void push(int x) {
            stackCount++;
            theStack.put(stackCount, x);
            // if(x < minVal){
            //     minVal = x;
            //     minValIndex = stackCount;
            // }

            sortedValues.add(x);
            Collections.sort(sortedValues);

        }
        
        public void pop() {
            int goneVal = theStack.remove(stackCount);
            if(goneVal == sortedValues.get(0)) {
                sortedValues.remove(0);
            }
            stackCount--;
        }
        
        public int top() {
            return theStack.get(stackCount);
        }
        
        public int getMin() {
            return sortedValues.get(0);
        }
    }
    

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   // Returns -3.
        minStack.pop();
        minStack.top();      // Returns 0.
        minStack.getMin();   // Returns -2.
    }
}