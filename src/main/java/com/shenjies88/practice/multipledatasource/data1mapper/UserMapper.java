package com.shenjies88.practice.multipledatasource.data1mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author shenjies88
 * @since 2021/1/24-9:54 PM
 */
public interface UserMapper {

    @Insert("INSERT INTO user (name,age) VALUES ('张三',10)")
    int insert();

    @Select("SELECT * FROM user")
    List<Map<String, Object>> queryForList();
}
