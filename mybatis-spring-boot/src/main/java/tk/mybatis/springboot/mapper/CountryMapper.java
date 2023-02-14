package tk.mybatis.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.springboot.model.Country;

import java.util.List;

@Mapper
public interface CountryMapper {
    /**
     * 查询全部数据
     *
     * @return
     */
    List<Country> selectAll();
}
