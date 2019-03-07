package org.java.learn.base.strings;

/**
 * @author duqi
 * @createTime 2019-02-28 22:59
 **/
public class StringConcatExample2 {

    public static void main(String[] args) {
        System.out.println(new StringConcatExample2().testConcat("abc", null));
        System.out.println(new StringConcatExample2().testConcat2("abc", null));

//        System.out.println(new StringContactExample2().testContact("abc", "ddd"));
//        System.out.println(new StringContactExample2().testContact2("abc", "ddd"));
    }

    public String testConcat(String a, String b) {
        return a += b;
    }

    public String testConcat2(String a, String b) {
        return a.concat(b);
    }

}
