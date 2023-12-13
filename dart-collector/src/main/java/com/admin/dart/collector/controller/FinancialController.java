package com.admin.dart.collector.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.admin.dart.collector.code.ErrorCode;
import com.admin.dart.collector.dto.FinancialReqDto;
import com.admin.dart.collector.utils.ResponseUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 회사의 재무정보를 수집하는 기능
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/financial", produces = "application/json; charset=utf8")
public class FinancialController {

    // API-C01
	// 단일회사 전체 재무제표
    @PostMapping("/all")
    public ResponseEntity<Map<String, Object>> getSingleCompAllFinanInfo(@RequestBody FinancialReqDto paramDto) {
    	
    	String reqUrl = "opendart.fss.or.kr/api/fnlttSinglAcntAll.json";
    	
    	Map<String, Object> res = new HashMap<>();
    	
    	BufferedReader resTextReader = null;
    	HttpsURLConnection conn = null;
    	
		try 
		{
            UriComponents uri = UriComponentsBuilder
      		      .newInstance()
      		      .scheme("https")
      		      .host(reqUrl)
      		      .queryParam("crtfc_key", paramDto.getCrtfc_key())
      		      .queryParam("corp_code", paramDto.getCorp_code())
      		      .queryParam("bsns_year", paramDto.getBsns_year())
      		  	  .queryParam("reprt_code", paramDto.getReprt_code())
      		  	  .queryParam("fs_div", paramDto.getFs_div())
      		      .build();
            
            System.out.println( uri );
            
			URL url = new URL( uri.toString() );
			conn = (HttpsURLConnection) url.openConnection();
	    	
			conn.setRequestMethod("GET");
	    	conn.setRequestProperty("Content-type", "application/json; charset=UTF-8");
	    	conn.setDoOutput(true);
	    	
	    	
	    	// API 응답메시지를 불러와서 문자열로 저장
	    	InputStream resText = (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) ? conn.getInputStream() : conn.getErrorStream();
	    	resTextReader = new BufferedReader(new InputStreamReader(resText, "UTF-8"));
	    	
	    	String line;
	    	StringBuilder sb = new StringBuilder();
	    	
	    	while ((line = resTextReader.readLine()) != null) 
	    	{
	    	    sb.append(line);
	    	}
	    	
	    	String text = sb.toString();
	    	
	    	System.out.println( text );
	    	return ResponseUtil.responseOk(res);
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
            return ResponseUtil.responseError(ErrorCode.INTERNAL_SERVER_ERROR);
		}
    	finally
    	{
    		try 
    		{
				if(resTextReader != null ) 
					resTextReader.close();
				
				if( conn != null )
					conn.disconnect();
			} 
    		catch (IOException e) 
    		{
				e.printStackTrace();
			}
    	}

    }

}
