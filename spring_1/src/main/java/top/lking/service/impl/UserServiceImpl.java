package top.lking.service.impl;

import org.springframework.stereotype.Service;
import top.lking.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void doSome() {
        System.out.println("UserService doSome...");
    }
}
