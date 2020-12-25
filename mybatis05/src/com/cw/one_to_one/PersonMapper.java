package com.cw.one_to_one;

import com.cw.bean.Person;
import org.apache.ibatis.annotations.Select;

/**
 * @author 陈小哥cw
 * @date 2020/12/24 17:44
 */
public interface PersonMapper {
    // 根据id查询
    @Select("select * from person where id = #{id}")
    public abstract Person selectById(Integer id);
}
