package com.yuliang.tutorial.mum.mpp.lesson2.assignment.prob2A;

//Student "owns" 1-1 relationship with GradeReport
public class Student {
    private String name;
    private GradeReport gradeReport;

    public Student(String name) {
        this.name = name;
        gradeReport = new GradeReport(this);
    }

    public String getName() {
        return this.name;
    }

    public GradeReport getGradeReport() {
        return this.gradeReport;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
