package com.wuxiaowei.provider;

import com.wuxiaowei.common.service.UserService;
import com.wuxiaowei.rpc.RpcApplication;
import com.wuxiaowei.rpc.bootstrap.ProviderBootstrap;
import com.wuxiaowei.rpc.config.RegistryConfig;
import com.wuxiaowei.rpc.config.RpcConfig;
import com.wuxiaowei.rpc.model.ServiceMetaInfo;
import com.wuxiaowei.rpc.model.ServiceRegisterInfo;
import com.wuxiaowei.rpc.registry.LocalRegistry;
import com.wuxiaowei.rpc.registry.Registry;
import com.wuxiaowei.rpc.registry.RegistryFactory;
import com.wuxiaowei.rpc.server.HttpServer;
import com.wuxiaowei.rpc.server.VertxHttpServer;
import com.wuxiaowei.rpc.server.tcp.VertxTcpServer;

import java.util.ArrayList;
import java.util.List;

/**
 * 简易服务提供者示例
 *
 */
public class ProviderExample {

    public static void main(String[] args) {
        // 要注册的服务
        List<ServiceRegisterInfo<?>> serviceRegisterInfoList = new ArrayList<>();
        ServiceRegisterInfo<?> serviceRegisterInfo = new ServiceRegisterInfo<>(UserService.class.getName(), UserServiceImpl.class);
        serviceRegisterInfoList.add(serviceRegisterInfo);

        // 服务提供者初始化
        ProviderBootstrap.init(serviceRegisterInfoList);
    }

}
