package zpq.init;

import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;

/**
 * Hibernate配置
 *
 * @author zhangchaopei
 * @version 1.0
 * @date 2020-9-16 16:35
 */
@Configuration
public class HibernateConfig {
    public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource) {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
//        localSessionFactoryBean.setMappingResources("customer.hbm.xml");
        return localSessionFactoryBean;
    }
}
