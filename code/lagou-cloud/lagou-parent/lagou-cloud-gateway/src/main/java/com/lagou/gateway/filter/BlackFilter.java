package com.lagou.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author apple
 * @date 2021/1/28 下午7:59
 * @description
 */
@Component
public class BlackFilter implements GlobalFilter, Ordered {

    // 加载黑名单列表
    private static List<String> blackList = new ArrayList<>();

    static {
        // blackList.add("127.0.0.1");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String clientIP = request.getRemoteAddress().getHostString();
        if(blackList.contains(clientIP)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            String data = "request be denied";
            DataBuffer wrap = response.bufferFactory().wrap(data.getBytes());
            return response.writeWith(Mono.just(wrap));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}