package com.cw.service.impl;

import com.cw.bean.Student;
import com.cw.mapper.StudentMapper;
import com.cw.mapper.impl.StudentMapperImpl;
import com.cw.service.StudentService;

import java.util.List;

/**
 * @author 陈小哥cw
 * @date 2020/12/23 9:09
 * <p>
 * 业务层实现类
 */
public class StudentServiceImpl implements StudentService {

    // 创建持久层对象
    private StudentMapper mapper = new StudentMapperImpl();

    @Override
    public List<Student> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Student selectById(Integer id) {
        return mapper.selectById(id);
    }

    @Override
    public Integer insert(Student stu) {
        return mapper.insert(stu);
    }

    @Override
    public Integer update(Student stu) {
        return mapper.update(stu);
    }

    @Override
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }
}
