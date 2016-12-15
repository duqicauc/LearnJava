package org.java.learn.collection;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/11/10
 * Time: 17:48
 */
public class ARemoveBListExample {

    public static void main(String[] args) {
        Set<String> aSet = new HashSet<>();
        Set<String> bSet = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            String str = UUID.randomUUID().toString();
            aSet.add(str);
            bSet.add(str);
        }

        for (int i = 0; i < 10000000; i++) {
            aSet.add(UUID.randomUUID().toString());
        }

        //求A集合到B集合的差
        long start = System.currentTimeMillis();
//        List<String> result = aSet.parallelStream().filter(a -> !bSet.contains(a)).collect(Collectors.toList());
        aSet.removeIf(a -> bSet.contains(a));
        long end = System.currentTimeMillis();
        System.out.println("cost: " + (end-start) + "ms, result size:" + aSet.size());
    }
}
