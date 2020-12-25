package com.cw.service.impl;

import com.cw.bean.Student;
import com.cw.mapper.StudentMapper;
import com.cw.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 陈小哥cw
 * @date 2020/12/23 9:09
 * <p>
 * 业务层实现类
 */
public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> selectAll() {
        List<Student> students = null;
        SqlSession sqlSession = null;
        InputStream is = null;
        try {
            // 1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");

            // 2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            // 3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession();

            // 4.获取StudentMapper接口的实现类对象
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);// 相当于StudentMapper mapper = new StudentMapperImpl();

            // 5.通过实现类对象调用方法，接收结果
            students = mapper.selectAll();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 6.释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 7.返回结果
        return students;
    }

    @Override
    public Student selectById(Integer id) {
        Student student = null;
        SqlSession sqlSession = null;
        InputStream is = null;
        try {
            // 1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");

            // 2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            // 3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession();

            // 4.获取StudentMapper接口的实现类对象
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);// 相当于StudentMapper mapper = new StudentMapperImpl();

            // 5.通过实现类对象调用方法，接收结果
            student = mapper.selectById(id);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 6.释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 7.返回结果
        return student;
    }

    @Override
    public Integer insert(Student stu) {
        Integer result = null;
        SqlSession sqlSession = null;
        InputStream is = null;
        try {
            // 1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");

            // 2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            // 3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession();

            // 4.获取StudentMapper接口的实现类对象
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);// 相当于StudentMapper mapper = new StudentMapperImpl();

            // 5.通过实现类对象调用方法，接收结果
            result = mapper.insert(stu);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 6.释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 7.返回结果
        return result;
    }

    @Override
    public Integer update(Student stu) {
        Integer result = null;
        SqlSession sqlSession = null;
        InputStream is = null;
        try {
            // 1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");

            // 2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            // 3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession();

            // 4.获取StudentMapper接口的实现类对象
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);// 相当于StudentMapper mapper = new StudentMapperImpl();

            // 5.通过实现类对象调用方法，接收结果
            result = mapper.update(stu);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 6.释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 7.返回结果
        return result;
    }

    @Override
    public Integer delete(Integer id) {
        Integer result = null;
        SqlSession sqlSession = null;
        InputStream is = null;
        try {
            // 1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");

            // 2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            // 3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession();

            // 4.获取StudentMapper接口的实现类对象
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);// 相当于StudentMapper mapper = new StudentMapperImpl();

            // 5.通过实现类对象调用方法，接收结果
            result = mapper.delete(id);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 6.释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 7.返回结果
        return result;
    }
}
