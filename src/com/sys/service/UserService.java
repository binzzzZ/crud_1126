package com.sys.service;

import com.sys.dao.UserDao;
import com.sys.entity.Page;
import com.sys.entity.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lrbin
 * @version 1.0.0
 * @company
 * @create 2019/11/26 17:52
 * @Description
 */
public class UserService {
    private UserDao userDao = new UserDao();

    public List<User> listAll(String account, Page page) {
        return userDao.listAll(account, page);
    }

    public Integer count(String account) {
        return userDao.count(account);
    }

    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }

    public void addUser(User user) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);

        user.setCreateTime(dateStr);
        userDao.addUser(user);
    }

    public User getById(Integer id) {
        return userDao.getById(id);
    }

    public void updateById(User user) {
        userDao.updateById(user);
    }
}
