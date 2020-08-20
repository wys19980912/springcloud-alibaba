package com.wys.service;

import com.wys.domain.Order;
import com.wys.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;

public interface OrderService {
    void creatOrder(Order order);
}
