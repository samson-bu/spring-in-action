package data.access.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfig extends DataSourceConfig{

    @Autowired
    private DataSource dataSource;
}
