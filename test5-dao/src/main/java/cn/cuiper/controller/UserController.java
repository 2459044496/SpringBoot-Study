package cn.cuiper.controller;

import cn.cuiper.dao.UserDao;
import cn.cuiper.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("selAllUser")
    public List<User> selAllUser() {
        return userDao.selAllUser();
    }

    @RequestMapping("selById")
    public User selById(@RequestParam("id")Integer id) {
        return userDao.selById(id);
    }
}
