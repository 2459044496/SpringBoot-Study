package cn.cuiper.dao;

import cn.cuiper.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(User user) {
        String sql = "insert into user values (?,?,?)";
        Object[] args = {user.getId(), user.getName(), user.getPwd()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println("add sql返回结果:" + update);
    }

    @Override
    public void update(User user) {
        String sql = "update user set id=?, name = ?, pwd = ?";
        Object[] args = {user.getId(), user.getName(), user.getPwd()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println("update sql返回结果:" + update);
    }

    @Override
    public void delById(Integer id) {
        String sql = "delete from user where id = ?";
        int update = jdbcTemplate.update(sql, new Object[]{id});
        System.out.println("delById sql返回结果:" + update);
    }

    @Override
    public Long getCount() {
        String sql = "select count(*) from user";
        // 查询返回某个值
        // queryForObject 参数1：sql   参数2：返回类型
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println("getCount sql返回结果:" + count);
        return count;
    }

    @Override
    public User selById(Integer id) {
        String sql = "select * from user where id = ?";
        // 查询返回 对象
        // queryForObject 参数1：sql   参数2：返回类型，需要包装  参数3：sql替换参数
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        System.out.println("selById sql返回结果:" + user);
        return user;
    }

    @Override
    public List<User> selAllUser() {
        String sql = "select * from user";
        // 查询返回 集合对象
        // query 参数1：sql   参数2：返回类型，需要包装
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println("selById sql返回结果:" + users);
        return users;
    }

    /**
     * @param list
     * 批量新增
     */
    @Override
    public void batchAddUser(List<User> list) {
        String sql = "insert into user values (?,?,?)";
        List<Object[]> param = new ArrayList<>(list.size());
        for (User user : list) {
            Object[] o = {user.getId(), user.getName(), user.getPwd()};
            param.add(o);
        }
        int[] ints = jdbcTemplate.batchUpdate(sql, param);
        System.out.println("batchAddUser sql返回结果:" + Arrays.toString(ints));
    }

    @Override
    /**
     * @param list
     * 批量修改
     */
    public void batchUpdateUser(List<User> list) {
        String sql = "update user set name = ?, pwd = ? where id =?";
        List<Object[]> param = new ArrayList<>(list.size());
        for (User user : list) {
            Object[] o = {user.getName(), user.getPwd(), user.getId()};
            param.add(o);
        }
        int[] ints = jdbcTemplate.batchUpdate(sql, param);
        System.out.println("batchUpdateUser sql返回结果:" + Arrays.toString(ints));
    }
}
