package cn.cuiper.config;

import cn.cuiper.pojo.Book;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "user")
@PropertySource("classpath:jdbc.properties")
public class UserUseConfigurationPropertiesAnnotation {

    // @ConfigurationProperties支持复杂类型。
    // 支持JSR303,@Validate校验注解
    // @ConfigurationProperties默认从全局的配置文件中获取配置，如果想读取指定配置文件，可以在@PropertySource中进行指定。

    private String string;

    private List<String> list1;

    private Book book;

    private Map<String, String> map;

    private Object[] list2;

    private String singleQuote;

    private String doubleQuote;

    // jdbc.properties值
    private String url;

    private String driver;
}
