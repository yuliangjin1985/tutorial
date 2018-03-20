package com.yuliang.tutorial.mum.mpp.lesson10.labs.prob6;

//Show the methods are not threadsafe.
//Then modify so that they are threadsafe.
public class NotThreadSafeQueue {
	class Node {
		Object value;
		Node next;
	}
	private Node head;
	private Node tail;

	private int counter;
	public void add(Object newValue) {
		counter++;
		Node n = new Node();
		if(head == null) head = n;
		else tail.next = n;
		tail = n;
		tail.value = newValue;
	}
	public Object remove() {
		if(head == null) return null;
		Node n = head;
		head = n.next;
		return n.value;
	}

	public static void main(String[] args) {
		NotThreadSafeQueue queue = new NotThreadSafeQueue();

		for(int i=0;i<5;i++) {
			multipleCalls(queue);
		}

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(queue.counter);
	}

	public static void multipleCalls(NotThreadSafeQueue queue) {
		Runnable task = () -> {
			for(int i=0;i<100; i++) {
				queue.add(i);
			}
		};


		for(int i=0;i<100;i++) {
			new Thread(task).start();
		}
	}
}
