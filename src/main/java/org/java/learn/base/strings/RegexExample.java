package org.java.learn.base.strings;

/**
 * @author duqi
 * @createTime 2019-03-06 19:51
 **/
public class RegexExample {

    public static void main(String[] args) {
        String str = "com.adu.test.freeeddss(JJ)Ljavax";

        System.out.println(str.replaceAll(".*?(", "duqi"));
    }
}
