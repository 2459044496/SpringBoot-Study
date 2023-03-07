package cn.cuiper.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {

    String module() default "";// 模块名

    int type() default 0;// 操作类型

    String detail() default "";// 详细信息
}
