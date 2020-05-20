package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents LRU cache with fixed maximum capacity.
 * <p>
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 * <p>
 * This class should not have any other public methods.
 * <p>
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V>  extends LinkedHashMap<K, V> {

    private int capacity;

    public LruCache(int capacity) {
        super(capacity, 1f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    //там баги с тестом, лектор сказал сделать так, чтобы все было ок
    @Override
    public V get(Object key) {
        return super.get(key);
    }

    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }

    public int elements() {
        return size();
    }
}

//нормальный вариант (без этого странного дополнительного задания)
//public class LruCache<K, V> {
//
//    private final Map<K, V> map;
//    private final int capacity;
//
//    public LruCache(int capacity) {
//        map = new LinkedHashMap<>(capacity, 1f, true);
//        this.capacity = capacity;
//    }
//
//    public V get(K key) {
//        return map.get(key);
//    }
//
//    public void put(K key, V value) {
//        if (map.size() == capacity) {
//            map.remove(map.keySet().iterator().next());
//        }
//        map.put(key, value);
//    }
//
//    public int elements() {
//        return map.size();
//    }
//}