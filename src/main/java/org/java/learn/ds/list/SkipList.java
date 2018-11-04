package org.java.learn.ds.list;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author duqi
 * @createTime 2018/11/2 3:52 PM
 **/
public class SkipList<T extends Comparable<? super T>> {

    private class SkipNode<T extends Comparable<? super T>> {
        private SkipNode[] next;
        private T value;

        public SkipNode(T value, int level) {
            this.value = value;
            this.next = new SkipNode[level];
        }
    }

    public void insert(T value) {
        int level = 0;
        for (int item = RandomUtils.nextInt(0, 33); (item & 1) == 1; item >>= 1) {
            level++;
            if (level == levels) {
                levels++;
                break;
            }
        }

        SkipNode newNode = new SkipNode(value, level + 1);
        SkipNode cur = head;
        for (int i = levels - 1; i >= 0; i--) {
            for (; cur.next[i] != null; cur = cur.next[i]) {
                if (cur.next[i].value.compareTo(value) > 0) {
                    break;
                }
            }

            if (i <= level) {
                newNode.next[i] = cur.next[i];
                cur.next[i] = newNode;
            }
        }
    }

    public boolean remove(T value) {
        SkipNode cur = head;
        boolean found = false;
        for (int i = levels; i >= 0; i++) {
            for (; cur.next[i] != null; cur = cur.next[i]) {
                if (cur.next[i].value.compareTo(value) == 0) {
                    found = true;
                    cur.next[i] = cur.next[i].next[i];
                    break;
                }
            }
        }
        return found;
    }

    public boolean contains(T value) {
        SkipNode cur = head;
        for (int i = levels - 1; i >= 0; i--) {
            for (; cur.next[i] != null; cur = cur.next[i]) {
                if (cur.next[i].value.compareTo(value) > 0)
                    break;
                if (cur.next[i].value.compareTo(value) == 0)
                    return true;
            }
        }
        return false;
    }

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        SkipNode cur = head.next[0];
        while (cur != null) {
            stringBuilder.append(cur.value);
            cur = cur.next[0];
            if (cur != null) {
                stringBuilder.append(",");
            }
        }
        System.out.println(stringBuilder.toString());
    }

    @Override
    public String toString() {
        return "SkipList{" +
                "head=" + head +
                ", levels=" + levels +
                '}';
    }

    private SkipNode<T> head = new SkipNode<>(null, 33);
    private int levels = 1;
}
