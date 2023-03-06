package cn.cuiper.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserUseValueAnnotation {

    // @Value不支持List、Map等复杂类型。
    // 只能一个一个指定，支持SpEL表达式。
    // 不支持@Validate校验注解

    @Value("${user.string}")
    private String string;

    @Value("#{12 + 12}")
    private Integer sum;

    @Value("18")
    private Integer age;
}
