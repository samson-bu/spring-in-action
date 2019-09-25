package data.access.jdbc.config;

import data.access.config.BaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@Import(BaseConfig.class)
public class JdbcConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcTemplate createJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }
}
