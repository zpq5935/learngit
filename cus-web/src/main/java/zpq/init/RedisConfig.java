package zpq.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;
import zpq.util.PropertiesLoader;

/**
 * TODO
 *
 * @author zhangchaopei
 * @version 1.0
 * @date 2020-9-16 16:34
 */
@Configuration
public class RedisConfig {

    private PropertiesLoader propertiesLoader = new PropertiesLoader("db.properties", "redis.properties");

    /**
     * @return redis.clients.jedis.JedisPoolConfig
     * @desc Redis连接池
     * @author zhangchaopei
     * @date 2020-9-11 16:35
     */
    @Bean
    public JedisPoolConfig initJedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.maxIdle = propertiesLoader.getInteger("redis.maxIdle");
        jedisPoolConfig.maxActive = propertiesLoader.getInteger("redis.maxActive");
        jedisPoolConfig.maxWait = propertiesLoader.getInteger("redis.maxWait");
        jedisPoolConfig.testOnBorrow = propertiesLoader.getBoolean("redis.testOnBorrow");
        return jedisPoolConfig;
    }

    /**
     * @param poolConfig
     * @return org.springframework.data.redis.connection.jedis.JedisConnectionFactory
     * @desc Redis连接工厂
     * @author zhangchaopei
     * @date 2020-9-11 17:00
     */
    @Bean
    public JedisConnectionFactory initJedisConnectionFactory(JedisPoolConfig poolConfig) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(propertiesLoader.getProperty("redis.host"));
        jedisConnectionFactory.setPort(propertiesLoader.getInteger("redis.port"));
        jedisConnectionFactory.setPassword(propertiesLoader.getProperty("redis.pass"));
        jedisConnectionFactory.setPoolConfig(poolConfig);
        return jedisConnectionFactory;
    }

    /**
     * @param jedisConnectionFactory
     * @return org.springframework.data.redis.core.StringRedisTemplate
     * @desc Redis模板
     * @author zhangchaopei
     * @date 2020-9-11 17:01
     */
    @Bean
    public StringRedisTemplate initStringRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory);
        stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
        stringRedisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        return stringRedisTemplate;
    }
}
