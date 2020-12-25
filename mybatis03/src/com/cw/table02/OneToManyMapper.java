package com.cw.table02;

import com.cw.bean.Classes;

import java.util.List;

/**
 * 一个班级对应多个学生
 */
public interface OneToManyMapper {
    //查询全部
    public abstract List<Classes> selectAll();
}
