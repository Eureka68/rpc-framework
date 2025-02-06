package com.wuxiaowei.example.springboot.provider;

import com.wuxiaowei.common.modle.User;
import com.wuxiaowei.common.service.UserService;
import com.wuxiaowei.rpc.springboot.starter.annotation.RpcService;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 */
@Service
@RpcService
public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
