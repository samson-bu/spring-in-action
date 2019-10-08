package data.access.orm.mybatis;

import data.access.DemoTest;
import data.access.config.ComponentConfig;
import data.access.dao.PeopleDao;
import data.access.entity.People;
import data.access.orm.mybatis.config.MybatisConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {MybatisConfig.class, ComponentConfig.class})
@ActiveProfiles(profiles = {"dev"})
public class MybatisTest extends DemoTest {

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
