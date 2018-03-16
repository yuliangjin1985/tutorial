package com.yuliang.tutorial.mum.mpp.lesson8.assignment.labs.prob3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class ForEachExample {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		//print each element of the list in upper case format
		list.forEach(new CaseConsumer<String>());
	}
	
	//implement a Consumer

	static class CaseConsumer<T> implements Consumer<T> {
		@Override
		public void accept(T t) {

			System.out.println(((String)t).toUpperCase());
		}
	}

}