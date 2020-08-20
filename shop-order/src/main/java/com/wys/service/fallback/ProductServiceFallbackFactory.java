package com.wys.service.fallback;

import com.wys.domain.Product;
import com.wys.service.ProductService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

//这是容错类,他要求我们要是实现一个FallbackFactory<要为哪个接口产生容错类>
@Slf4j
@Component
public class ProductServiceFallbackFactory implements FallbackFactory<ProductService> {
    //Throwable  这就是fegin在调用过程中产生异常
    @Override
    public ProductService create(Throwable throwable) {
        return new ProductService() {
            @Override
            public Product findByPid(Integer pid) {
                //打印异常的信息
                log.error("{}",throwable);
                Product product = new Product();
                product.setPid(-1);
                product.setPname("商品微服务调用出现异常了,已经进入到了容错方法中");
                return product;
            }
        };
    }
}
