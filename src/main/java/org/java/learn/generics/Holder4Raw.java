package org.java.learn.generics;


/**
 * 作用: User: duqi Date: 2017/12/5 Time: 21:14
 */
public class Holder4Raw {

    private Object a;
    private Object b;
    private Object c;

    public Holder4Raw(Object a, Object b, Object c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Object getA() {
        return a;
    }

    public Object getB() {
        return b;
    }

    public Object getC() {
        return c;
    }

    public void setA(Object a) {
        this.a = a;
    }

    public void setB(Object b) {
        this.b = b;
    }

    public void setC(Object c) {
        this.c = c;
    }

    public static void main(String[] args) {
        Holder4Raw holder4Raw = new Holder4Raw(new Automobile(),new Automobile(), new Automobile());

        Automobile a = (Automobile) holder4Raw.getA();
        Automobile b = (Automobile) holder4Raw.getB();
        Automobile c = (Automobile) holder4Raw.getC();
    }
}
