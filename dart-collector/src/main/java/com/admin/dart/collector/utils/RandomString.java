package com.admin.dart.collector.utils;

import java.util.Random;

/**
 * 랜덤 문자열
 */
public class RandomString {

  /**
   * 문자와 숫자로 이루어진 랜덤 문자열 생성
   * 
   * @param length 문자열의 길이
   * @return 랜덤 문자열
   */
  public static String randomAlpahNumeric(int length) {

    int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    Random random = new Random();

    return random.ints(leftLimit, rightLimit + 1)
      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
      .limit(length)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();
  }

  /**
   * Connection ID 문자열 생성
   * @return Connection ID 문자열
   */
  public static String makeSampleId(){

    StringBuilder sb = new StringBuilder();

    sb.append("SMPL");
    sb.append("-");
    sb.append(randomAlpahNumeric(5));
    sb.append("-");
    sb.append(DateTimeHelper.getCurrentDateTimeToMillisecondsToSimple());

    return sb.toString();
  }

}
