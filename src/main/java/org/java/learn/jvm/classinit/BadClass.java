package org.java.learn.jvm.classinit;

/**
 * 作用:
 * User: duqi
 * Date: 2017/9/2
 * Time: 17:29
 */
public class BadClass {

    private static int a = 100;

    static {
        System.out.println("before init");
        int b = 3 / 0;
        System.out.println("after init");
    }

    public static void doSomething() {
        System.out.println("do somthing");
    }

    public static void main(String args[]){
        try{
            BadClass.doSomething();
        }catch (Throwable e){
            e.printStackTrace();
        }

        BadClass.doSomething();
    }
}
