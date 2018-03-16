package com.yuliang.tutorial.mum.mpp.lesson8.assignment.labs.prob4;

import java.util.Arrays;
import java.util.List;

public class WordCounter {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("leo", "tom", "hai", "baidu", "wangyi", "tia");
        System.out.println(countWords(strings, 'o', 'a', 3));
    }

    public static int countWords(List<String> words, char c, char d, int len) {
        long count = words.stream()
                .filter(s -> s.length() == len)
                .filter(s -> s.contains("" + c))
                .filter(s -> !s.contains("" + d))
                .count();

        return Math.toIntExact(count);
    }


}
