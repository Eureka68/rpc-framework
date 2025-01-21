package com.wuxiaowei.provider;

import com.wuxiaowei.common.service.UserService;
import com.wuxiaowei.rpc.RpcApplication;
import com.wuxiaowei.rpc.registry.LocalRegistry;
import com.wuxiaowei.rpc.server.HttpServer;
import com.wuxiaowei.rpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 *
 */
public class ProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化(将application.properties中的配置封装到RpcConfig中)
        RpcApplication.init();

        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
