//package org.java.learn.generics;
//
///**
// * 作用: User: duqi Date: 2017/12/9 Time: 19:45
// */
//public class Erased<T> {
//
//    public static void f(Object[] args) {
//        //（1）不能在类型参数上使用instanceof操作, instanceof右边必须是某个原生类型或数组
//        if (args instanceof T) {}
//
//        //（2）不能直接实例化类型参数
//        T var = new T();
//
//        //（3）不能这么定义泛型数组，原因同上
//        T[] array = new T[100];
//
//        //（4）先定义一个Object数组，再强转成T[]数组，绕过泛型检查，但是会收到一个告警
//        T[] array2 = (T[])new Object[100];
//    }
//}
