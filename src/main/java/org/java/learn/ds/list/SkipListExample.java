package org.java.learn.ds.list;

/**
 * @author duqi
 * @createTime 2018/11/4 4:14 PM
 **/
public class SkipListExample {

    public static void main(String[] args) {
        SkipList<Integer> skipList = new SkipList<>();
        skipList.insert(10);
        skipList.insert(80);
        skipList.insert(90);
        skipList.insert(1);
        skipList.insert(79);
        skipList.insert(77);
        skipList.insert(19999);

        System.out.println(skipList.contains(80));
        System.out.println(skipList.contains(12));

        skipList.print();
    }
}
