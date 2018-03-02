package com.yuliang.tutorial.mum.mpp.lesson2.assignment.prob2A.ext;


import com.yuliang.tutorial.mum.mpp.lesson2.assignment.prob2A.GradeReport;
import com.yuliang.tutorial.mum.mpp.lesson2.assignment.prob2A.Student;

public class MainClass {
    public static void main(String[] args) {

        //Whenever an instance of Student is created, an instance of GradeReport is also created.
        //If class A holds 1-1 relationship with class B, it means both instances of A and B must hold an
        //instance of the other class.

        Student leo = new Student("leo");
        System.out.println(leo);


        GradeReport gradeReport = leo.getGradeReport();
        Student student = gradeReport.getStudent();

        //student and leo are actually the same instance
        System.out.println(student.equals(leo));
        System.out.println(student==leo);


    }
}
