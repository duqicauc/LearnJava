package org.java.learn.generics;

import org.java.learn.util.BasicGenerator;
import org.java.learn.util.Generator;

/**
 * 作用: User: duqi Date: 2017/12/2 Time: 15:11
 */
public class BasicGeneratorDemo {

    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }

        //练习14：不使用create方法，使用显式的构造器
        Generator<CountedObject> generator = new BasicGenerator<>(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }
    }
}
