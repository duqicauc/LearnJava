package org.java.learn.generics;

/**
 * 作用: User: duqi Date: 2017/11/19 Time: 15:48
 */
public class Holder3<T> {

    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public static void main(String[] args) {
        Holder3<Automobile> h3 = new Holder3<>(new Automobile());
        Automobile automobile = h3.getA(); //这里不需要强制转换类型

//        h3.setA("Not an Automobile");  Error
//        h3.setA(1);                    Error
    }
}
