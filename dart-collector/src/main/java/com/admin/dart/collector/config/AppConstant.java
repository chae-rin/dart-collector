package com.admin.dart.collector.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/*
 * 공통 상수
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppConstant {
  
  // REDIS 키 PREFIX
  public static final String REDIS_PREFIX_SCENARIO_INFO = "SN";
  public static final String REDIS_PREFIX_FIELD_SCENARIO = "FS";
  public static final String REDIS_PREFIX_CUSTOMER_REACTION = "RC";
  
  // 결과 로그
  public static final String EXEC_EVENT = "execution_event";

  // 표출시간설정 
  public static final String PRESENT_TIME_START = "09:00:00";
  public static final String PRESENT_TIME_END = "15:59:59";
  
  // 인증
  public static final String REQUEST_HEADER_DOMAIN_ID = "x-api-domain-id";
  public static final String REQUEST_HEADER_DOMAIN_KEY = "x-api-domain-key";
  
  public static final String APP_API_MIME_TYPE = "application/json";
  // 외부 API
  public static final String APP_BATCH_BASE_URL = "http://localhost:8082/outbound";

  // DB DRIVER
  public static final String DRIVER_CLASS_NAME_ORACLE = "oracle.jdbc.driver.OracleDriver";
  public static final String DRIVER_CLASS_NAME_MSSQL = "sun.jdbc.odbc.JdbcOdbcDriver";
  public static final String DRIVER_CLASS_NAME_MYSQL = "com.mysql.cj.jdbc.Driver";

}
