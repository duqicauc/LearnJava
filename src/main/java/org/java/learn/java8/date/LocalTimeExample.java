package org.java.learn.java8.date;

import java.time.LocalTime;
import java.time.ZoneId;

/**
 * LocalTime是一个不可变的类，它的实例代表一个符合人类可读格式的时间，默认格式是hh:mm:ss.zzz
 *
 * 注意：java.time.DateTimeException，这是一种运行时异常，我们并不需要显式地捕获它
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/12/18
 * Time: 20:58
 */
public class LocalTimeExample {

    public static void main(String[] args) {
        //current time
        LocalTime currentTime = LocalTime.now();
        System.out.println("current time=" + currentTime);

        //根据入参构建LocalTime对象
        LocalTime specificTime = LocalTime.of(21, 2, 10);
        System.out.println("Specific time=" + specificTime);

        //Try creating time by providing invalid inputs
//        LocalTime invalidTime = LocalTime.of(25,20);
        //Exception in thread "main" java.time.DateTimeException:
        //Invalid value for HourOfDay (valid values 0 - 23): 25

        //获取某个时区的当前时间，根据ZoneId提取指定的时区ID，具体参见Java文档
        LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Time in IST="+timeKolkata);

        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //LocalTime todayIST = LocalTime.now(ZoneId.of("IST"));

        //获取从某个时间开始过了几秒后的时间
        LocalTime specificSecondsTime = LocalTime.ofSecondOfDay(7200);
        System.out.println("10000th second from 01/01/1970 00-00-00. " + specificSecondsTime);

    }
}