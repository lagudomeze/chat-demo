package com.happy.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/demo")
public class DemoController {
    private final URI base = URI.create("https://api.openai.com");

    private final HttpClient client = HttpClient
            .newBuilder()
            .build();

    @GetMapping("/models")
    public String models() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder(base.resolve("/v1/models"))
                .GET()
                .header("Authorization", "Bearer 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")
                .header("OpenAI-Organization", "org-5k1lGcipuHIUQYG1PaDNfLYv")
                .build();

        return client
                .send(request, HttpResponse.BodyHandlers.ofString())
                .body();
    }
}
