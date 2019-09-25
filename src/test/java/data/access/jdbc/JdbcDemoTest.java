package data.access.jdbc;

import data.access.DemoTest;
import data.access.entity.People;
import data.access.jdbc.config.JdbcConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import java.sql.ResultSet;
import java.sql.SQLException;

@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcDemoTest extends DemoTest {
    @Autowired
    private JdbcOperations jdbcOperations;

    @Test
    public void contextLoads() {
        People p = jdbcOperations.queryForObject("select * from test_table where id ='1';", new RowMapper<People>() {
            @Override
            public People mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new People(rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("age"));
            }
        });

        Assert.assertEquals("People(id=1, name=zhangsa, age=28)", p.toString());
    }
}
