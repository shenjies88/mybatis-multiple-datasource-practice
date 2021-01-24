package com.shenjies88.practice.multipledatasource.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author shenjies88
 * @since 2021/1/24-9:51 PM
 */
@AllArgsConstructor
@Data
@Configuration
public class DataSourceConfig {

    private final ShardingSphereConfig shardingSphereConfig;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.datasource1")
    DataSource dsOne() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.datasource.datasource2")
    DataSource dsTwo() {
        return DataSourceBuilder.create().build();
    }

}
