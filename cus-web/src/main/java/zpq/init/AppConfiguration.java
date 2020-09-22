package zpq.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;
import zpq.service.impl.TestService;
import zpq.util.PropertiesLoader;

/**
 * @author zhangchaopei
 * @desc 应用配置类
 * @date 2020-9-11 16:34
 */
@Configuration
public class AppConfiguration {

    /**
     * @param
     * @return zpq.service.impl.TestService
     * @desc 测试非SpringBoot项目能否使用@Configuration与@Bean
     * @author zhangchaopei
     * @date 2020-9-11 16:47
     */
    @Bean
    public TestService initTestService() {
        TestService testService = new TestService();
        return testService;
    }



}
