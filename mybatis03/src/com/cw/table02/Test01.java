package com.cw.table02;

import com.cw.bean.Card;
import com.cw.bean.Classes;
import com.cw.bean.Student;
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

        //4.获取OneToManyMapper接口的实现类对象
        OneToManyMapper mapper = sqlSession.getMapper(OneToManyMapper.class);

        //5.调用实现类的方法，接收结果
        List<Classes> classes = mapper.selectAll();

        //6.处理结果
        for (Classes c : classes) {
            System.out.println(c.getId() + "," + c.getName());
            List<Student> students = c.getStudents();
            for (Student student : students) {
                System.out.println("\t" + student);
            }
        }

        //7.释放资源
        sqlSession.close();
        is.close();
    }
}
