package com.cw.table03;

import com.cw.bean.Classes;
import com.cw.bean.Course;
import com.cw.bean.Student;
import com.cw.table02.OneToManyMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author 陈小哥cw
 * @date 2020/12/24 14:41
 */
public class Test01 {
    @Test
    public void selectAll() throws Exception {
        //1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        //2.获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.通过工厂对象获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //4.获取ManyToManyMapper接口的实现类对象
        ManyToManyMapper mapper = sqlSession.getMapper(ManyToManyMapper.class);

        //5.调用实现类的方法，接收结果
        List<Student> students = mapper.selectAll();

        //6.处理结果
        for (Student student : students) {
            System.out.println(student.getId() + "," + student.getName() + "," + student.getAge());
            List<Course> courses = student.getCourses();
            for (Course course : courses) {
                System.out.println("\t" + course);
            }
        }

        //7.释放资源
        sqlSession.close();
        is.close();
    }
}
