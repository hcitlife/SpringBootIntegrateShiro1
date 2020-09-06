package com.hc.service.impl;

import com.hc.domain.User;
import com.hc.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void getUserByUsername(){
        System.out.println(userService);
        User user = userService.getUserByUsername("hc");
        System.out.println(user);
    }

}