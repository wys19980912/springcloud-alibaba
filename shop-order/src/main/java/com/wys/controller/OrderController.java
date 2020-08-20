package com.wys.controller;


import com.alibaba.fastjson.JSON;
import com.wys.domain.Order;
import com.wys.domain.Product;
import com.wys.service.OrderService;
import com.wys.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@Slf4j
public class OrderController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    OrderService orderService;
    //注入DiscoveryClient实例来获取服务实例
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private ProductService productService;

    //下单 Ribbon实现负载均衡
    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid){
        log.info("接收到了{}号商品的下单请求，接下来调用商品微服务查询此商品信息",pid);
        //调用商品微服务,查询商品信息
        Product product = productService.findByPid(pid);
        // 调用失败后返回的json数据
        if (product.getPid() == -1) {
            Order order = new Order();
            order.setOid(-1l);
            order.setPname("下单失败");
            return order;
        }

        log.info("查询到{}号商品的信息，内容是：{}",pid,product);

        //下单(创建订单)
        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderService.creatOrder(order);
        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
        return order;
    }

//    //下单 Ribbon实现负载均衡
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid){
//        log.info("接收到了{}号商品的下单请求，接下来调用商品微服务查询此商品信息",pid);
//        //直接使用微服务名字， 从nacos中获取服务地址
//        String url = "service-product";
//        log.info(">>从nacos中获取到的微服务地址为:" + url);
//        //通过restTemplate调用商品微服务
//        //调用商品微服务,查询商品信息
//        //传入地址跟返回值类型
//        Product product = restTemplate.getForObject("http://" + url + "/product/" + pid, Product.class);
//        log.info("查询到{}号商品的信息，内容是：{}",pid, JSON.toJSONString(product));
//
//        //下单(创建订单)
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setPid(product.getPid());
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//        orderService.creatOrder(order);
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//        return order;
//    }
}
