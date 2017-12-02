package org.java.learn.generics;

import java.util.Iterator;

/**
 * 组合代替继承，实现适配器模式
 *
 * IterableFibonacci2适配Fibonacci为可被循环语句使用的生成器
 *
 * 作用: User: duqi Date: 2017/12/2 Time: 14:08
 */
public class IterableFibonacci2 implements Iterable<Integer> {

    private int n;

    private Fibonacci fibonacci;

    public IterableFibonacci2(int n, Fibonacci fibonacci) {
        this.n = n;
        this.fibonacci = fibonacci;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return fibonacci.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (int i: new IterableFibonacci2(18, new Fibonacci())) {
            System.out.print(i + " ");
        }
    }
}
