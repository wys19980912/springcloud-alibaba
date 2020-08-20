package com.wys.controller;


import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.fastjson.JSON;
import com.wys.domain.Order;
import com.wys.domain.Product;
import com.wys.service.OrderService;
import com.wys.service.ProductService;
import com.wys.service.impl.OrderServiceImpl3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Slf4j
public class OrderController3 {
    @Autowired
    private OrderServiceImpl3 orderServiceImpl3;
    @RequestMapping("/order/message1")
    public String message1() {

        orderServiceImpl3.message();
        return "message1";
    }
    @RequestMapping("/order/message2")
    public String message2() {
        orderServiceImpl3.message();
        return "message2";
    }
}
