package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author wangzhiguo
 */
public class TimeUtil {

    /**
     * LocalDateTime转Date
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime){
        return  Date.from( localDateTime.atZone( ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date转LocalDateTime
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * LocalDate转Date
     */
    public static Date localDate2Date(LocalDate localDate){
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date转LocalDate
     */
    public static LocalDate date2LocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 字符串转LocalDate
     * @param time 时间字符串
     * @param pattern 相应格式
     * @return LocalDate
     */
    public static LocalDate string2LocalDate(String time, String pattern) {
        return LocalDate.parse(time, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 字符串转LocalDateTime
     * @param time 时间字符串
     * @param pattern 相应格式
     * @return LocalDateTime
     */
    public static LocalDateTime string2LocalDateTime(String time, String pattern) {
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern(pattern));
    }

}
