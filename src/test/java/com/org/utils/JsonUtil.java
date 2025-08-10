package com.org.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object obj) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
