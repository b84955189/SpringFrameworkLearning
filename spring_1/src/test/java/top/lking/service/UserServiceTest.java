package top.lking.service;

import org.junit.Test;
import top.lking.service.impl.UserServiceImpl;

public class UserServiceTest {
    @Test
    public void testDoSome(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.doSome();
    }
}
