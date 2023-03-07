package com.happy.example.api.client;

import com.happy.example.api.common.ListResponse;
import com.happy.example.api.model.Model;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("https://api.openai.com/v1")
public interface OpenAiClient {

    @GetExchange("/models")
    ListResponse<Model> models();
}
