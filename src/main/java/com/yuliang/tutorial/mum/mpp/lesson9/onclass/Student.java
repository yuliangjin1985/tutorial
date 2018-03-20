package com.yuliang.tutorial.mum.mpp.lesson9.onclass;

import java.util.Arrays;
import java.util.List;

public class Student {

    private Score[] scores;

    public Student(Score[] scores) {
        this.scores = scores;
    }

    public Score[] getScores() {
        return scores;
    }

    public static void main(String[] args) {
        Score[] scores1 = {
                new Score(12),
                new Score(13),
                new Score(14),
                new Score(15),
        };
        Score[] scores2 = {
                new Score(16),
                new Score(17),
                new Score(18),
                new Score(19),
        };

        List<Student> students = Arrays.asList(new Student(scores1), new Student(scores2));

        students.stream()
                .flatMap(student -> Arrays.stream(student.getScores()))
                .map(score -> score.getScore())
                .forEach(System.out::println);
    }
}
