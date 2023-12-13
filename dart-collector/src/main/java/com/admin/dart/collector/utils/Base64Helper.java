package com.admin.dart.collector.utils;

import java.util.Base64;

/**
 * Base64 처리
 */
public class Base64Helper {

    /**
     * Base64 디코딩
     * @param encodedString 인코딩된 문자열
     * @return 문자열 (plain text)
     */
    public static String decodeBase64(String encodedString) {

        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        return new String(decodedBytes);
    }

    /**
     * Base64 인코딩
     * @param originalInput 문자열 (plain text)
     * @return 인코딩된 문자열
     */
    public static String encodeBase64(String originalInput){
        
        return Base64.getEncoder().encodeToString(originalInput.getBytes());
    }

}
