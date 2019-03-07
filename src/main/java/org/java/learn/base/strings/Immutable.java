package org.java.learn.base.strings;

/**
 * @author duqi
 * @createTime 2019-02-24 11:45
 **/
public class Immutable {

    public static String upcase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";
        System.out.println(q);
        String qq = upcase(q);
        System.out.println(qq);
        System.out.println(q);
    }
}
