package com.example.demo.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TimeUtil {
    public static final String YYYYMMDD = "yyyy-MM-dd";
    public static final String yyyy_MM_dd = "yyyy/MM/dd";
    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String MMDDHHMMSS = "MM-dd HH:mm:ss";
    public static final String YYYYMMDDHHMMSS_NO_SPACER = "yyyyMMddHHmmss";
    public static final String ASIA_SHANGHAI = "Asia/Shanghai";
    public static final Integer ASIA_SHANGHAI_ZONE = 8;

    private TimeUtil() {
    }

    /**
     * 时间格式化
     * 范例:yyyy-MM-dd HH:mm:ss
     */
    public static String formatTime(String format, Long timestamp) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ASIA_SHANGHAI));
        return dateTimeFormatter.format(localDateTime);
    }

    /**
     * 时间字符串格式化
     */
    public static long formatString(String format, String timeString) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = LocalDate.parse(timeString, dateTimeFormatter);
        LocalTime localTime = LocalTime.of(0, 0, 0);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Instant todayStartTime = localDateTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return todayStartTime.toEpochMilli();
    }

    /**
     * 获取当前的毫秒
     */
    public static long nowTime() {
        return LocalDateTime.now().atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant().toEpochMilli();
    }

    /**
     * 获取今天开始的时间戳
     */
    public static long todayStartTime() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.of(0, 0, 0);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Instant todayStartTime = localDateTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return todayStartTime.toEpochMilli();
    }

    /**
     * 获取今天结束的时间戳
     */
    public static long todayEndTime() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.of(23, 59, 59);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Instant todayEndTime = localDateTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return todayEndTime.toEpochMilli();
    }

    /**
     * 获取指定期当天开始的时间戳
     */
    public static Long dayStartTime(long dayStamp) {
        Instant instant = Instant.ofEpochMilli(dayStamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ASIA_SHANGHAI));
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = LocalTime.of(0, 0, 0);
        LocalDateTime dayEndTime = LocalDateTime.of(localDate, localTime);
        Instant instantDayEndTime = dayEndTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return instantDayEndTime.toEpochMilli();
    }

    /**
     * 获取指定期当天结束的时间戳
     */
    public static Long dayEndTime(long dayStamp) {
        Instant instant = Instant.ofEpochMilli(dayStamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ASIA_SHANGHAI));
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = LocalTime.of(23, 59, 59);
        LocalDateTime dayEndTime = LocalDateTime.of(localDate, localTime);
        Instant instantDayEndTime = dayEndTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return instantDayEndTime.toEpochMilli();
    }

    /**
     * 获取今年年份
     */
    public static int getThisYear() {
        LocalDate localDate = LocalDate.now();
        return localDate.getYear();
    }

    /**
     * 获取毫秒时间戳的年份
     */
    public static int getYear(long time) {
        // 将时间戳转为当前时间
        LocalDateTime localDate = LocalDateTime.ofEpochSecond(time / 1000, 0, ZoneOffset.ofHours(ASIA_SHANGHAI_ZONE));
        return localDate.getYear();
    }

    /**
     * 获取年初时间戳
     *
     * @param year 年
     */
    public static Long getYearBegin(int year) {
        LocalDateTime localDateTime = LocalDateTime.of(year, Month.JANUARY, 1, 0, 0, 0);
        Instant instantFirstDayOfYear = localDateTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return instantFirstDayOfYear.toEpochMilli();
    }

    /**
     * 获取年末时间戳
     *
     * @param year 年
     */
    public static Long getYearEnd(int year) {
        LocalDateTime localDateTime = LocalDateTime.of(year, Month.DECEMBER, 31, 23, 59, 59);
        Instant instantLastDayOfYear = localDateTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return instantLastDayOfYear.toEpochMilli();
    }

    /**
     * 获取月初时间戳
     *
     * @param yearStamp 时间戳
     */
    public static Long getYearBegin(long yearStamp) {
        Instant instant = Instant.ofEpochMilli(yearStamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ASIA_SHANGHAI));
        LocalDate localDate = localDateTime.toLocalDate();
        LocalDate toLocalDate = localDate.with(TemporalAdjusters.firstDayOfYear());
        LocalTime localTime = LocalTime.of(0, 0, 0);
        LocalDateTime dayEndTime = LocalDateTime.of(toLocalDate, localTime);
        Instant instantYearBegin = dayEndTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return instantYearBegin.toEpochMilli();
    }

    /**
     * 获取月末时间戳
     *
     * @param yearStamp 时间戳
     */
    public static Long getYearEnd(long yearStamp) {
        Instant instant = Instant.ofEpochMilli(yearStamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ASIA_SHANGHAI));
        LocalDate localDate = localDateTime.toLocalDate();
        LocalDate toLocalDate = localDate.with(TemporalAdjusters.lastDayOfYear());
        LocalTime localTime = LocalTime.of(23, 59, 59);
        LocalDateTime dayEndTime = LocalDateTime.of(toLocalDate, localTime);
        Instant instantYearEnd = dayEndTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return instantYearEnd.toEpochMilli();
    }

    /**
     * 获取今月月份
     */
    public static int getThisMonth() {
        LocalDate localDate = LocalDate.now();
        return localDate.getMonthValue();
    }

    public static int getMonth(long time) {
        // 将时间戳转为当前时间
        LocalDateTime localDate = LocalDateTime.ofEpochSecond(time / 1000, 0, ZoneOffset.ofHours(ASIA_SHANGHAI_ZONE));
        return localDate.getMonth().getValue();
    }

    /**
     * 获取月初时间戳
     *
     * @param monthStamp 时间戳
     */
    public static Long getMonthBegin(long monthStamp) {
        Instant instant = Instant.ofEpochMilli(monthStamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ASIA_SHANGHAI));
        LocalDate localDate = localDateTime.toLocalDate();
        LocalDate toLocalDate = localDate.with(TemporalAdjusters.firstDayOfMonth());
        LocalTime localTime = LocalTime.of(0, 0, 0);
        LocalDateTime dayEndTime = LocalDateTime.of(toLocalDate, localTime);
        Instant instantMonthBegin = dayEndTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return instantMonthBegin.toEpochMilli();
    }

    /**
     * 获取月末时间戳
     *
     * @param monthStamp 时间戳
     */
    public static Long getMonthEnd(long monthStamp) {
        Instant instant = Instant.ofEpochMilli(monthStamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ASIA_SHANGHAI));
        LocalDate localDate = localDateTime.toLocalDate();
        LocalDate toLocalDate = localDate.with(TemporalAdjusters.lastDayOfMonth());
        LocalTime localTime = LocalTime.of(23, 59, 59);
        LocalDateTime dayEndTime = LocalDateTime.of(toLocalDate, localTime);
        Instant instantMonthEnd = dayEndTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return instantMonthEnd.toEpochMilli();
    }

    /**
     * 获取月初时间戳
     *
     * @param year  年份
     * @param month 月份
     */
    public static Long getMonthBegin(int year, int month) {
        LocalDate localDate = LocalDate.of(year, month, 1);
        LocalTime localTime = LocalTime.of(0, 0, 0);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Instant instantMonthBegin = localDateTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return instantMonthBegin.toEpochMilli();
    }

    /**
     * 获取月末时间戳
     *
     * @param year  年份
     * @param month 月份
     */
    public static Long getMonthEnd(int year, int month) {
        LocalDate localDate = LocalDate.of(year, month, 1);
        LocalDate toLocalDate = localDate.with(TemporalAdjusters.lastDayOfMonth());
        LocalTime localTime = LocalTime.of(23, 59, 59);
        LocalDateTime dayEndTime = LocalDateTime.of(toLocalDate, localTime);
        Instant instantMonthEnd = dayEndTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return instantMonthEnd.toEpochMilli();
    }

    public static Long getMonthDate(int year, int month, int day) {
        LocalDate localDate = LocalDate.of(year, month, day);
        LocalTime localTime = LocalTime.of(0, 0, 0);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Instant instantMonthBegin = localDateTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return instantMonthBegin.toEpochMilli();
    }


    /**
     * 获取指定某一天的开始时间戳
     *
     * @param timeStamp 毫秒级时间戳
     */
    public static Long getDailyStartTime(Long timeStamp) {
        Instant instant = Instant.ofEpochMilli(timeStamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ASIA_SHANGHAI));
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = LocalTime.of(0, 0, 0, 0);
        LocalDateTime dayStartTime = LocalDateTime.of(localDate, localTime);
        Instant instantDayBegin = dayStartTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return instantDayBegin.toEpochMilli();
    }

    /**
     * 获取指定某一天的结束时间戳
     */
    public static Long getDailyEndTime(Long timeStamp) {
        Instant instant = Instant.ofEpochMilli(timeStamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ASIA_SHANGHAI));
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = LocalTime.of(23, 59, 59, 999);
        LocalDateTime dayEndTime = LocalDateTime.of(localDate, localTime);
        Instant instantDayEnd = dayEndTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return instantDayEnd.toEpochMilli();
    }

    /**
     * 获取上个月指定某一天的开始时间戳
     */
    public static Long getLastMonthDay(Long timeStamp, Integer day) {
        Instant instant = Instant.ofEpochMilli(timeStamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ASIA_SHANGHAI));
        LocalDate localDate = LocalDate.of(localDateTime.getYear(), localDateTime.getMonthValue(), day);
        LocalDate lastMonthDate = localDate.minusMonths(1);
        LocalTime localTime = LocalTime.of(0, 0, 0, 0);
        LocalDateTime dayEndTime = LocalDateTime.of(lastMonthDate, localTime);
        Instant lastMonthDay = dayEndTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return lastMonthDay.toEpochMilli();
    }

    /**
     * 获取本月指定某一天的开始时间戳
     */
    public static Long getThisMonthDay(Long timeStamp, Integer day) {
        Instant instant = Instant.ofEpochMilli(timeStamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ASIA_SHANGHAI));
        LocalDate localDate = LocalDate.of(localDateTime.getYear(), localDateTime.getMonthValue(), day);
        LocalTime localTime = LocalTime.of(0, 0, 0, 0);
        LocalDateTime dayEndTime = LocalDateTime.of(localDate, localTime);
        Instant thisMonthDay = dayEndTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return thisMonthDay.toEpochMilli();
    }

    /**
     * 获取下月指定某一天的开始时间戳
     */
    public static Long getNextMonthDay(Integer year, Integer month, Integer day) {
        LocalDate localDate = LocalDate.of(year, month, day);
        LocalTime localTime = LocalTime.of(0, 0, 0, 0);
        LocalDate lastMonthDate = localDate.plusMonths(1);
        LocalDateTime dayEndTime = LocalDateTime.of(lastMonthDate, localTime);
        Instant thisMonthDay = dayEndTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return thisMonthDay.toEpochMilli();
    }

    /**
     * 获取当前时间前x天的开始时间戳
     */
    public static Long getPreDaysStartTime(int days) {
        LocalDate localDate = LocalDate.now().minusDays(days);
        LocalTime localTime = LocalTime.of(0, 0, 0);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Instant todayStartTime = localDateTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return todayStartTime.toEpochMilli();
    }

    /**
     * 获取当前时间前x天的结束时间戳
     */
    public static Long getPreDaysEndTime(int days) {
        LocalDate localDate = LocalDate.now().minusDays(days);
        LocalTime localTime = LocalTime.of(23, 59, 59);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Instant todayStartTime = localDateTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return todayStartTime.toEpochMilli();
    }

    /**
     * 获取当前时间前x个月的月初时间戳
     */
    public static Long getPreMonthsStartTime(int months) {
        LocalDate localDate = LocalDate.now().minusMonths(months).with(TemporalAdjusters.firstDayOfMonth());
        LocalTime localTime = LocalTime.of(0,0,0);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Instant monthStartTime = localDateTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return monthStartTime.toEpochMilli();
    }

    /**
     * 获取当前时间前x个月的月末时间戳
     */
    public static Long getPreMonthsEndTime(int months) {
        LocalDate localDate = LocalDate.now().minusMonths(months).with(TemporalAdjusters.lastDayOfMonth());
        LocalTime localTime = LocalTime.of(0,0,0);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Instant monthStartTime = localDateTime.atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant();
        return monthStartTime.toEpochMilli();
    }

    /**
     * 获取一段时间范围内每天的起始时间戳集合
     */
    public static List<Long> getMeetDayTimestamp(Long startTimestamp, Long endTimestamp) {
        List<Long> timeStamps = new ArrayList<>();
        LocalDate startDate = getTimestamp2LocalDate(startTimestamp);
        LocalDate endDate = getTimestamp2LocalDate(endTimestamp);
        long distance = ChronoUnit.DAYS.between(startDate, endDate);
        List<LocalDate> localDates = Stream.iterate(startDate, d -> d.plusDays(1))
                .limit(distance + 1)
                .collect(Collectors.toList());
        localDates.forEach(localDate -> timeStamps.add(getLocalDate2Timestamp(localDate)));
        return timeStamps;
    }

    /**
     * 获取一段时间范围内符合星期几的时间戳集合
     * @param startTimestamp 开始时间戳
     * @param endTimestamp 结束时间戳
     * @param date 周几：1, 2, 3, 4, 5, 6, 7
     * @return 时间范围内符合星期几的起始时间戳集合
     */
    public static List<Long> getMeetDayOfWeekTimestamp(Long startTimestamp, Long endTimestamp, int date) {
        List<Long> timeStamps = new ArrayList<>();
        LocalDate startDate = getTimestamp2LocalDate(startTimestamp);
        LocalDate endDate = getTimestamp2LocalDate(endTimestamp);
        long distance = ChronoUnit.DAYS.between(startDate, endDate);
        List<LocalDate> localDates = Stream.iterate(startDate, d -> d.plusDays(1))
                .limit(distance + 1)
                .filter(localDate -> localDate.getDayOfWeek().equals(DayOfWeek.of(date)))
                .collect(Collectors.toList());
        localDates.forEach(localDate -> timeStamps.add(getLocalDate2Timestamp(localDate)));
        return timeStamps;
    }

    /**
     * 获取一段时间范围内包含月份时间戳集合
     * @param startTimestamp 开始时间戳
     * @param endTimestamp 结束时间戳
     * @return 时间范围内包含月份起始时间戳集合
     */
    public static List<Long> getMeetMothTimestamp(Long startTimestamp, Long endTimestamp) {
        List<Long> timeStamps = new ArrayList<>();
        LocalDate startDate = getTimestamp2LocalDate(getMonthBegin(startTimestamp));
        LocalDate endDate = getTimestamp2LocalDate(getMonthBegin(endTimestamp));
        long distance = ChronoUnit.MONTHS.between(startDate, endDate);
        List<LocalDate> localDates = Stream.iterate(startDate, d -> d.plusMonths(1))
                .limit(distance + 1)
                .collect(Collectors.toList());
        localDates.forEach(localDate -> timeStamps.add(getMonthBegin(getLocalDate2Timestamp(localDate))));
        return timeStamps;
    }

    /**
     * 获取指定时间所在周的周x的起始时间戳
     * @param timestamp 指定时间戳
     * @param workDate 周x，1,2,3,4,5,6,7
     * @return 指定时间所在周的周x的起始时间戳
     */
    public static Long getWeekTimestamp(Long timestamp, int workDate) {
        LocalDate localDate = TimeUtil.getTimestamp2LocalDate(timestamp).with(DayOfWeek.of(workDate));
        return TimeUtil.getLocalDate2Timestamp(localDate);
    }

    /**
     * 时间戳转成LocalDate类型
     */
    public static LocalDate getTimestamp2LocalDate(Long timestamp) {
       return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * LocalDate类型转成时间戳
     */
    public static Long getLocalDate2Timestamp(LocalDate localDate) {
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
