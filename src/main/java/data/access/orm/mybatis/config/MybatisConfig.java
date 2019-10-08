package data.access.orm.mybatis.config;

import data.access.config.PersistenceConfig;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"data.access.orm.mybatis.mapper"})
public class MybatisConfig extends PersistenceConfig {

    @Bean
    public SqlSessionFactory sessionFactory(@Param("dataSource")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        factoryBean.setMapperLocations(resolver.getResources("classpath*:data/access/orm/mybatis/*Mapper.xml"));
        factoryBean.setDataSource(dataSource);

        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sessionTemplate(@Param("sessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
