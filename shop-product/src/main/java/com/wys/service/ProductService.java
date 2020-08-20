package com.wys.service;

import com.wys.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;

public interface ProductService {
    @GetMapping(value = "/product/{pid}")
    Product findByPid(Integer pid);
}
