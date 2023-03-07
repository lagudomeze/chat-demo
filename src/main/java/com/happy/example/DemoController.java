package com.happy.example;

import com.happy.example.api.client.OpenAiClient;
import com.happy.example.api.client.TestClient;
import com.happy.example.api.common.ListResponse;
import com.happy.example.api.model.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {
    private final OpenAiClient openAiClient;

    public DemoController(OpenAiClient openAiClient, TestClient testClient) {
        this.openAiClient = openAiClient;
        this.testClient = testClient;
    }

    @GetMapping("/models")
    public ListResponse<Model> models() {
        return openAiClient.models();
    }

    private final TestClient testClient;

    @GetMapping("/test")
    public String test() {
        return testClient.testBaidu();
    }
}
