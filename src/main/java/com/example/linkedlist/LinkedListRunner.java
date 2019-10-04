package com.example.linkedlist;

public class LinkedListRunner {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.insert(11);
		list.insert(22);
		list.insert(44);
		
		list.show();
		
		list.insertAt(2, 33);
		
		list.show();
		
		list.insertAt(0, 01);
		
		list.show();
		
		list.deleteAt(3);
		
		list.show();
		
		list.deleteAt(0);
		
		list.show();
	}

}
