package cn.cuiper.controller;

import cn.cuiper.annotation.MyLog;
import cn.cuiper.pojo.ThymeleafUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafUserController {

    // Thymeleaf自动配置类ThymeleafProperties.java

    @RequestMapping("/showUser")
    @MyLog(module = "test", type = 1, detail = "测试Thymeleaf")
    public String showUser(@RequestBody ThymeleafUser user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("str", "展示字符串");
        return "user";
    }

}
