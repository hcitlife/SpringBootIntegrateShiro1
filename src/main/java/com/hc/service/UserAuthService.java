package com.hc.service;

import com.hc.domain.Auth;
import com.hc.domain.UserAuth;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserAuthService extends IService<UserAuth>{

    List<Auth> getAuthsByUserId(Integer userid);
}
