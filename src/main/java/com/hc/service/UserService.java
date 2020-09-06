package com.hc.service;

import com.hc.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
public interface UserService extends IService<User>{

    User getUserByUsername(String username);

}
