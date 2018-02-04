import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {

    private int maxCapacity = 10;
    private LinkedList<Integer> keys = new LinkedList<Integer>();
    private Map<Integer, Integer> cache = null;
    private int currentCapacity =  0;
    public static void main(String[] args) {
       LRUCache cache = new LRUCache(5);
       
       cache.set(1,1);
       cache.set(2,1);
       cache.set(3,1);
       cache.set(4,1);
       cache.set(5,1);
       cache.inspect();
       cache.set(1,2);
       cache.inspect();
       cache.set(2,2);
       cache.inspect();
       cache.set(1,1);
       cache.inspect();
       cache.set(1,1);
       cache.inspect();
       cache.set(6,1);
       cache.inspect();
       cache.set(1,1);
       cache.inspect();
    }

    
    public LRUCache(int maxCapacity) {
    
        this.maxCapacity = maxCapacity;
        this.cache = new HashMap<>(maxCapacity);
    }

    public int get(int key) {
        Integer value = cache.get(Integer.valueOf(key));
        if (value == null) {
            return -1;
        }else {
            keys.remove(Integer.valueOf(key));
            keys.add(key);
            return value.intValue();
        }
    }

    /**
     * if the key exists in the cache. we just need to update the key position and override existing cache value.
     * if the key doesn't exist
     *    if the cache still have space, meaning it is not exceed its capacity, we can just insert at the end.
     *    if the cache is full, we need to remove the LRU cache and its keys. THe first elements in the key is the LRU.
     */
    public void set(int key, int value) {

        //if the key exists. we just need to update the keys and set the value.
        Integer existingValue = cache.get(Integer.valueOf(key));
        if (existingValue == null) {
            if (currentCapacity < maxCapacity) {
                keys.add(key);
                currentCapacity++;
            }else {
                // remove the last one and insert
                Integer lruKey = keys.removeFirst();
                cache.remove(lruKey);
                keys.add(key);
            }
        }else {
            keys.remove(Integer.valueOf(key));
            keys.add(Integer.valueOf(key));
        }
        cache.put(Integer.valueOf(key), Integer.valueOf(value));
    }

    public void inspect() {
        System.out.print(" keys : ");
        keys.forEach(System.out::print);
        System.out.println();
    }

}