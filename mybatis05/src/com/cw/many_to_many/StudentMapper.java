package com.cw.many_to_many;

import com.cw.bean.Student;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    //查询全部
    @Select("select distinct s.id,s.name,s.age from student s,stu_cr sc where sc.sid=s.id")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "age", property = "age"),
            @Result(column = "name", property = "name"),
            @Result(
                    property = "courses",// 被包含对象的变量名
                    javaType = List.class,// 被包含对象的实际数据类型
                    column = "id",// 根据查询出student表的id来作为关联条件，去查询中间表和课程表
                    many = @Many(select = "com.cw.many_to_many.CourseMapper.selectBySid")
            )
    })
    public abstract List<Student> selectAll();
}
