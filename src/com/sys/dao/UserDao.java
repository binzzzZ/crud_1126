package com.sys.dao;

import com.sys.entity.Page;
import com.sys.entity.User;
import com.sys.utils.JdbcTemplateUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author lrbin
 * @version 1.0.0
 * @company
 * @create 2019/11/26 17:51
 * @Description
 */
public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcTemplateUtil.getDataSource());

    //查询所有数据
    public List<User> listAll(String account, Page page) {
        String sql = "select * from sys_user where account like ? limit ?,?";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class), "%" + account + "%",
                (page.getPage() - 1) * page.getPageSize(), page.getPageSize());
    }

    //查询总记录数
    public Integer count(String account) {
        String sql = "select count(1) from sys_user where account like ?";
        return template.queryForObject(sql, Integer.class, "%" + account + "%");
    }

    //通过ID删除数据
    public void deleteById(Integer id) {
        String sql = "delete from sys_user where id = ?";
        template.update(sql, id);
    }

    //添加一条数据
    public void addUser(User user) {
        String sql = "insert into sys_user(account,name,age,sex,birth_date,create_time) values (?,?,?,?,?,?)";
        template.update(sql, user.getAccount(), user.getName(), user.getAge(), user.getSex(), user.getBirthDate(),
                user.getCreateTime());
    }

    //查询一条数据
    public User getById(Integer id) {
        String sql = "select * from sys_user where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    //通过ID修改数据
    public void updateById(User user) {
        String sql = "update sys_user set account=?,name=?,age=?,sex=?,birth_date=? where id = ?";
        template.update(sql, user.getAccount(), user.getName(), user.getAge(), user.getSex(), user.getBirthDate(),
                user.getId());
    }
}
