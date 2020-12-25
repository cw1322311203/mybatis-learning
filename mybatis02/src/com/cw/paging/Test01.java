package com.cw.paging;

import com.cw.bean.Student;
import com.cw.mapper.StudentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 陈小哥cw
 * @date 2020/12/23 13:21
 */
public class Test01 {
    @Test
    public void selectPaging() throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        // 通过分页助手来实现分页功能
        // 第一页:显示3条数据
        // PageHelper.startPage(1, 3);
        // 第二页:显示3条数据
        // PageHelper.startPage(2, 3);
        // 第三页:显示3条数据
        PageHelper.startPage(3, 3);

        List<Student> students = mapper.selectAll();

        // 获取分页相关参数
        PageInfo<Student> info = new PageInfo<>(students);
        System.out.println("总条数:" + info.getTotal());
        System.out.println("总页数:" + info.getPages());
        System.out.println("当前页:" + info.getPageNum());
        System.out.println("每页显示条数:" + info.getPageSize());
        System.out.println("上一页:" + info.getPrePage());
        System.out.println("下一页:" + info.getNextPage());
        System.out.println("是否是第一页:" + info.isIsFirstPage());
        System.out.println("是否是最后一页:" + info.isIsLastPage());

        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
        is.close();
    }
}
