package top.lking.app;

import top.lking.dao.UserDao;
import top.lking.dao.impl.NormalStudentDaoImpl;
import top.lking.dao.impl.NormalUserDaoImpl;
import top.lking.dao.impl.SimpleStudentDaoImpl;
import top.lking.dao.impl.SimpleUserDaoImpl;
import top.lking.dao.proxy.StudentDaoProxy;
import top.lking.dao.proxy.UserDaoProxy;

public class App {
    public static void main(String[] args) {


        UserDaoProxy userDaoProxy = new UserDaoProxy();

        SimpleUserDaoImpl simpleUserDao = new SimpleUserDaoImpl();
        NormalUserDaoImpl normalUserDao = new NormalUserDaoImpl();

        //---------JDK原生动态代理--------------
        //UserDao normalProxy = userDaoProxy.createProxy(normalUserDao);
       // UserDao simpleProxy = userDaoProxy.createProxy(simpleUserDao);
       // simpleProxy.deleteUser();
        //----------CGLIB动态代理--------------
        StudentDaoProxy studentDaoProxy = new StudentDaoProxy();
        SimpleStudentDaoImpl simpleStudentDao = new SimpleStudentDaoImpl();
        NormalStudentDaoImpl normalStudentDao = new NormalStudentDaoImpl();
        SimpleStudentDaoImpl studentProxy = (SimpleStudentDaoImpl)studentDaoProxy.createProxy(simpleStudentDao);
        NormalStudentDaoImpl normalStudentProxy = (NormalStudentDaoImpl) studentDaoProxy.createProxy(normalStudentDao);

        studentProxy.addStudent();
        normalStudentProxy.addStudent();
    }
}
