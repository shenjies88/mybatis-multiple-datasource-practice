package com.shenjies88.practice.multipledatasource.data2mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author shenjies88
 * @since 2021/1/24-9:55 PM
 */
public interface MemberMapper {

    @Select("SELECT * FROM member")
    List<Map<String, Object>> queryForList();
}
