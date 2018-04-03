package org.java.learn.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * foreach和for的区别：http://www.cnblogs.com/hnrainll/archive/2011/11/13/2247422.html
 * User: duqi
 * Date: 2018/4/3
 * Time: 22:45
 */
public class RemoveArrayListDemo {

    public static void main(String[] args) {
        List<Long> tempList = new ArrayList<>();
        tempList.add(1L);
        tempList.add(2L);
        tempList.add(3L);

        for (Long t: tempList) {
            tempList.remove(t);
        }

        System.out.println(tempList.size());
    }
}
