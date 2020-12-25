package com.cw.one_to_many;

import com.cw.bean.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    //根据cid查询student表
    @Select("SELECT * FROM student WHERE cid=#{cid}")
    public abstract List<Student> selectByCid(Integer cid);
}
