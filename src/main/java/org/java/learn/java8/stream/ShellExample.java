package org.java.learn.java8.stream;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 用JAVA实现SHELL命令cat 1.log | grep a | sort | uniq -c | sort -rn的功能，不需要解析命令，只需要实现命令的功能。
 *
 * @author duqi
 * @createTime 2018-12-21 15:23
 **/
public class ShellExample {

    public static void main(String[] args) throws IOException {
        //cat命令，相当于是读取文件中的所有行，并输出
        File file = new File("/Users/duqi/Code/IdeaProjects/LearnJava/src/main/java/org/java/learn/java8/stream/t1.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<>();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            lines.add(str);
        }

        //grep a，相当于filter
        lines = lines.stream().filter(s -> s.contains("a")).collect(Collectors.toList());

        //sort 按照字典序从小到大排序
        lines = lines.stream().sorted().collect(Collectors.toList());

        //uniq -c，统计相同的元素的个数
        Map<String, Long> integerMap =
                lines.stream().sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //sort -rn，排序后逆序输出
        List<Long> res = integerMap.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        res.forEach(System.out::println);
    }

}
