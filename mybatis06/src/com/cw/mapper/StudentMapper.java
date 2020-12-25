package com.cw.mapper;

import com.cw.bean.Student;
import com.cw.sql.ReturnSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
    //查询全部
    //@Select("SELECT * FROM student")
    /*
        @SelectProvider：生成查询用的 SQL 语句注解。
        type 属性：生成 SQL 语句功能类对象
        method 属性：指定调用方法
     */
    @SelectProvider(type = ReturnSql.class, method = "getSelectAll")
    public abstract List<Student> selectAll();

    //新增功能
    //@Insert("INSERT INTO student VALUES (#{id},#{name},#{age})")
    @InsertProvider(type = ReturnSql.class, method = "getInsert")
    public abstract Integer insert(Student stu);

    //修改功能
    //@Update("UPDATE student SET name=#{name},age=#{age} WHERE id=#{id}")
    @UpdateProvider(type = ReturnSql.class, method = "getUpdate")
    public abstract Integer update(Student stu);

    //删除功能
    //@Delete("DELETE FROM student WHERE id=#{id}")
    @DeleteProvider(type = ReturnSql.class, method = "getDelete")
    public abstract Integer delete(Integer id);
}
