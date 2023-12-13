package com.admin.dart.collector.utils;

import com.admin.dart.collector.code.ErrorCode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ResponseUtil {
    
    public static ResponseEntity<Map<String, Object>> responseOk(@Nullable Map<String, Object> res) {
            
        return ResponseEntity.ok(res);
    }

    public static ResponseEntity<Map<String, Object>> responseError(ErrorCode errorCode) {

        Map<String, Object> res = new HashMap<>();

        res.put("message", "fail");
        res.put("code", errorCode.getCode());
        res.put("error", errorCode.getMessage());

        log.error("message={}", errorCode.getMessage());

        return ResponseEntity
            .status(errorCode.getStatus())
            .body(res);
    }    
}
