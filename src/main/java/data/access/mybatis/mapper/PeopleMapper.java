package data.access.mybatis.mapper;

import data.access.entity.People;
import org.apache.ibatis.annotations.Select;

public interface PeopleMapper {
//    @Select("select * from test_table where id = #{strId}")
    People getPeople(String strId);
}
