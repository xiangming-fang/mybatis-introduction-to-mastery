package tk.mybatis.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: mybatis
 * @Package: tk.mybatis.web.annotation
 * @ClassName: SeeMapper
 * @Author: albert.fang
 * @Description: 能看见这个mapper接口
 * @Date: 2023/2/14 21:22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SeeMapper {
}
