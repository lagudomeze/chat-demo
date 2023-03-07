package com.happy.example.api.image;

import java.util.List;

public record ImageResponse(Long created, List<Image> data) {
}
