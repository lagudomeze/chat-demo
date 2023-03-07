package com.happy.example.api.common;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, property = "object")
@JsonSubTypes({
        @Type(value = ListResponse.class, name = "list"),
})
public sealed interface Response permits ListResponse {

}
