package com.wuxiaowei;

import com.wuxiaowei.rpc.loadbalancer.ConsistentHashLoadBalancer;
import com.wuxiaowei.rpc.loadbalancer.LoadBalancer;
import com.wuxiaowei.rpc.loadbalancer.RandomLoadBalancer;
import com.wuxiaowei.rpc.loadbalancer.RoundRobinLoadBalancer;
import com.wuxiaowei.rpc.model.ServiceMetaInfo;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * 负载均衡器测试
 */
public class LoadBalancerTest {

    final LoadBalancer loadBalancer = new RoundRobinLoadBalancer();

    @Test
    public void select() {
        // 请求参数
        Map<String, Object> requestParams = new HashMap<>();
        requestParams.put("methodName", "apple");
        // 服务列表
        ServiceMetaInfo serviceMetaInfo1 = new ServiceMetaInfo();
        serviceMetaInfo1.setServiceName("myService");
        serviceMetaInfo1.setServiceVersion("1.0");
        serviceMetaInfo1.setServiceHost("localhost");
        serviceMetaInfo1.setServicePort(1234);
        ServiceMetaInfo serviceMetaInfo2 = new ServiceMetaInfo();
        serviceMetaInfo2.setServiceName("myService");
        serviceMetaInfo2.setServiceVersion("1.0");
        serviceMetaInfo2.setServiceHost("wuxiaowei.icu");
        serviceMetaInfo2.setServicePort(80);
        List<ServiceMetaInfo> serviceMetaInfoList = Arrays.asList(serviceMetaInfo1, serviceMetaInfo2);
        // 连续调用 3 次
        ServiceMetaInfo serviceMetaInfo = loadBalancer.select(requestParams, serviceMetaInfoList);
        System.out.println(serviceMetaInfo);
        Assert.assertNotNull(serviceMetaInfo);
        serviceMetaInfo = loadBalancer.select(requestParams, serviceMetaInfoList);
        System.out.println(serviceMetaInfo);
        Assert.assertNotNull(serviceMetaInfo);
        serviceMetaInfo = loadBalancer.select(requestParams, serviceMetaInfoList);
        System.out.println(serviceMetaInfo);
        Assert.assertNotNull(serviceMetaInfo);
    }
}
