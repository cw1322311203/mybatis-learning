package com.cw.one_to_one;

import com.cw.bean.Card;
import com.cw.bean.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 陈小哥cw
 * @date 2020/12/24 17:43
 */
public interface CardMapper {
    // 查询全部
    @Select("select * from card")
    @Results({//封装映射关系的父注解
            /*
                @Result：封装映射关系的子注解
                column：查询出的表中字段名称
                property：实体对象中的属性名称
                javaType：被包含对象的数据类型
                one：一对一查询固定属性
             */
            @Result(column = "id", property = "id"),
            @Result(column = "number", property = "number"),
            @Result(
                    property = "p",// 被包含对象的变量名
                    javaType = Person.class,//被包含对象的实际数据类型
                    column = "pid",//根据查询出的card表中的pid字段来查询person表
                    /*
                        one,@One 一对一查询固定属性
                        select属性：指定调用哪个接口中的哪个方法
                     */
                    one = @One(select = "com.cw.one_to_one.PersonMapper.selectById")
            )
    })
    public abstract List<Card> selectAll();
}
