package data.access.dao;

import data.access.entity.People;
import data.access.orm.mybatis.mapper.PeopleMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PeopleDao {
    @Autowired
    private SqlSession session;

    public People getPeople(String strId) {

        PeopleMapper mapper = session.getMapper(PeopleMapper.class);

        return mapper.getPeople(strId);
    }

    public People getPeople2(String strId) {
        People p = session.selectOne("data.access.orm.mybatis.mapper.PeopleMapper.getPeople", strId);
        return p;
    }
}
