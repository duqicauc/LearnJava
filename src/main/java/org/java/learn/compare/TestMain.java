package org.java.learn.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/10/13
 * Time: 17:27
 */
public class TestMain {

    public static void main(String[] args) {

        List<ObjectToSort> list = new ArrayList();
        list.add(new ObjectToSort(100, "duqi"));
        list.add(new ObjectToSort(200, "test"));
        list.add(new ObjectToSort(400, "ddd"));
        list.add(new ObjectToSort(50, "yiwen"));

        for (ObjectToSort aList : list) {
            System.out.println(aList.getName());
        }
        System.out.println("________+++++++++++++");
        Collections.sort(list);
        for (ObjectToSort aList : list) {
            System.out.println(aList.getName());
        }
    }
}
