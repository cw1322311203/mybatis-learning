package com.cw.dao;

import com.cw.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class StudentTest01 {

    /*
        查询全部
     */
    @Test
    public void selectAll() throws Exception {
        //1.加载核心配置文件
        // 通过类加载器返回指定资源的字节输入流
        //InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        InputStream is = StudentTest01.class.getClassLoader().getResourceAsStream("MyBatisConfig.xml");

        //2.获取SqlSession工厂对象
        // 通过指定资源字节输入流获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.通过SqlSession工厂对象获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.执行映射配置文件中的sql语句，并接收结果
        List<Student> list = sqlSession.selectList("StudentMapper.selectAll");

        //5.处理结果
        for (Student student : list) {
            System.out.println(student);
        }

        //6.释放资源
        sqlSession.close();
        is.close();
    }

    /*
       根据ID进行查询
     */
    @Test
    public void selectById() throws Exception {
        // 1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        // 2.获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 3.通过工厂对象获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.执行映射配置文件中的sql语句，并接收结果
        Student stu = sqlSession.selectOne("StudentMapper.selectById", 3);

        // 5.处理结果
        System.out.println(stu);

        // 6.释放资源
        sqlSession.close();
        is.close();
    }

    /*
        新增功能
     */
    @Test
    public void insert() throws Exception {
        // 1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        // 2.获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 3.通过工厂对象获取SqlSession对象
        // openSession参数不加true则默认不提交事务，需要在后面使用commit进行提交
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 4.执行映射配置文件中的sql语句，并接收结果
        //int result = sqlSession.insert("StudentMapper.insert", new Student(4, "赵六", 26));
        int result = sqlSession.insert("StudentMapper.insert", new Student(5, "周七", 24));

        // 5.提交事务(增删改需要进行事务操作)
        //sqlSession.commit();

        // 6.处理结果
        System.out.println(result);

        // 7.释放资源
        sqlSession.close();
        is.close();
    }

    /*
        修改功能
     */
    @Test
    public void update() throws Exception {
        // 1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        // 2.获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 3.通过工厂对象获取SqlSession对象
        // openSession参数不加true则默认不提交事务，需要在后面使用commit进行提交
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.执行映射配置文件中的sql语句，并接收结果
        int result = sqlSession.update("StudentMapper.update", new Student(5, "周七", 37));

        // 5.提交事务(增删改需要进行事务操作)
        sqlSession.commit();

        // 6.处理结果
        System.out.println(result);

        // 7.释放资源
        sqlSession.close();
        is.close();
    }

    /*
        删除功能
     */
    @Test
    public void delete() throws Exception {
        // 1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        // 2.获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 3.通过工厂对象获取SqlSession对象
        // openSession参数不加true则默认不提交事务，需要在后面使用commit进行提交
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.执行映射配置文件中的sql语句，并接收结果
        int result = sqlSession.delete("StudentMapper.delete", 5);

        // 5.提交事务(增删改需要进行事务操作)
        sqlSession.commit();

        // 6.处理结果
        System.out.println(result);

        // 7.释放资源
        sqlSession.close();
        is.close();
    }
}
