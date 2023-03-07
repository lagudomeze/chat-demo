package com.happy.example.api.client;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/")
public interface TestClient {
    @GetExchange
    String testBaidu();
}
