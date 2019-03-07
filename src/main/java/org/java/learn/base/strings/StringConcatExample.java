package org.java.learn.base.strings;

/**
 * @author duqi
 * @createTime 2019-02-28 22:33
 **/
public class StringConcatExample {

    public static void main(String[] args) {
        long s1 = System.currentTimeMillis();
        new StringConcatExample().implicit();
        System.out.println("使用\"+\"拼接:" + (System.currentTimeMillis() - s1));

        s1 = System.currentTimeMillis();
        new StringConcatExample().exlicit();
        System.out.println("使用\"StringBuilder\"拼接:" + (System.currentTimeMillis() - s1));
    }

    public String implicit() {
        String result = "";
        for (int i = 0; i < 10000; i++) {
            result += (i + ",");
        }
        return result;
    }

    public String exlicit() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            result.append(i).append(",");
        }
        return result.toString();
    }
}
