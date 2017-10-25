package org.java.learn.jvm.classloading;

/**
 * 作用: 对于静态字段，只有直接定义这个字段的类才会被初始化，因此通过其子类引用
 * 父类中定义的静态字段，只会触发父类的初始化
 *
 * User: duqi
 * Date: 2017/9/2
 * Time: 11:05
 */
public class NotInitialization {

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
