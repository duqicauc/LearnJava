package org.java.learn.java8.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

/**
 * 学习Java 8的日期API，参见：http://www.importnew.com/14140.html
 *
 * java.time.LocalDate：LocalDate是一个不可变的类，它表示默认格式(yyyy-MM-dd)的日期
 *
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/12/18
 * Time: 20:41
 */
public class LocalDateExample {

    public static void main(String[] args) {
        //当前日期
        LocalDate today = LocalDate.now();
        System.out.println("Current Date=" + today);

        //根据一定输入创建date对象
        LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
        System.out.println("Specific Date=" + firstDay_2014);

        //Try creating date by providing invalid inputs
//        LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
        //Exception in thread "main" java.time.DateTimeException:
        // Invalid date 'February 29' as '2014' is not a leap year

        //Current Date in "Asia/Kolkata"
        LocalDate kolkataToday = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date in IST = " + kolkataToday);

        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));

        //获取从1970-01-01 开始，x天后的日期
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("365th day from base date=" + dateFromBase);

        //获取某一年的第几天
        LocalDate hundredDayIn2014 = LocalDate.ofYearDay(2014, 100);
        System.out.println("100th day in 2014=" + hundredDayIn2014);

    }
}
