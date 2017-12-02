package org.java.learn.generics;

import org.java.learn.generics.coffee.Coffee;
import org.java.learn.generics.coffee.CoffeeGenerator;
import org.java.learn.util.Generator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 作用: User: duqi Date: 2017/12/2 Time: 14:58
 */
public class Generators {

    /**
     * 泛型方法的定义格式——将泛型参数列表放在方法的返回值左面
     */
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffees = fill(new ArrayList<>(), new CoffeeGenerator(), 4);
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }

        Collection<Integer> numers = fill(new ArrayList<>(), new Fibonacci(), 12);
        for (int i : numers) {
            System.out.print(i + " ");
        }
    }
}
