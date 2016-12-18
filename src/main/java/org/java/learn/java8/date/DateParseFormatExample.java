package org.java.learn.java8.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 解析和格式化：将一个日期格式转换为不同的格式，之后再解析一个字符串，得到日期时间对象，这些都是很常见的
 *
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/12/18
 * Time: 21:46
 */
public class DateParseFormatExample {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        //默认格式
        System.out.println("Default format of date:" + date);

        //specific format
        System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE)); //基本的ISO日期
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); //本地ISO日期格式（常用）

        LocalDateTime dateTime = LocalDateTime.now();
        //default format
        System.out.println("Default format of LocalDateTime="+dateTime);
        //specific format
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))); //在项目中马上可以用的

        Instant timestamp = Instant.now();
        //default format
        System.out.println("Default format of Instant="+timestamp);

        //Parse examples 27::04::2014 21::39::48可以用，27::Apr::2014 21::39::48不可以用
        LocalDateTime dt = LocalDateTime.parse("27::04::2014 21::39::48",
                                               DateTimeFormatter.ofPattern("d::MM::uuuu HH::mm::ss"));
        System.out.println("Default format after parsing = "+dt);
    }
}
