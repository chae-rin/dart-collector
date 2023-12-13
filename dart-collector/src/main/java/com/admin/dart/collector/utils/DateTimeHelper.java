package com.admin.dart.collector.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 날짜 처리
 */
public class DateTimeHelper {

    public static final Locale currentLocale = new Locale("KOREAN", "KOREA");

    /**
     * 현재 시간 문자열 반환
     * @return yyyyMMddHHmmss
     */
    public static String getCurrentDateTimeToSimple() {

        String pattern = "yyyyMMddHHmmss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, currentLocale);
        return formatter.format(new Date());
    }

    /**
     * 현재 시간 문자열 반환
     * @return yyyyMMddHHmmssSSSSSS
     */
    public static String getCurrentDateTimeToMillisecondsToSimple() {

        String pattern = "yyyyMMddHHmmssSSSSSS";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, currentLocale);
        return formatter.format(new Date());
    }

    /**
     * 현재 시간 문자열 반환
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentDateTime() {

        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, currentLocale);
        return formatter.format(new Date());
    }

    /**
     * 현재 일자 문자열
     * @return yyyyMMdd
     */
    public static String getDate() {

        String pattern = "yyyyMMdd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, currentLocale);
        return formatter.format(new Date());
    }

    /**
     * 현재 시간 문자열
     * @return HHmmss
     */
    public static String getTime() {

        String pattern = "HHmmss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, currentLocale);
        return formatter.format(new Date());
    }

    /**
     * 현재 시간 문자열 반환
     * @return yyyy-MM-dd HH:mm:ss.SSSSSS
     */
    public static String getCurrentDateTimeToMilliseconds() {

        String pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, currentLocale);
        return formatter.format(new Date());
    }

    /**
     * 현재 월(Month) 문자열 반환
     * @return MM
     */
    public static String currentMonth(){

        String pattern = "MM";
        SimpleDateFormat simpleformat = new SimpleDateFormat(pattern, currentLocale);
        return simpleformat.format(new Date());
    }

    /**
     * 현재 시간 반환
     * @return Date 객체
     */
    public static Date getCurrentDate(){
        return new Date();
    }

    /**
     * 문자열 to Date 객체
     * @param strDate 시간 문자열
     * @param pattern 시간 문자열의 format
     * @return Date 객체
     * @throws ParseException
     */
    public static Date getDateFromString(String strDate, String pattern) throws ParseException {

        SimpleDateFormat transFormat = new SimpleDateFormat(pattern, currentLocale);
        return transFormat.parse(strDate);
    }

    public static String getStringFromDate(Date date) {

        return getStringFromDate(date, "yyyy-MM-dd HH:mm:ss.SSSSSS");
    }

    public static String getStringFromDate(Date date, String pattern) {

        SimpleDateFormat formatter = new SimpleDateFormat(pattern, currentLocale);
        return formatter.format(date);
    }
}
