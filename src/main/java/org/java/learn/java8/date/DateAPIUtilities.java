package org.java.learn.java8.date;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Java 8的日期API提供的工具类
 *
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/12/18
 * Time: 21:22
 */
public class DateAPIUtilities {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        //获得年份，并校验今年是否是闰年
        System.out.println("Year: " + today.getYear() + " is a Leap year?" + today.isLeapYear());

        //给定一个日期，判断今天的日期在这个日期之前还是之后
        System.out.println("Today is before 01/01/2015?" + today.isBefore(LocalDate.of(2015, 1, 1)));

        //根据LocalDate对象创建LocalDateTime对象
        System.out.println("Current time:" + today.atTime(LocalTime.now()));

        //日期的加减操作
        System.out.println("10 days after today will be:" + today.plusDays(10));
        System.out.println("3 weeks after today will be:" + today.plusWeeks(3));
        System.out.println("12 months after today will be:" + today.plusMonths(12));

        System.out.println("10 days before today was:" + today.minusDays(10));
        System.out.println("3 weeks before today was" + today.minusWeeks(3));
        System.out.println("12 months before today was:" + today.minusMonths(12));

        //Temporal adjusters for adjusting the dates
        System.out.println("First day of this month:" + today.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDayOfthisyear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last date of this year:" + lastDayOfthisyear);

        Period period = today.until(lastDayOfthisyear);
        System.out.println("Period format=" + period);
        System.out.println("months remaining in this year:" + period.getMonths());
        System.out.println("days remaining in this year:" + period.getDays());
    }
}
