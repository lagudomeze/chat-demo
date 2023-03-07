package com.happy.example.api.image;

import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public record CreateImage(
        String prompt,
        Integer n,
        Size size,
        ResponseFormat response_format,
        String user
) {

    public static CreateImage of(String prompt) {
        return new CreateImage(prompt, 1, Size._1024x1024, ResponseFormat.url, null);
    }
}
