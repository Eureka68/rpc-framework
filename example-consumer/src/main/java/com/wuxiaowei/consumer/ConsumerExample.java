package com.wuxiaowei.consumer;

import com.wuxiaowei.common.modle.User;
import com.wuxiaowei.common.service.UserService;
import com.wuxiaowei.rpc.bootstrap.ConsumerBootstrap;
import com.wuxiaowei.rpc.proxy.ServiceProxyFactory;

public class ConsumerExample {

    public static void main(String[] args) {
        // 服务提供者初始化
        ConsumerBootstrap.init();

        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("wuxiaowei");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
