package com.admin.dart.collector.utils;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonParser {

    public static  Map<String, Object> parse(String source) {

        Map<String, Object> json = new HashMap<>();
        try {
            json = new Gson().fromJson(source, new TypeToken<Map<String, Object>>(){}.getType());
        } catch (Exception ex) {
            
        }
        return json;
    }

}
