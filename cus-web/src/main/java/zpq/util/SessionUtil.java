package zpq.util;


/**
 * @author zhangchaopei
 * @desc Web的Session缓存, 不知如何实现
 * @date 2020-9-11 16:13
 */
public class SessionUtil<K, V> implements CacheUtil<K, V> {
    @Override
    public boolean exist(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void put(K key, V value) {
        // TODO Auto-generated method stub

    }

}
