package com.wys.service.fallback;

import com.wys.domain.Product;
import com.wys.service.ProductService;
import org.springframework.stereotype.Component;

//这是一个容错类
//它要求实现Feign所在接口,并实现里面的方法
//当feign调用出现问题的时候,就会进入到当前类中同名方法中
@Component
public class ProductServiceFallBack implements ProductService {
    @Override
    public Product findByPid(Integer pid) {
        Product product = new Product();
        product.setPid(-1);
        product.setPname("商品微服务调用出现异常了,已经进入到了容错方法中");
        return product;

    }
}
