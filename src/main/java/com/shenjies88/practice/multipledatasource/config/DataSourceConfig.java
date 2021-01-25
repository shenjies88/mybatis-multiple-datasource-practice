package com.shenjies88.practice.multipledatasource.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.shardingsphere.api.config.masterslave.MasterSlaveRuleConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

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
    DataSource dsOne() throws SQLException {
        // Configure actual data sources
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        String masterName = "";
        List<String> slaveName = new ArrayList<>();
        for (ShardingSphereConfig.DataSourceProperties dataSourceProperties : shardingSphereConfig.getDatasource()) {
            BasicDataSource masterDataSource = new BasicDataSource();
            masterDataSource.setUrl(dataSourceProperties.getUrl());
            masterDataSource.setUsername(dataSourceProperties.getUsername());
            masterDataSource.setPassword(dataSourceProperties.getPassword());
            dataSourceMap.put(dataSourceProperties.getName(), masterDataSource);
            if (dataSourceProperties.getMaster()) {
                masterName = dataSourceProperties.getName();
            } else {
                slaveName.add(dataSourceProperties.getName());
            }
        }
        MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration("ds_master_slave", masterName, slaveName);
        return MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, masterSlaveRuleConfig, new Properties());
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.dynamic.datasource.datasource2")
    DataSource dsTwo() {
        return DataSourceBuilder.create().build();
    }

}
