package com.shenjies88.practice.multipledatasource;

import com.shenjies88.practice.multipledatasource.data1mapper.UserMapper;
import com.shenjies88.practice.multipledatasource.data2mapper.MemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author shenjies88
 */
@AllArgsConstructor
@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MybatisMultipleDatasourcePracticeApplication {

    private final UserMapper userMapper;
    private final MemberMapper memberMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisMultipleDatasourcePracticeApplication.class, args);
    }

    @GetMapping("/insert-user")
    public void insertUser() {
        userMapper.insert();
    }

    @GetMapping("/get-user")
    public List<Map<String, Object>> getUser() {
        return userMapper.queryForList();
    }

    @GetMapping("/get-member")
    public List<Map<String, Object>> getMember() {
        return memberMapper.queryForList();
    }

}
