package com.hc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hc.domain.Auth;
import com.hc.mapper.AuthMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hc.mapper.UserAuthMapper;
import com.hc.domain.UserAuth;
import com.hc.service.UserAuthService;
@Service
public class UserAuthServiceImpl extends ServiceImpl<UserAuthMapper, UserAuth> implements UserAuthService{

    @Resource
    private UserAuthMapper userAuthMapper;
    @Resource
    private AuthMapper authMapper;

    @Override
    public List<Auth> getAuthsByUserId(Integer userid) {
        List<Auth> auths = new ArrayList<>();

        QueryWrapper<UserAuth> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userid);
        List<UserAuth> userAuths = userAuthMapper.selectList(queryWrapper);
        for (UserAuth userAuth : userAuths) {
            Auth auth = authMapper.selectById(userAuth.getAuthId());
            auths.add(auth);
        }
        return auths;
    }
}
