package org.java.learn.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/10/26
 * Time: 17:29
 */
public class SumExample {

    public static void main(String[] args) {
        List<Integer>  list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //计算一个列表的和
        Optional<Integer> res1 = list.stream().reduce(Integer::sum);
        System.out.println(res1.orElse(0));

        //计算一个列表的和
        int res2 = list.stream().reduce(0, Integer::sum);
        System.out.println(res2);

        //计算流中元素的个数
        System.out.println(list.stream().count());
    }

}
