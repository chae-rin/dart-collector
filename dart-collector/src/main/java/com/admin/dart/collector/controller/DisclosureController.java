package com.admin.dart.collector.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.admin.dart.collector.code.ErrorCode;
import com.admin.dart.collector.utils.ResponseUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 공시정보를 수집하는 기능
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/disclosure", produces = "application/json; charset=utf8")
public class DisclosureController {

    // API-D01
	// 고유번호
    @PostMapping("/unique_num")
    public ResponseEntity<Map<String, Object>> getUniqueNumBinary(@RequestParam("crtfc_key") String crtfc_key) {
    	
    	String reqUrl = "opendart.fss.or.kr/api/corpCode.xml";
    	
    	Map<String, Object> res = new HashMap<>();
    	
    	BufferedReader resTextReader = null;
    	HttpsURLConnection conn = null;
    	
		try 
		{
			UriComponents uri = UriComponentsBuilder
		      .newInstance()
		      .scheme("https")
		      .host(reqUrl)
		      .queryParam("crtfc_key", crtfc_key)
		      .build();
			
			System.out.println( uri );

		    HttpHeaders headers = new HttpHeaders();
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
		    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		    HttpEntity<String> entity = new HttpEntity<String>(headers);

		    RestTemplate restTemplate = new RestTemplate();
		    ResponseEntity<byte[]> response = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, byte[].class);
		    
		    
		    File lOutFile = new File("C:\\Users\\cofls\\Downloads\\temp.zip");
		    FileOutputStream lFileOutputStream = new FileOutputStream(lOutFile);
		    lFileOutputStream.write(response.getBody());
		    lFileOutputStream.close();

		    
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
