package zpq.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * @author zhangchaopei
 * @return
 * @desc Redis缓存
 * @date 2020-9-11 16:30
 */
@Component("redisUtil")
public class RedisUtil<K, V> implements CacheUtil<K, V> {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean exist(K key) {
        if (key != null)
            return stringRedisTemplate.opsForValue().get(String.valueOf(key)) != null;
        return false;
    }

    @Override
    public V get(K key) {
        String res = stringRedisTemplate.opsForValue().get(String.valueOf(key));
        return res != null ? (V) res : null;
    }


    @Override
    public void put(K key, V value) {
        stringRedisTemplate.opsForValue().set(String.valueOf(key), String.valueOf(value));
    }

}
