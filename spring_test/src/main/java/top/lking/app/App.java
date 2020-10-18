package top.lking.app;

import top.lking.dao.UserDao;
import top.lking.dao.impl.NormalUserDaoImpl;
import top.lking.dao.impl.SimpleUserDaoImpl;
import top.lking.dao.proxy.UserDaoProxy;

public class App {
    public static void main(String[] args) {


        UserDaoProxy userDaoProxy = new UserDaoProxy();

        SimpleUserDaoImpl simpleUserDao = new SimpleUserDaoImpl();
        NormalUserDaoImpl normalUserDao = new NormalUserDaoImpl();

        UserDao simpleProxy = userDaoProxy.createProxy(simpleUserDao);
        UserDao normalProxy = userDaoProxy.createProxy(normalUserDao);

        simpleProxy.deleteUser();
    }
}
