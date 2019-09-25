package data.access.mybatis;

import data.access.DemoTest;
import data.access.entity.People;
import data.access.mybatis.config.MyBatisConfig;
import data.access.mybatis.dao.PeopleDao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {MyBatisConfig.class})
public class MyBatisDemoTest extends DemoTest {
    @Autowired
    private PeopleDao peopleDao;

    @Test
    public void getPeople() {
        People p = peopleDao.getPeople("1");
        People p2 = peopleDao.getPeople2("1");

        Assert.assertEquals("People(id=1, name=zhangsa, age=28)", p.toString());

        Assert.assertEquals(p.toString(), p2.toString());

    }
}
