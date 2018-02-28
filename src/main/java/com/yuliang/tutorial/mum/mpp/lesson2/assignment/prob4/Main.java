package com.yuliang.tutorial.mum.mpp.lesson2.assignment.prob4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Shows how the design in this package of classes
 *  allows you to navigate in the way that the class
 *  diagram suggests
 */
public class Main {
	static StudentSectionFactory factory = new StudentSectionFactory();
	public static void main(String[] args) {
		Student bob = factory.createStudent("", "Bob");
		Student tim = factory.createStudent("", "Tim");
		Student allen = factory.createStudent("", "Allen");

		Section bio1 = factory.createSection(1, "Biology");
		Section bio2 = factory.createSection(2, "Biology");
		Section math = factory.createSection(3, "Mathematics");

		factory.newTranscriptEntry(bob, bio1, "A");
		factory.newTranscriptEntry(bob, math, "B");
		factory.newTranscriptEntry(tim, bio1, "B+");
		factory.newTranscriptEntry(tim, math, "A-");
		factory.newTranscriptEntry(allen, math, "B");
		factory.newTranscriptEntry(allen, bio2, "B+");

		Main m = new Main();
		System.out.println(m.getTranscript(bob));
		System.out.println("Grades for math section:\n " + m.getGrades(math));
		System.out.println("Courses that Tim took: " + m.getCourseNames(tim));

		List<Student> students = Arrays.asList(bob, tim, allen);
		System.out.println("Students who got A's: " + m.getStudentsWith(students,"A"));
	}
	
	private Transcript getTranscript(Student s) {
		return s.getTranscript();
	}
	private List<String> getCourseNames(Student s) {
		List<TranscriptEntry> all = s.grades;
		List<String> courseNames = new ArrayList<>();
		for(TranscriptEntry te : all) {
			courseNames.add(te.section.courseName);
		}
		return courseNames;
	}
	private List<String> getGrades(Section s) {
		List<String> grades  = new ArrayList<>();
		for(TranscriptEntry t : s.gradeSheet) {
			grades.add(t.grade);
		}
		return grades;
	}
	private List<String> getStudentsWith(List<Student> students, String grade) {
		List<String> studentNames = new ArrayList<>();
		for(Student s : students) {
			boolean found = false;
			for(TranscriptEntry te : s.grades) {
				if(!found) {
					if(te.grade.equals(grade)) {
						found = true;
						studentNames.add(s.name);
					}
				}
			}
		}
		return studentNames;
	}

}
