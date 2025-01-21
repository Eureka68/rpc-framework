package com.wuxiaowei.provider;


import com.wuxiaowei.common.modle.User;
import com.wuxiaowei.common.service.UserService;

/**
 * 用户服务实现类
 */
public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
