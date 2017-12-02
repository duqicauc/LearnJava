package org.java.learn.util.tuple;

import org.java.learn.generics.coffee.Breve;
import org.java.learn.generics.coffee.Cappuccino;

import static org.java.learn.util.tuple.Tuple.*;

/**
 * 作用: User: duqi Date: 2017/12/2 Time: 15:24
 */
public class TupleTest {

    static TwoTuple<String, Integer> f() {
        return tuple("hi", 47);
    }

    static TwoTuple f2() {
        return tuple("hi", 47);
    }

    static ThreeTuple<Breve, String, Integer> g() {
        return tuple(new Breve(), "hi", 44);
    }

    static FourTuple<Cappuccino, Breve, String, Integer> h() {
        return tuple(new Cappuccino(), new Breve(), "hi", 447);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        /**
         * 这里没有发出告警，是因为我们将f2()的返回值直接返回，并没有再尝试转为参数化对象；
         */
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());

        /**
         * 练习15：这里尝试将f2的返回值转为一个参数化对象，就收到了报警
         */
        TwoTuple<String, Integer> ttsi2 = f2();
    }
}
