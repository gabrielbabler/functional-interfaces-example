package com.portoseg.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JsonConfig {

    private final ObjectMapper mapper;

    @SneakyThrows
    public <T> T stringJsonToObject(String json, Class<T> clazz) {
        return mapper.readValue(json, clazz);
    }

    @SneakyThrows
    public String objectToStringJson(Object object) {
        return mapper.writeValueAsString(object);
    }
}
