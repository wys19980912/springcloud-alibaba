package com.wys.filters;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


//自定义全局过滤器需要实现GlobalFilter和Ordered接口
//@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    //完成判断逻辑
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求参数中的值
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (StringUtils.isBlank(token)) {
            System.out.println("鉴权失败");
            //返回一个表示失败的状态码
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            //ServerWebExchange 就相当于当前请求和响应的上下文。 ServerWebExchange 实例不单存储了 Request 和 Response 对象，
            // 还提供了一些扩展方法，如果想实现改造请求参数或者响应参数，就必须深入了解 ServerWebExchange 。
            //getResponse()  获取ServerHttpResponse对象 setComplete()表示设置完成 并包装成Mono<Void>对象
            return exchange.getResponse().setComplete();
        }
        //调用chain.filter继续向下游执行 表示鉴权成功，放行exchange请求
        return chain.filter(exchange);
    }


    //顺序,数值越小,优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
