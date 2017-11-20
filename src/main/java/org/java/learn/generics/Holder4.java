package org.java.learn.generics;

/**
 * 作用: User: duqi Date: 2017/11/19 Time: 15:51
 */
public class Holder4<T> {

    private T a;
    private T b;
    private T c;

    public Holder4(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public T getA() {
        return a;
    }

    public T getB() {
        return b;
    }

    public T getC() {
        return c;
    }

    public void setA(T a) {
        this.a = a;
    }

    public void setB(T b) {
        this.b = b;
    }

    public void setC(T c) {
        this.c = c;
    }

    public static void main(String[] args) {
        Holder4<Automobile> holder4 = new Holder4<>(new Automobile(),new Automobile(), new Automobile());

        Automobile a = holder4.getA();
        Automobile b = holder4.getB();
        Automobile c = holder4.getC();
    }
}
