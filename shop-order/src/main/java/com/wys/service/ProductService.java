package com.wys.service;

import com.wys.domain.Product;
import com.wys.service.fallback.ProductServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//value用于指定调用nacos下哪个微服务
//fallback用于指定容错类
//fallback 指定当调用出现问题之后,要进入到哪个类中的同名方法之下执行备用逻辑
@FeignClient(
        value = "service-product",
//        fallback = ProductServiceFallBack.class,
        fallbackFactory = ProductServiceFallbackFactory.class
)
public interface ProductService {
    //指定调用提供者的哪个方法
    //@FeignClient+@GetMapping 就是一个完整的请求路径 http://service-product/product/{pid}
    //根据service-product会从nacos中获取相应服务的 ip跟端口号
    @GetMapping(value = "/product/{pid}")
    Product findByPid(@PathVariable("pid") Integer pid);
}
