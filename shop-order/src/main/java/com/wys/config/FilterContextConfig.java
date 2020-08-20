package com.wys.config;


import com.alibaba.csp.sentinel.adapter.spring.webmvc.config.SentinelWebMvcConfig;
import com.alibaba.csp.sentinel.context.ContextUtil;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class FilterContextConfig {
//    @Bean
//    public SentinelWebMvcConfig sentinelWebMvcConfig() {
////        FilterRegistrationBean registration = new FilterRegistrationBean();
////        registration.setFilter(new CommonFilter());
////        registration.addUrlPatterns("/*");
////        // 入口资源关闭聚合
////        registration.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY, "false");
////        registration.setName("sentinelFilter");
////        registration.setOrder(1);
////        return registration;
//        SentinelWebMvcConfig sentinelWebMvcConfig = new SentinelWebMvcConfig();
//        sentinelWebMvcConfig.setHttpMethodSpecify(false);
//        return sentinelWebMvcConfig;
//    }
//}
