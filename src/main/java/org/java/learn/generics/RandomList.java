package org.java.learn.generics;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 作用: 持有特定类型对象的列表,select()方法可以随机取一个元素
 * User: duqi
 * Date: 2017/11/19
 * Time: 17:08
 */
public class RandomList<T> {

    private List<T> storage = new ArrayList<>();

    public void add(T item) {
        storage.add(item);
    }
    public T select() {
        return storage.get(RandomUtils.nextInt(0, storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> randomStrings = new RandomList<>();
        for (String s: "永和大王 拌川王 五芳斋 煲仔饭 杭味面馆 麻辣烫".split(" ")) {
            randomStrings.add(s);
        }
        for (int i = 0; i < randomStrings.storage.size(); i++) {
            System.out.print(randomStrings.select() + " ");
        }
    }
}
