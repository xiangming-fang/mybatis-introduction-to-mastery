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
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Country> list = sqlSession.selectList("selectAll");
        for (Country country : list) {
            System.out.println(country);
        }
        sqlSession.close();
    }
}
