package com.happy.example.config;

import com.happy.example.api.client.OpenAiClient;
import com.happy.example.api.client.TestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ApiConfig {

    @Bean
    public TestClient testClient() {
        WebClient client = WebClient.builder().baseUrl("https://www.baidu.com").build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
            .builder(WebClientAdapter.forClient(client))
            .build();
        return factory.createClient(TestClient.class);
    }

    @Value("${open.ai.api-token}")
    private String apiToken;

    @Bean
    public OpenAiClient openAiClient() {
        WebClient client = WebClient
            .builder()
            .defaultHeader("Authorization", "Bearer "+ apiToken)
            .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
            .builder(WebClientAdapter.forClient(client))
            .build();
        return factory.createClient(OpenAiClient.class);
    }
}
