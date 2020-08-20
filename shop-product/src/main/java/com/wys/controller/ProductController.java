package com.wys.controller;


import com.alibaba.fastjson.JSON;
import com.wys.domain.Product;
import com.wys.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j //打印日志
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping("/product/api1/demo01")
    public String demo01(){
        return "demo01";
    }
    @RequestMapping("/product/api1/demo02")
    public String demo02(){
        return "demo02";
    }
    @RequestMapping("/product/api2/demo01")
    public String demo03(){
        return "demo03";
    }
    @RequestMapping("/product/api2/demo04")
    public String demo04(){
        return "demo04";
    }

    //商品信息查询
    @GetMapping("product/{pid}")
    public Product product(@PathVariable("pid") Integer pid){


        log.info("接下来要进行{}号商品信息的查询", pid);

        Product product = productService.findByPid(pid);
        log.info("商品信息查询成功,内容为{}",JSON.toJSONString(product));
        return product;

    }
}
