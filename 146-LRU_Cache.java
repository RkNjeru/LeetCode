import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

class LRUCache {
    
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    // usage tracker
    private HashMap<Integer, Date> usage = new HashMap<Integer, Date>();

    private int mCapacity; 

    public LRUCache(int capacity) {
        mCapacity = capacity;        
    }

    public int get(int key) {
        if(map.containsKey(key)){

            // if(usage.containsKey(key)){
            //     usage.put(key, usage.get(key) + 1);
            // }
            // else{
            //     usage.put(key, 1);
            // }
            Date date = new Date();
            usage.put(key, date.);
            return map.get(key);
        }
        else{
            return -1;
        }
        // increment use
    }
    
    public void put(int key, int value) {
        int curCap = map.size(), leastKey = Integer.MAX_VALUE, leastValue = Integer.MAX_VALUE;
        // if at mCapacity, remove least recently used item
        if(curCap == mCapacity){
            for(Map.Entry<Integer, Integer> entry : usage.entrySet()){
                if(entry.getValue() < leastValue){
                    leastValue = entry.getValue();
                    leastKey = entry.getKey();
                }
            }
            map.remove(leastKey);
            usage.remove(leastKey);

            usage.put(key, 0);
            map.put(key, value);

        }
        else{
            usage.put(key, 0);
            map.put(key, value);
        }

        
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

    }
}