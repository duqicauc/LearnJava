package org.java.learn.base.strings;

/**
 * @author duqi
 * @createTime 2019-03-06 19:09
 **/
public class StringSEAPIExample {

    public static void main(String[] args) {
        String sourceStr = "http://mp.weixin.com/test/xxxxx/123.jpg?xxx=yyy";
        String targetReplaceUrl = "TARGET_REPLACE_URL";

        String res1 = sourceStr.replaceAll(targetReplaceUrl, targetReplaceUrl);
        System.out.println("启用正则的结果:" + res1);

        sourceStr = "http://mp.weixin.com/test/xxxxx/123.jpg?xxx=yyy";
        targetReplaceUrl = "REPLACE_URL";
        String res2 = sourceStr.replace(sourceStr, targetReplaceUrl);
        System.out.println("字面匹配的结果：" + res2);
    }
}
