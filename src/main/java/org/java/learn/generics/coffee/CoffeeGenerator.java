package org.java.learn.generics.coffee;

import org.apache.commons.lang3.RandomUtils;
import org.java.learn.util.Generator;

import java.util.Iterator;

/**
 * 实现Iterable接口，表示当前类可以用在循环语句中
 *
 * 作用: User: duqi Date: 2017/11/30 Time: 22:58
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};
    private int size = 0;

    public CoffeeGenerator() {
    }

    /**
     * 末端哨兵，在case2中for-each语句中，告诉程序什么时候停止
     * @param size
     */
    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[RandomUtils.nextInt(0, types.length-1)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        /**
         * 内部类可以直接访问外部类的属性
         */
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        //case1：测试CoffeeGenerator的next()方法；
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }

        //case2: 测试在for-each语句中生成对象
        for (Coffee coffee: new CoffeeGenerator(5)) {
            System.out.println(coffee);
        }
    }
}
