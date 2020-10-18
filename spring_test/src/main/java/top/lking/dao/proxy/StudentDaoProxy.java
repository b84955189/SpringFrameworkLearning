package top.lking.dao.proxy;



import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import top.lking.aspect.LogAspect;


import java.lang.reflect.Method;

public class StudentDaoProxy implements MethodInterceptor {
    public Object createProxy(Object target){
        //实例化增强器
        Enhancer enhancer = new Enhancer();
        //确定其要增强的类，设置其为父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //根据目标类生成以目标类为父类的目标代理类
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //实例化切面对象
        LogAspect logAspect = new LogAspect();
        //前增强
        logAspect.printLogStart();
        //目标方法执行
        Object methodResult = methodProxy.invokeSuper(o, objects);
        //后增强
        logAspect.printLogEnd();

        return methodResult;
    }
}
