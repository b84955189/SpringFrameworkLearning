package top.lking.dao.impl;

import top.lking.dao.UserDao;

public class NormalUserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("普通添加用户！");
    }

    @Override
    public void deleteUser() {
        System.out.println("普通删除用户！");
    }
}
