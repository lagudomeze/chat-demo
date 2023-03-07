package com.happy.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.happy.example.api.client.OpenAiClient;
import com.happy.example.api.client.TestClient;
import com.happy.example.api.common.ListResponse;
import com.happy.example.api.image.CreateImage;
import com.happy.example.api.image.ImageResponse;
import com.happy.example.api.model.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
@Slf4j
public class DemoController {
    private final OpenAiClient openAiClient;

    private final ObjectMapper mapper;

    public DemoController(OpenAiClient openAiClient, ObjectMapper mapper, TestClient testClient) {
        this.openAiClient = openAiClient;
        this.mapper = mapper;
        this.testClient = testClient;
    }

    @GetMapping("/models")
    public ListResponse<Model> models() {
        return openAiClient.models();
    }

    @GetMapping("/images")
    public ImageResponse images(@RequestParam String prompt) {
        CreateImage image = CreateImage.of(prompt);
        try {
            log.info(mapper.writeValueAsString(image));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return openAiClient.createImage(image);
    }

    private final TestClient testClient;

    @GetMapping("/test")
    public String test() {
        return testClient.testBaidu();
    }
}
