package org.java.learn.generics;

/**
 * 说明: Holder1这个类，只能持有Automobile类型的对象
 */
public class Holder1 {

    private Automobile a;

    public Holder1(Automobile a) {
        this.a = a;
    }

    public Automobile getA() {
        return a;
    }
}

class Automobile {}
