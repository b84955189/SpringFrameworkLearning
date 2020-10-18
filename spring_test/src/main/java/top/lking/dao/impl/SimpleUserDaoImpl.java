package top.lking.dao.impl;

import top.lking.dao.UserDao;

public class SimpleUserDaoImpl implements UserDao {


    @Override
    public void addUser() {
        System.out.println("简易添加用户！");
    }

    @Override
    public void deleteUser() {
        System.out.println("简易删除用户！");
    }
}
