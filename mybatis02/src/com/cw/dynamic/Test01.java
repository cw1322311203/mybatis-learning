package com.cw.dynamic;

import com.cw.bean.Student;
import com.cw.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈小哥cw
 * @date 2020/12/23 10:40
 */
public class Test01 {
    @Test
    public void selectCondition() throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student stu = new Student();
        stu.setId(2);
        stu.setName("李四");
        //  stu.setAge(24);

        List<Student> students = mapper.selectCondition(stu);

        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
        is.close();
    }

    @Test
    public void selectByIds() throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);

        List<Student> students = mapper.selectByIds(ids);

        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
        is.close();
    }
}
