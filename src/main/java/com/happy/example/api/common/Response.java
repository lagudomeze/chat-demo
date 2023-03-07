package com.happy.example.api.common;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = NAME, property = "object")
@JsonSubTypes({
    @Type(value = ListResponse.class, name = "list"),
})
public sealed interface Response permits ListResponse {

}
