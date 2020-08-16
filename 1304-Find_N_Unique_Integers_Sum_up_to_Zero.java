class Solution {
    public int[] sumZero(int n) {
        
        // beg w/ index
        // fill in index and opposite side of array with -1* value
        
        boolean even = (n % 2) == 0;
        int[] result = new int[n];
        int mid = n / 2;
        
        for(int i = 0; i < mid; i++){
            result[i] = i + 1;
            result[n - 1 - i] = result[i] * -1;
        }
        
        return result;
        
    }
}