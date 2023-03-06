package cn.cuiper.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
// prefix值必须是小写，否则编译异常 Prefix must be in canonical form
@ConfigurationProperties(prefix = "test.random")
@PropertySource("classpath:random_value.properties")
public class RandomValuePropertySource {

    private String value;

    private Integer int1;

    private Long long1;

    private Integer int2;

    private Integer int3;

    private String uuid;

}
