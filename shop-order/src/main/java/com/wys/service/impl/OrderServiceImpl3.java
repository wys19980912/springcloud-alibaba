package com.wys.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.context.ContextUtil;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl3 {
    //设定一个资源 资源名称是 message
    @SentinelResource("message")
    public void message() {
        System.out.println("message");
    }
}
