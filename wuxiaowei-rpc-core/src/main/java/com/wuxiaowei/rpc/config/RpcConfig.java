package com.wuxiaowei.rpc.config;

import com.wuxiaowei.rpc.fault.retry.RetryStrategyKeys;
import com.wuxiaowei.rpc.fault.tolerant.TolerantStrategyKeys;
import com.wuxiaowei.rpc.loadbalancer.LoadBalancerKeys;
import com.wuxiaowei.rpc.serializer.SerializerKeys;
import lombok.Data;

/**
 * RPC 框架配置
 */
@Data
public class RpcConfig {

    /**
     * 名称
     */
    private String name = "wuxiaowei-rpc";

    /**
     * 版本号
     */
    private String version = "1.0";

    /**
     * 服务器主机名
     */
    private String serverHost = "localhost";
    
    /**
     * 服务器端口号
     */
    private Integer serverPort = 8080;

    /**
     * Mock模拟接口返回值
     */
    private boolean isMock = true;

    /**
     * 序列化器
     */
    private String serializer = SerializerKeys.JDK;

    /**
     * 负载均衡器
     */
    private String loadBalancer = LoadBalancerKeys.ROUND_ROBIN;

    /**
     * 注册中心配置
     */
    private RegistryConfig registryConfig = new RegistryConfig();

    /**
     * 重试策略
     */
    private String retryStrategy = RetryStrategyKeys.FIXED_INTERVAL;

    /**
     * 容错策略
     */
    private String tolerantStrategy = TolerantStrategyKeys.FAIL_FAST;

}
