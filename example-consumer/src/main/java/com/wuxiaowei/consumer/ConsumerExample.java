package com.wuxiaowei.consumer;

import com.wuxiaowei.common.modle.User;
import com.wuxiaowei.common.service.UserService;
import com.wuxiaowei.rpc.RpcApplication;
import com.wuxiaowei.rpc.config.RpcConfig;
import com.wuxiaowei.rpc.proxy.ServiceProxyFactory;
import com.wuxiaowei.rpc.utils.ConfigUtils;

/**
 * 简易服务消费者示例
 *
 */
public class ConsumerExample {

    public static void main(String[] args) {
        RpcApplication.init();
        System.out.println(RpcApplication.getRpcConfig());

        // todo 需要获取 UserService 的实现类对象
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("yupi");
        // 调用
        for(int i = 0; i < 3; i++){
            User newUser = userService.getUser(user);
            if (newUser != null) {
                System.out.println(newUser.getName());
            } else {
                System.out.println("user == null");
            }
        }
    }
}
