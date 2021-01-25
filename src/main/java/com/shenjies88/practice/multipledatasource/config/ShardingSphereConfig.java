package com.shenjies88.practice.multipledatasource.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author shenjies88
 * @since 2021/1/24-10:45 PM
 */
@ConfigurationProperties(prefix = "spring.shardingsphere")
@Data
@Component
public class ShardingSphereConfig {

    private List<DataSourceProperties> datasource;

    private Map<String, String> props;

    @Data
    public static class DataSourceProperties {
        private String name;
        private String url;
        private String username;
        private String password;
        private Boolean master;
    }
}
