package com.happy.example.api.client;

import com.happy.example.api.common.ListResponse;
import com.happy.example.api.image.CreateImage;
import com.happy.example.api.image.ImageResponse;
import com.happy.example.api.model.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("https://api.openai.com/v1")
public interface OpenAiClient {

    @GetExchange("/models")
    ListResponse<Model> models();

    @PostExchange("/images/generations")
    ImageResponse createImage(@RequestBody CreateImage request);
}
