package org.java.learn.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用: User: duqi Date: 2017/12/9 Time: 19:34
 */
public class ListOfInt {

    public static void main(String[] args) {
        //（1）通过自动装包和拆包，在泛型中和基本类型进行交互
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //发生自动装包
            li.add(i);
        }

        //发生自动拆包
        for (int i: li) {
            System.out.println(i);
        }

        //（2）错误示例
//        List<int> list = new ArrayList<>();
    }
}
