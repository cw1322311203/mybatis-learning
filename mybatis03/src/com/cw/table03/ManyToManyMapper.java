package com.cw.table03;

import com.cw.bean.Student;

import java.util.List;

/**
 * @author 陈小哥cw
 * @date 2020/12/24 15:39
 * 一个学生可以选择多门课程，一个课程也可以被多个学生所选择
 */
public interface ManyToManyMapper {
    // 查询全部
    public abstract List<Student> selectAll();
}
