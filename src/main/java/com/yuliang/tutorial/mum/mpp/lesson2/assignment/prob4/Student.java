package com.yuliang.tutorial.mum.mpp.lesson2.assignment.prob4;

import java.util.List;

public class Student {
	String name;
	List<TranscriptEntry> grades;
	
	public Transcript getTranscript() {
		return new Transcript(grades, this);
		
	}
	
}
