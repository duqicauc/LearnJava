package org.java.learn.java8;

import java.util.HashMap;
import java.util.function.BiConsumer;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/10/27
 * Time: 14:24
 */
public class BiConsumer_accept {

    private BiConsumer<String, Integer> biConsumer;

    public static void main(String[] args) {
        //BiConsumer是Java 8提供的函数接口，接受两个入参，并执行具体的操作，具体的操作通过accept调用完成
        new BiConsumer_accept().testCase();
    }

    public void testCase() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Java", 8);
        map.put("Csharp", 5);

        //case1: 对于HashMap的每一个键值对执行对应的操作
        biConsumer = new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println("s: " + s + ", integer: " + integer);
            }
        };
        map.forEach(biConsumer);

        //case2: 上述定义可简化为lambda表达式
        map.forEach((s, integer) -> System.out.println("\t>>s: " + s +", integer: " + integer));

        //case3: 可直接传入方法引用，实现策略模式
        biConsumer = this::printKeyAndValue;
        map.forEach(biConsumer);
    }


    private void printKeyAndValue(String s, Integer integer){
        System.out.println("s: " + s + ", integer: " + integer);
    }
}
