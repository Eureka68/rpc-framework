package com.wuxiaowei.example.springboot.consumer;

import com.wuxiaowei.common.modle.User;
import com.wuxiaowei.common.service.UserService;
import com.wuxiaowei.rpc.springboot.starter.annotation.RpcReference;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl {

    @RpcReference
    private UserService userService;

    public void test() {
        User user = new User();
        user.setName("yupi");
        User resultUser = userService.getUser(user);
        System.out.println(resultUser.getName());
    }

}
