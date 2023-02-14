package tk.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.generator.dao.CountryMapper;
import tk.mybatis.generator.pojo.Country;
import tk.mybatis.generator.pojo.CountryExample;

import java.util.List;

public class CountryMapperTest extends BaseMapperTest {

    @Test
    public void testExample() {
        // 获取 sqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取 CountryMapper 接口
            CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
            //创建 Example 对象
            CountryExample example = new CountryExample();
            //设置排序规则
            example.setOrderByClause("id desc, countryname asc");
            //设置是否 distinct 去重
            example.setDistinct(true);
            //创建条件，只能有一个 createCriteria
            CountryExample.Criteria criteria = example.createCriteria();
            //id >= 1
            criteria.andIdGreaterThanOrEqualTo(1);
            //id < 4
            criteria.andIdLessThan(4);
            //countrycode like '%U%'
            //最容易出错的地方，注意 like 必须自己写上通配符的位置，不可能默认两边加 %，like 可以是任何情况
            criteria.andCountrycodeLike("%U%");
            //or 的情况，可以有多个 or
            CountryExample.Criteria or = example.or();
            //countryname = 中国
            or.andCountrynameEqualTo("中国");
            //执行查询
            List<Country> countryList = countryMapper.selectByExample(example);
            printCountryList(countryList);
        } finally {
            // 不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    private void printCountryList(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.printf("%-4d%4s%4s\n", country.getId(), country.getCountryname(), country.getCountrycode());
        }
    }
}
