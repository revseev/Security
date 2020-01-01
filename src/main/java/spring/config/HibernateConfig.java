package spring.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import spring.dao.UserDaoHibernate;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:config.properties"})
@ComponentScan({"spring"})
public class HibernateConfig {

    @Autowired
    private DataSource dataSource;

/*    @Autowired
    private Environment env;*/

    //Hibernate configuration
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
/*        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        Properties props = new Properties();
        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

        sessionFactory.setHibernateProperties(props);
        sessionFactory.setAnnotatedClasses(User.class);*/
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan(new String[] { "spring.model" });
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

    @Bean
    public UserDaoHibernate userDao() {
        return new UserDaoHibernate();
    }
}
