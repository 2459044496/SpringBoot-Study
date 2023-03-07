package cn.cuiper.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    @Autowired
    ServerProperties serverProperties;

    @Autowired
    ApplicationContext context;

    @GetMapping("/say")
    public String say() {
        return "Hello Cui.";
    }

    @GetMapping("/printServerProperties")
    public String printServerProperties() {
        ServerProperties bean = context.getBean(ServerProperties.class);
        return String.valueOf(serverProperties.getTomcat().getThreads().getMax());
    }
}
