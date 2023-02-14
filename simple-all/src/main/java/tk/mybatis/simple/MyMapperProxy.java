package tk.mybatis.simple;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// todo mapper 代理的简单模型
public class MyMapperProxy<T> implements InvocationHandler {
    private Class<T> mapperInterface;
    private SqlSession sqlSession;

    public MyMapperProxy(Class<T> mapperInterface, SqlSession sqlSession) {
        this.mapperInterface = mapperInterface;
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //针对不同的 sql 类型，需要调用 sqlSession 不同的方法
        //参数也有很多情况，这里只考虑一个参数的情况
        //返回值也有很多情况
        return sqlSession.<T>selectList(mapperInterface.getCanonicalName() + "." + method.getName());
    }

    public static void main(String[] args) {
        // 获取类的全限定名
        System.out.println(MyMapperProxy.class.getCanonicalName());
    }
}
