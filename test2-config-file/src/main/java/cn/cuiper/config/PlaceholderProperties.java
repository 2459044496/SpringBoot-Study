package cn.cuiper.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app")
@PropertySource(value = "classpath:placeholder.properties", encoding = "UTF-8")
public class PlaceholderProperties {

    private String name;

    private String desc;

    private String notmatch;

    private String defalutvalue;
}
