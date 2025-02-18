package com.wuxiaowei.rpc.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class MockServiceProxy implements InvocationHandler {

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> returnType = method.getReturnType();
        log.info("mock invoke {}", method.getName());
        return getDefaultObject(returnType);
    }

    /**
     * 根据return类型返回Mock的数据
     * @param returnType
     * @return
     */
    private Object getDefaultObject(Class<?> returnType) {
        if(returnType.isPrimitive()){
            if(returnType == int.class){
                return 0;
            }else if(returnType == long.class){
                return 0L;
            }else if(returnType == boolean.class){
                return false;
            }else if(returnType == short.class){
                return 0;
            } else if(returnType == char.class){
                return '\0';
            }
        }

        return null;
    }
}
