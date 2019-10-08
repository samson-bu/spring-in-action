package data.access.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Profile("dev")
    @Bean
    public DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:data/access/schema.sql")
                .addScript("classpath:data/access/data.sql")
                .build();
    }

    @Profile("qa")
    @Bean
    public DataSource jdbcDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/data_access?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("mysql123#");

        return dataSource;
    }

    @Profile("prod")
    @Bean
    public DataSource poolDataSource() {
        // TODO: 需深入学习
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/data_access?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("mysql123#");
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(10);

        return dataSource;
    }

    @Profile("prod")
    @Bean
    @Primary
    public DataSource jndiDataSource() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        // TODO: 补充jndi

        return (DataSource) jndiObjectFactoryBean.getObject();
    }

}
