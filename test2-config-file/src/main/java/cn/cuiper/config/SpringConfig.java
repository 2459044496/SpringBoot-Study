package cn.cuiper.config;

import cn.cuiper.addbean.UseBeanAnnotation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public UseBeanAnnotation useBeanAnnotation() {
        return new UseBeanAnnotation();
    }
}
