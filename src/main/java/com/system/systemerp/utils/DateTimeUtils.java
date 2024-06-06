package com.system.systemerp.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 放關於處理日期、時間等..共用工具
 *
 * @author Joyce
 */
public class DateTimeUtils {

    /**
     * 取得當前系統日期 yyyMM(民國年)
     *
     * @return 返回當前系統日期 yyyMM(民國年)
     */
    public static String rocYearMonth() {
        Calendar calendar = Calendar.getInstance();
        int rocYear = calendar.get(Calendar.YEAR) - 1911;
        int month = calendar.get(Calendar.MONTH) + 1;

        return String.format("%d%02d", rocYear, month);
    }

    /**
     * 取得當前系統日期 yyyMMdd(民國年月日)
     *
     * @return 返回當前系統日期 yyyMMdd(民國年月日)
     */
    public static String rocDateStr() {
        LocalDate currentDate = LocalDate.now();
        int rocYear = currentDate.getYear() - 1911;
        int month = currentDate.getMonthValue();
        return String.format("%d%02d%02d", rocYear, month, currentDate.getDayOfMonth());
    }

    /**
     * 將民國年月日字串轉換為西元年月日
     *
     * @param rocStr 民國年月日字串 (yyyMMdd)
     * @return 西元年月日時間格式 (yyyy-MM-dd)
     */
    public static LocalDate roc2ADYearMonthDay(String rocStr) {
        int year = Integer.parseInt(rocStr.substring(0, 3)) + 1911;
        String monthDayStr = rocStr.substring(3);
        String dateString = String.format("%d-%s-%s", year, monthDayStr.substring(0, 2), monthDayStr.substring(2));
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * 格式化當前時間。
     *
     * @param pattern 格式化模式字串，例如："yyyy-MM-dd HH:mm:ss"
     * @return 傳回格式化後的日期時間字串。
     */
    public static String format(String pattern) {
        return DateFormatUtils.format(Calendar.getInstance(), pattern);
    }

    /**
     * 根據提供的日曆實例來格式化日期。
     *
     * @param cal 日曆實例，包含了特定的日期和時間。
     * @param pattern 格式化模式字串，例如："yyyy-MM-dd HH:mm:ss"
     * @return 傳回格式化後的日期時間字串。
     */
    public static String format(Calendar cal, String pattern) {
        return DateFormatUtils.format(cal, pattern);
    }

    /**
     * 根據提供的日期實例來格式化日期。
     *
     * @param date 日期實例。
     * @param pattern 格式化模式字串，例如："yyyy-MM-dd HH:mm:ss"
     * @return 傳回格式化後的日期時間字串。
     */
    public static String format(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 根據提供的毫秒數來格式化日期。
     *
     * @param millis 從1970年1月1日00:00:00 GMT算起的毫秒數。
     * @param pattern 格式化模式字串，例如："yyyy-MM-dd HH:mm:ss"
     * @return 傳回格式化後的日期時間字串。
     */
    public static String format(long millis, String pattern) {
        return DateFormatUtils.format(millis, pattern);
    }
}
