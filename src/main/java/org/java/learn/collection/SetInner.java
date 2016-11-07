package org.java.learn.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/11/7
 * Time: 17:04
 */
public class SetInner {

    public static void main(String[] args) {
        Set<String> setA = new HashSet<>();
        setA.add("abc");
        setA.add("abd");
        setA.add("acd");

        Set<String> setB = new HashSet<>();
        setB.add("abc");
        setB.add("acd");

        setA.retainAll(setB);
        System.out.println("A和B的交集：" + setA);

        Set<String> setA1 = new HashSet<>();
        setA1.add("abc");
        setA1.add("abd");
        setA1.add("acd");

        Set<String> setB1 = new HashSet<>();
        setB1.add("abc");
        setB1.add("acd");

        setA1.removeAll(setB1);
        System.out.println("A和B的差集：" + setA1);
    }
}
