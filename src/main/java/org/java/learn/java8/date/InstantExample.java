package org.java.learn.java8.date;

import java.time.Duration;
import java.time.Instant;

/**
 *  java.time.Instant：Instant类是用在机器可读的时间格式上的，它以Unix时间戳的形式存储日期时间
 *  用于表示时间戳
 *
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/12/18
 * Time: 21:12
 */
public class InstantExample {

    public static void main(String[] args) {
        //current timestamp。 从1970年1月1日0时0分0秒开始，到现在流失的ms数
        Instant timestamp = Instant.now();
        System.out.println("current timestamp=" + timestamp.toEpochMilli());

        //根据时间戳构建Instant对象
        Instant specificInstant = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Specific time=" + specificInstant);

        //计算指定天数内经历的毫秒数
        Duration thirtyDay = Duration.ofDays(30);
        System.out.println("duration:" + thirtyDay);
        System.out.println("days:" + thirtyDay.toDays());
        System.out.println("hours:" + thirtyDay.toHours());
        System.out.println("mintutes:" + thirtyDay.toMinutes());
        System.out.println("mills:" + thirtyDay.toMillis());
        System.out.println("seconds:" + thirtyDay.getSeconds()); //奇怪的API
    }
}
