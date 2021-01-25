## Mybatis 双数据源 读写分离

- 双数据源
- 读写分离
- `main`分支为手动配置形式
- `spring_boot`分支为自动配置形式

## 框架

- [shardingsphere](https://shardingsphere.apache.org/)

## 数据库准备

- `datasource1` 主库
- `datasource1_slave` 从库
- `datasource2` 动态库

## 建表

- 查看`sql`目录