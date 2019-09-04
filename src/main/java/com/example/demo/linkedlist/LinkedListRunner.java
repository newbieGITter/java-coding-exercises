package com.example.demo.linkedlist;


public class LinkedListRunner {
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(11);
		list.insert(33);
		list.insert(22);
		list.insert(44);
		
		list.insertAt(2, 55);
		
		list.insertAtStart(99);
		
		list.show();		
	}
	

}
