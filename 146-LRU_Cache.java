import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }

    // add to front
    public void add(Node aNode){

        Node head_next = head.next;

        aNode.prev = head;
        head.next = aNode;
        aNode.next = head_next;
        head_next.prev = aNode;

    }

    // remove from end 
    public void remove(Node aNode){
        Node next_node = aNode.next;
        Node prev_node = aNode.prev;

        next_node.prev = prev_node;
        prev_node.next = next_node;
         

    }

    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> node_map;
    int cache_capacity; 

    public LRUCache(int capacity) {
        node_map = new HashMap<>(capacity);
        this.cache_capacity = capacity;
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {

        if(node_map.containsKey(key)){
            remove(node_map.get(key));
            add(node_map.get(key));
            return node_map.get(key).val;
        }
        else{
            return -1;
        }
           
    }
    
    public void put(int key, int value) {

        Node node = node_map.get(key);
        if(node != null){
            remove(node);
            node.val = value;
            add(node);
        }
        else{
            if(node_map.size() == cache_capacity){
                node_map.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node new_node = new Node();
            new_node.key = key;
            new_node.val = value;

            node_map.put(key, new_node);
            add(new_node);
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