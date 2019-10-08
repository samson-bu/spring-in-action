package data.access.jdbc.config;

import data.access.config.PersistenceConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig extends PersistenceConfig {

    @Bean
    public JdbcTemplate createJdbcTemplate(@Param("dataSource")DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
