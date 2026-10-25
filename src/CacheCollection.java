import java.util.LinkedHashMap;
import java.util.Map;

public class CacheCollection {
    public static void main(String[] args) {

        CacheCollections<Integer, String> cache = new CacheCollections<>(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        System.out.println(cache);

        cache.get(1);
        cache.get(3);
        cache.put(4, "four");

        cache.entrySet().forEach(System.out::println);

    }


}




class CacheCollections<K, V> extends LinkedHashMap<K, V> {

    int capacity;
    CacheCollections(int capacity){
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

}


