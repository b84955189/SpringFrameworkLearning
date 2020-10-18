package top.lking.app;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.lking.service.UserService;

public class AppTest {
    @Test
    public void testMain(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.doSome();
    }
    @Test
    public void testCount(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.getBeanDefinitionCount());
        for(String name:context.getBeanDefinitionNames()){
            System.out.println(name);
        }
    }
}
