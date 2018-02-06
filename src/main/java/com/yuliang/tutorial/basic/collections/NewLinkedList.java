package com.yuliang.tutorial.basic.collections;

public class NewLinkedList<E> {

    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node<E> getFirst() {
        return first;
    }

    public void setFirst(Node<E> first) {
        this.first = first;
    }

    public Node<E> getLast() {
        return last;
    }

    public void setLast(Node<E> last) {
        this.last = last;
    }

    public NewLinkedList() {
    }

    public boolean add(E value) {
        linkLast(value);
        return true;
    }

    private void linkLast(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(value, l, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.post = newNode;
        size++;
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
    }

    public static void main(String[] args) {
        NewLinkedList<String> objectNewLinkedList = new NewLinkedList<>();
        objectNewLinkedList.add("hive");
        objectNewLinkedList.add("hive");
        objectNewLinkedList.add("hive");
        objectNewLinkedList.add("hive");
        objectNewLinkedList.add("hive");
        objectNewLinkedList.add("hive");
        System.out.println(objectNewLinkedList);
    }
}
