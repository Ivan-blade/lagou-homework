### process

```sql
-- 小说网站数据库设计
CREATE DATABASE novel_db CHARACTER SET 'utf8';


-- 小说表
CREATE TABLE novel(
id BIGINT(20) PRIMARY KEY COMMENT '小说ID',
title VARCHAR(50) COMMENT '名称', 
author VARCHAR(50) COMMENT '作者',
pic VARCHAR(255) COMMENT '图片',
content TEXT COMMENT '内容介绍'
);

-- 用户表
CREATE TABLE users(
 id BIGINT(20) PRIMARY KEY COMMENT '用户ID',
 username VARCHAR(20) COMMENT '用户名',
 PASSWORD VARCHAR(12) COMMENT '密码',
 address VARCHAR(20)  COMMENT '地址' 
);


-- 系统区域表
CREATE TABLE sys_region  (
 id BIGINT(20) PRIMARY KEY COMMENT '地区ID',
 region_name VARCHAR(100) COMMENT '区域名称',
 region_code VARCHAR(20)  COMMENT '行政地区编号',
 region_level INT COMMENT '等级'
);
```

+ 数据库分库分表设计如下:

1. 将小说与用户信息,根据业务不同进行**垂直分库**, 分为 `lg_novel_db`  和 `lg_user_db` 两个库

   + 分别创建数据库即可

     ```sql
     # 两台机器上创建novel_db用于部署主从同步，一台机器上放置user_db,并进行水平分表
     CREATE DATABASE novel_db CHARACTER SET 'utf8';
     use novel_db;
     -- 小说表
     CREATE TABLE novel(
     id BIGINT(20) PRIMARY KEY COMMENT '小说ID',
     title VARCHAR(50) COMMENT '名称', 
     author VARCHAR(50) COMMENT '作者',
     pic VARCHAR(255) COMMENT '图片',
     content TEXT COMMENT '内容介绍'
     );
     
     
     CREATE DATABASE user_db CHARACTER SET 'utf8';
     use user_db;
     -- 用户表
     CREATE TABLE users_1(
      id BIGINT(20) PRIMARY KEY COMMENT '用户ID',
      username VARCHAR(20) COMMENT '用户名',
      PASSWORD VARCHAR(12) COMMENT '密码',
      address VARCHAR(20)  COMMENT '地址' 
     );
     CREATE TABLE users_2(
      id BIGINT(20) PRIMARY KEY COMMENT '用户ID',
      username VARCHAR(20) COMMENT '用户名',
      PASSWORD VARCHAR(12) COMMENT '密码',
      address VARCHAR(20)  COMMENT '地址' 
     );
     
     ```

     

2. 将地理区域表作为 **公共表**, 冗余在 两个库中

   ```sql
   # 在三个数据库中创建公共表
   -- 系统区域表
   CREATE TABLE sys_region  (
    id BIGINT(20) PRIMARY KEY COMMENT '地区ID',
    region_name VARCHAR(100) COMMENT '区域名称',
    region_code VARCHAR(20)  COMMENT '行政地区编号',
    region_level INT COMMENT '等级'
   );
   
   # 通过sharding-JDBC指定公共表
   # 指定sys_region为公共表 
   spring.shardingsphere.sharding.broadcast-tables = sys_region
   # 主键生成策略 
   spring.shardingsphere.sharding.tables.district.key-generator.column = id spring.shardingsphere.sharding.tables.district.key-generator.type = SNOWFLAKE
   ```

   

+ 其他要求

  + 对`novel` 表 进行读写分离,创建主库与从库.

    ```shell
    # 主库
    vim /etc/my.cnf
    
    lower_case_table_names=1
    log-bin=mysql-bin
    server-id=1
    binlog-do-db=novel_db
    binlog_ignore_db=mysql
    
    service mysqld restart
    
    # 如果之前啊有过主从配置需要重制主从关系
    RESET MASTER;
    
    #从库
    vim /etc/my.cnf
    
    server-id=2
    
    mysql -uroot -p
    STOP SLAVE;
    CHANGE MASTER TO MASTER_HOST='172.16.161.140',
    MASTER_USER='slave',
    MASTER_PASSWORD='!Qs1178594290',
    MASTER_PORT=3306,
    MASTER_LOG_FILE='mysql-bin.000001',
    MASTER_LOG_POS=0,
    MASTER_CONNECT_RETRY=10;
    
    -- 编辑auto.cnf
    vim /var/lib/mysql/auto.cnf
    -- 修改UUID的值 server-uuid=a402ac7f-c392-11ea-ad18-000c2980a208(随便改改)
    -- 重启
    service mysqld restart
    
    
    start slave;
    -- 查看状态
    SHOW SLAVE STATUS;
    -- 命令行下查看状态 执行 
    SHOW SLAVE STATUS \G;
    
    # 通过sharding-jdbc完成读写分离
    spring.shardingsphere.datasource.names = m1,s1
    
    spring.shardingsphere.datasource.m1.type = com.alibaba.druid.pool.DruidDataSource
    spring.shardingsphere.datasource.m1.driver-class-name = com.mysql.jdbc.Driver
    spring.shardingsphere.datasource.m1.url = jdbc:mysql://172.16.161.140:3306/test?characterEncoding=UTF-8&useSSL=false
    spring.shardingsphere.datasource.m1.username = root
    spring.shardingsphere.datasource.m1.password = xxxxxx
    
    spring.shardingsphere.datasource.s1.type = com.alibaba.druid.pool.DruidDataSource
    spring.shardingsphere.datasource.s1.driver-class-name = com.mysql.jdbc.Driver
    spring.shardingsphere.datasource.s1.url = jdbc:mysql://172.16.161.138:3306/test?characterEncoding=UTF-8&useSSL=false
    spring.shardingsphere.datasource.s1.username = root
    spring.shardingsphere.datasource.s1.password = xxxxxx
    
    # 主从
    spring.shardingsphere.sharding.master-slave-rules.ms1.master-data-source-name = m1
    spring.shardingsphere.sharding.master-slave-rules.ms1.slave-data-source-names = s1
    
    #配置数据节点
    spring.shardingsphere.sharding.tables.products.actual-data-nodes = ms1.novel_db
    ```

    

  + 对`users` 表进行水平分表,分片键使用户id, 分片策略为 **id%2 + 1**

    ```properties
    # 配置数据节点,指定节点的信息 将会被替换为1或者2
    spring.shardingsphere.sharding.tables.users.actual-data-nodes = db1.users_$->{1..2}
    
    
    #指定users表 (逻辑表)的主键生成策略为 SNOWFLAKE
    spring.shardingsphere.sharding.tables.users.key-generator.column = id
    spring.shardingsphere.sharding.tables.users.key-generator.type = SNOWFLAKE
    
    #指定users表的分片策略，分片策略包括分片键和分片算法
    spring.shardingsphere.sharding.tables.users.table-strategy.inline.sharding-column = id
    spring.shardingsphere.sharding.tables.users.table-strategy.inline.algorithm-expression = users_$->{id % 2 + 1}
    ```

    