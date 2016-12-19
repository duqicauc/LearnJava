package org.java.learn.java8.lambda;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 函数式接口, Consumer<T>
 *
 * Represents an operation that accepts a single input argument and returns no
 * result.
 *
 * 代表一个函数，这个函数接受一个输入参数，并且返回结果为void
 *
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/12/19
 * Time: 13:22
 */
public class SystemPrintlnExample {

    public static void main(String[] args) {
        Consumer<String> println = System.out::println;

        println.accept("one"); //针对入参执行该lambda代表的函数

        Stream.of("one", "two", "three").forEach(println); //与stream API结合使用，作为参数传入forEach方法
    }
}
