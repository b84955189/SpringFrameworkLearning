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
        //获取类加载器
        ClassLoader classLoader = userDao.getClass().getClassLoader();
        //获取目标类的所有实现接口
        Class<?>[] interfaces = userDao.getClass().getInterfaces();
        //创建增强的目标代理类
        return (UserDao) Proxy.newProxyInstance(classLoader,interfaces,this);
    }
    /**
     * 执行被代理对象的任何方法都会经过该方法，该方法有拦截的功能
     * Object proxy：代理对象的引用。不一定每次都会有
     * Method method：当前执行的方法
     * Object[] args：当前执行方法所需的参数
     * @return 当前执行方法的返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LogAspect logAspect = new LogAspect();

        System.out.println("方法名："+method.getName());
        //切片方法
        logAspect.printLogStart();
        //Test--模拟耗时操作
        Thread.sleep(1000);
        Object invoke = method.invoke(userDao, args);
        //切片方法
        logAspect.printLogEnd();
        return invoke;
    }
}
