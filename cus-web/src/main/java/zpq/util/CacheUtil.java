package zpq.util;

public interface CacheUtil<K, V> {
    boolean exist(K key);

    V get(K key);

    void put(K key, V value);
}
