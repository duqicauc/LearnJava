package org.java.learn.collection;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * 作用:
 * User: duqi
 * Date: 2017/8/27
 * Time: 16:06
 */
public class HashMapDemo {

    public static void main(String[] args) {
        String key  = "222";

        HashMap temp = new HashMap();
        temp.put(key, null);
        System.out.println(temp.get(key));

        Hashtable temp2 = new Hashtable();
        temp2.put(key, null);
        System.out.println(temp2.get(key));
    }
}
