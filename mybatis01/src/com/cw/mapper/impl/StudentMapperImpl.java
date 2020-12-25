package com.cw.mapper.impl;

import com.cw.bean.Student;
import com.cw.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 陈小哥cw
 * @date 2020/12/23 9:07
 * <p>
 * 持久层实现类
 */
public class StudentMapperImpl implements StudentMapper {
    /*
       查询全部
     */
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

            // 4.执行映射配置文件中的sql语句，并接收结果
            students = sqlSession.selectList("StudentMapper.selectAll");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5.释放资源
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
        // 6.返回结果
        return students;
    }

    /*
       根据id查询
     */
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

            // 4.执行映射配置文件中的sql语句，并接收结果
            student = sqlSession.selectOne("StudentMapper.selectById", id);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5.释放资源
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
        // 6.返回结果
        return student;
    }

    /*
       新增数据
     */
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
            sqlSession = sqlSessionFactory.openSession(true);// 增删改需要使用true标志，或者在后面使用commit方法

            // 4.执行映射配置文件中的sql语句，并接收结果
            result = sqlSession.insert("StudentMapper.insert", stu);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5.释放资源
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
        // 6.返回结果
        return result;
    }

    /*
       修改数据
     */
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
            sqlSession = sqlSessionFactory.openSession(true);

            // 4.执行映射配置文件中的sql语句，并接收结果
            result = sqlSession.update("StudentMapper.update", stu);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5.释放资源
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
        // 6.返回结果
        return result;
    }

    /*
       删除数据
     */
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
            sqlSession = sqlSessionFactory.openSession(true);

            // 4.执行映射配置文件中的sql语句，并接收结果
            result = sqlSession.delete("StudentMapper.delete", id);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5.释放资源
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
        // 6.返回结果
        return result;
    }
}
