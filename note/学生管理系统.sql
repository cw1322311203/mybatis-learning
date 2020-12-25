-- 创建db3数据库
CREATE DATABASE db3;

-- 使用db3数据库
USE db3;

-- 创建用户表
CREATE TABLE USER(
	uid VARCHAR(50) PRIMARY KEY,	-- 用户id
	ucode VARCHAR(50),		-- 用户标识
	loginname VARCHAR(100),		-- 登录用户名
	PASSWORD VARCHAR(100),		-- 登录密码
	username VARCHAR(100),		-- 用户名
	gender VARCHAR(10),		-- 用户性别
	birthday DATE,			-- 出生日期
	dutydate DATE                   -- 入职日期
);

-- 添加一条测试数据
INSERT INTO USER VALUES ('11111111', 'zhangsan001', 'zhangsan', '1234', '张三', '男', '2008-10-28', '2018-10-28');


-- 创建student表
CREATE TABLE student(
	sid INT PRIMARY KEY AUTO_INCREMENT,	-- 学生id
	NAME VARCHAR(20),			-- 学生姓名
	age INT,				-- 学生年龄
	birthday DATE				-- 学生生日
);

-- 添加数据
INSERT INTO student VALUES (NULL,'张三',23,'1999-09-23'),(NULL,'李四',24,'1998-08-10'),
(NULL,'王五',25,'1996-06-06'),(NULL,'赵六',26,'1994-10-20');
