package top.lking.dao.proxy;

import top.lking.aspect.LogAspect;
import top.lking.dao.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserDaoProxy implements InvocationHandler {
    private UserDao userDao;


    public UserDao createProxy(UserDao userDao){
        this.userDao = userDao;

        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = userDao.getClass().getInterfaces();
        return (UserDao) Proxy.newProxyInstance(classLoader,interfaces,this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LogAspect logAspect = new LogAspect();

        System.out.println("方法名："+method.getName());
        logAspect.printLogStart();
        //Test
        Thread.sleep(1000);
        Object invoke = method.invoke(userDao, args);
        logAspect.printLogEnd();
        return invoke;
    }
}
