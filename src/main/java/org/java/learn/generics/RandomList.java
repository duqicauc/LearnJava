package org.java.learn.generics;

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

    private ArrayList<T> storage = new ArrayList<>();

    private Random random = new Random(47);

    public void add(T item) {
        storage.add(item);
    }
    public T select() {
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<>();
        for (String s: "The queick brown for jumped over the lazy brown dog".split(" ")) {
            randomList.add(s);
        }
        for (int i = 0; i < 11; i++) {
            System.out.print(randomList.select() + " ");
        }
    }
}
