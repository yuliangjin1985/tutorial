package com.yuliang.tutorial.mum.mpp.lesson9.assignment.labs.prob13;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("test", 3);
        List<BookCopy> copies = book.getCopies();
        copies.forEach(bookCopy -> bookCopy.changeAvailability());

        System.out.println(book.isAvailable());
    }
}
