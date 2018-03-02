package com.yuliang.tutorial.mum.mpp.lesson2.assignment.prob4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Class to create the necessary instances.
public class StudentSectionFactory {

    static List<Student> studentList = new ArrayList<>();
    static List<Section> sections = new ArrayList<>();

    public static List<Student> getStudents() {
        return Collections.unmodifiableList(studentList);
    }
    //Todo: getSections

    public Section createSection(int secNum, String courseName) {
        Section section = new Section();
        ArrayList<TranscriptEntry> entries = new ArrayList<>();
        section.sectionNumber = secNum;
        section.courseName = courseName;
        section.gradeSheet = entries;
        return section;
    }

    public Student createStudent(String id, String name) {
        Student student = new Student();
        ArrayList<TranscriptEntry> entries = new ArrayList<>();
        student.name = name;
        student.grades = entries;
        return student;
    }

    //Create a new TranscriptEntry and add it to the instance of Student and Section
    public void newTranscriptEntry(Student s, Section sect, String grade) {
        TranscriptEntry transcriptEntry = new TranscriptEntry();
        transcriptEntry.grade = grade;
        transcriptEntry.student = s;
        transcriptEntry.section = sect;
        s.grades.add(transcriptEntry);
        sect.gradeSheet.add(transcriptEntry);
    }
}
