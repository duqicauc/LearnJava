package org.java.learn.concurrent.copyonwritearraylist;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.assertj.core.api.Assertions.*;

/**
 * 作用:
 * User: duqi
 * Date: 2017/11/9
 * Time: 11:20
 */
public class CopyOnWriteArrayListExample {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 78});

        Iterator<Integer> iterator = numbers.iterator();
        numbers.add(100);
        List<Integer> result = new LinkedList<>();
        iterator.forEachRemaining(result::add);
        assertThat(result).containsOnly(1, 3, 5, 78);

        Iterator<Integer> iterator2 = numbers.iterator();
        numbers.remove(3);
        List<Integer> result2 = new LinkedList<>();
        iterator2.forEachRemaining(result2::add);
        assertThat(result2).containsOnly(1, 3, 5, 78, 100);
    }
}
