package cn.cuiper.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {

    // SpringBoot默认导入DataSoure不会加入 initial-size等其他配置，
    // 此处手动加入druid数据源bean，并通过@ConfigurationProperties读取yaml的相关配置
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     * 配置Druid的监控
     * 配置一个管理后台的Servlet：StatViewServlet
     * 可以请求该servlet访问到Druid后台监控管理页面
     */
    @Bean
    @ConfigurationProperties(prefix = "druid.stat.view-servlet")
    public ServletRegistrationBean statViewServlet() {
        return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
    }

    /**
     * 配置Duird的过滤器webStatFilter
     */
    @Bean
    @ConfigurationProperties(prefix = "druid.stat.web-filter")
    public FilterRegistrationBean webStatFilter() {
        return new FilterRegistrationBean(new WebStatFilter());
    }
}
