package org.java.learn.generics;

/**
 * 作用: User: duqi Date: 2017/11/19 Time: 15:45
 */
public class Holder2 {

    private Object a;

    public Holder2(Object a) {
        this.a = a;
    }

    public void setA(Object a) {
        this.a = a;
    }

    public Object getA() {
        return a;
    }

    public static void main(String[] args) {
        Holder2 h2 = new Holder2(new Automobile());
        Automobile automobile = (Automobile) h2.getA();

        h2.setA("Not a Automobile");
        String s = (String) h2.getA();

        h2.setA(1); //这里发生了自动装箱
        Integer x = (Integer) h2.getA();
    }
}
