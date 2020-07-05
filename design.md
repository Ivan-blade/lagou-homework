### 设计

+ 使用前端、数据库、JavaWeb 等技术并采用 MVC 设计模式实现学生信息管理系统，要求使用管理员账号密码 登录后进行学员信息增加、学员信息修改、学员信息删除、学员信息查找、学员信息显示功能。 

+ 其中学生信息有： 

   学号、姓名、性别、出生日期、邮箱、备注 

+ 要求： 

  + 前端页面、数据库表、后台业务等自行设计和实现，根据功能点和后期维护及可扩展程度给分。 

     + 尽可能使用已学过的流行技术，如：数据库连接池、分页显示等

       

+ 数据表设计

  + 数据库

    ```mysql
    create database if not exists db_web character set utf8;
    ```

    

  + 管理员表

    ```mysql
    create table if not exists user(
      id int primary key auto_increment,
      userName varchar(20),
      password varchar(20)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    insert into user set username = 'admin', password = '123456';
    ```

  + 用户表

    ```mysql
    create table if not exists student(
    	id int primary key auto_increment,
      userName varchar(20),
      gender char(1),
      birthday date,
      email varchar(20),
      note varchar(50)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8; 
    ```

    

+ 前端结构
  + 登陆逻辑
    + index页面用于重定向页面到登陆（懒的改login文件名。。。所以做了重定向）
    + 用户登陆成功会跳转到task页面进行功能选择，如果不登陆，直接访问task会被重定向回登陆页面
  + 管理页面
    + 功能选择模块
      + 包括增删查改，以及过滤条件
      + 增加
      + 删除
      + 查找
      + 修改
      + 主要逻辑
        + 每次调用功能模块会向后端发送请求，后端接收到之后将数据对象list封装在attribute当中，将会话状态转发给task.jsp
    + 数据渲染模块
      + 根据功能选择获取相应数据并进行数据渲染
      + 主要是渲染处理后的list对象

+ 后端结构
  + bean
    + User
      +  id，学号、姓名、密码，性别、出生日期、邮箱、备注 
      + 构造方法
      + get，set
      + toString
  + dao
    + UserDao（接口编写）
      + UserInsert
      + UserDelete
      + UserSelectById
      + UserSelectAll
      + UserUpdate
    + UserDaoImpl（实现接口）
      + userInsert(User user)
        + 用户增加
      + userDelete(int id)
        + 用户信息删除
      + userSelectById(int id)
        + 根据用户id查询信息
      + userSelectAll()
        + 查询全部信息
      + userUpdate(User user)
        + 用户信息修改,根据用户id修改填入其他内容
  + factory（返回接口实现对象）
    + UserDaoFactory
      + 静态方法getUserDao返回UserDaoImpl对象
  + service（）
    + UserService
      + 私有变量UserDao
      + 构造函数初始化UserDao变量，从UserDaoFactory中获取相应
      + 自定义方法
        + UserInsertService
          + 调用UserDao.userInsert(user)
        + UserDeleteService
          + 调用UserDao.UserDelete(id)
        + UserSelectByIdService
          + 调用UserDao.SelectById(id)
        + UserSelectAllService
          + 调用UserDao.userSelectAll()
        + UserUpdateService
          + 调用UserDao.userUpdate(user)
  + serlvet
    + LoginServlet
      + 管理员登陆，为了防止管理员信息和用户信息混淆，需要另建表存储学生数据
  + util
    + DbUtil
      + 连接池
        + 初始化
        + 获取连接
        + 关闭连接