package org.java.learn.collection;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duqi
 * @createTime 2018-11-30 14:36
 **/
public class StreamDebug {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(1980);
        integerList.add(2001);
        integerList.add(800);

        List<Integer> newList = integerList.stream()
                .sorted()
                .filter(integer -> integer > 200).collect(Collectors.toList());

        System.out.println(newList.size());
    }
}
