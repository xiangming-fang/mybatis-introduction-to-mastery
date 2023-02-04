package tk.mybatis.simple.model;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @Author: albert.fang
 * @Description:
 * @Date: 2023/2/4 16:15
 */
public class CountryTest {
    public static void main(String[] args) throws IOException {
        // 1、读取mybatis-config文件，生成reader
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        // 2、sqlsessionFactoryBuilder 根据 reader 生成sqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        // 3、根据sqlSessionFactory生成sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4、sqlSession调用执行的方法，这方法定义在 mapper 文件里
        List<Country> list = sqlSession.selectList("selectAllCountry");
        for (Country country : list) {
            System.out.println(country.toString());
        }
        sqlSession.close();
    }
}
