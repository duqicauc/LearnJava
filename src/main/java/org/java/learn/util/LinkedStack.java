package org.java.learn.util;

/**
 * 作用: User: duqi Date: 2017/11/19 Time: 16:40
 */
public class LinkedStack<T> {

    private static class Node<U> {
        U item;
        Node<U> next;

        public Node() {
            item = null;
            next = null;
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        /**
         * 是否到达堆栈底部
         *
         * @return
         */
        boolean end() {
            return item == null || next == null;
        }
    }

    /**
     * 末端哨兵
     */
    private Node<T> top = new Node<>();
    public void push(T item) {
        top = new Node<>(item, top);
    }
    public T pop() {
        T res = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for (String s: "Phasers on stun!".split(" ")) {
            lss.push(s);
        }
        String s;
        while ((s = lss.pop()) != null) {
            System.out.println(s);
        }
    }
}
