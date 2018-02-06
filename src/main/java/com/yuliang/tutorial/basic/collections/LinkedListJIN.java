package com.yuliang.tutorial.basic.collections;

import java.util.AbstractSequentialList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListJIN<E> extends AbstractSequentialList<E>{

    transient int size;
    transient Node<E> head;
    transient Node<E> tail;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public LinkedListJIN() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public void put(E value) {
        final Node<E> l = tail;
        final Node<E> newNode = new Node<>(value, l, null);
        tail = newNode;

        if ( null == l) {
            head = newNode;
        } else {
            l.post = newNode;
        }
        size++;
    }

    public String toString() {
        String str = "";
        Node<E> node = head;
        while (node != null) {
            if (node.post != null) {
                str += node.item.toString() + ",";
            } else {
                str += node.item.toString();
            }
        }
        return str;
    }

    private static class Node<E> {
        E item;
        Node<E> pre;
        Node<E> post;

        public Node(E item, Node<E> pre, Node<E> post) {
            this.item = item;
            this.pre = pre;
            this.post = post;
        }

        public Node() {
        }
    }

    public static void main(String[] args) {
        LinkedListJIN<String> list = new LinkedListJIN<>();
        list.put("hive");
        System.out.println(list.toString());

//        LinkedList<String> strings = new LinkedList<>();
//        strings.add("hive");
//        System.out.println(strings.toString());
    }

}
