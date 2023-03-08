package cn.cuiper.dao;

import cn.cuiper.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    void add(User user);

    void update(User user);

    void delById(Integer id);

    Long getCount();

    User selById(Integer id);

    List<User> selAllUser();

    void batchAddUser(List<User> list);

    void batchUpdateUser(List<User> list);

}
