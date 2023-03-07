package cn.cuiper.controller;

import cn.cuiper.annotation.MyLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @RequestMapping("/login")
    @MyLog(module = "用户管理", type = 2, detail = "用户登录")
    public String login() {
        log.info("用户执行登录操作");
        return "success";
    }

    @RequestMapping("/logout")
    @MyLog(module = "用户管理", type = 3, detail = "用户退出")
    public String logout() {
        log.info("用户执行退出操作");
        return "success";
    }

    @RequestMapping("/register")
    @MyLog(module = "用户管理", type = 4, detail = "用户注册")
    public String register() {
        log.info("用户执行注册操作");
        return "success";
    }

}
