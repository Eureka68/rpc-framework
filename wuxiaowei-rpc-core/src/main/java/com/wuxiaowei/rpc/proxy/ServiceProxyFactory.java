package com.wuxiaowei.rpc.proxy;

import com.wuxiaowei.rpc.RpcApplication;
import com.wuxiaowei.rpc.config.RpcConfig;

import java.lang.reflect.Proxy;

/**
 * 服务代理工厂（用于创建代理对象）
 */
public class ServiceProxyFactory {

    /**
     * 根据服务类获取代理对象
     *
     * @param serviceClass
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Class<T> serviceClass) {

        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        // 判断是否需要Mock方法
        if(rpcConfig.isMock()){
            return (T) Proxy.newProxyInstance(
                    serviceClass.getClassLoader(),
                    new Class[]{serviceClass},
                    new MockServiceProxy());
        }

        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy());
    }
}
