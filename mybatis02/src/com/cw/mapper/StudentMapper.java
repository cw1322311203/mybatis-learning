package com.cw.mapper;

import com.cw.bean.Student;

import java.util.List;

/**
 * @author 陈小哥cw
 * @date 2020/12/23 9:00
 * 持久层接口
 */
public interface StudentMapper {
    // 查询全部
    public abstract List<Student> selectAll();

    // 根据id查询
    public abstract Student selectById(Integer id);

    // 新增数据
    public abstract Integer insert(Student stu);

    // 修改数据
    public abstract Integer update(Student stu);

    // 删除数据
    public abstract Integer delete(Integer id);

    // 多条件查询
    public abstract List<Student> selectCondition(Student stu);

    // 根据多个id查询
    public abstract List<Student> selectByIds(List<Integer> ids);
}
