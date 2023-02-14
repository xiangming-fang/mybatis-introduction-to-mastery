package tk.mybatis.simple.interceptor;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.simple.mapper.BaseMapperTest;
import tk.mybatis.simple.mapper.UserMapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: albert.fang
 * @Description: 返回值map类型，key转驼峰式字符串
 * @Date: 2023/2/14 14:50
 */

public class CamelHumpInterceptorTest extends BaseMapperTest {

    // 测试map的key转驼峰式插件
    // List<Map> 成功生效
    @Test
    public void camelInterceptorTest() {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Map<String, Object>> res = userMapper.selectAllUsers();
        System.out.println(res);
        sqlSession.commit();
        sqlSession.close();
    }

    // 直接返回 Map 也可以生效
    @Test
    public void mapResultTest() {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = userMapper.selectMapById();
        System.out.println(map);
        sqlSession.commit();
        sqlSession.close();
    }
}
