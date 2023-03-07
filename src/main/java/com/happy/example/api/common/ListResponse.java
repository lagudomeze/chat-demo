package com.happy.example.api.common;

import java.util.List;

public record ListResponse<T>(List<T> data) implements Response {

}
