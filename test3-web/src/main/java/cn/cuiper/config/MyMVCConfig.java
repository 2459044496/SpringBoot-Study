package cn.cuiper.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@EnableWebMvc 放弃所有Spring Boot 对 SpringMVC的自动配置， 全部进行手动配置。
@Configuration
public class MyMVCConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 跨域配置
        registry.addMapping("/**").allowedOriginPatterns("*")
                .allowCredentials(true).allowedMethods("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器，可以做权限控制、日志记录
        registry.addInterceptor(new MyLogInterceptor()).addPathPatterns("/**");

        registry.addInterceptor(new PermissionInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/user/login", "/user/logout", "/user/register");
    }

}
