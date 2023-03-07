package cn.cuiper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @SpringBootApplication注解默认会扫描当前包，下面代码会提示Redundant declaration: @SpringBootApplication already applies given @ComponentScan
// @ComponentScan(basePackages = "cn.cuiper")
public class Test3WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(Test3WebApplication.class, args);
    }
}
