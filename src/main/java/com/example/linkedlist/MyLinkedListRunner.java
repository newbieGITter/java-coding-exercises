package com.example.linkedlist;

public class MyLinkedListRunner {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		
		list.insert(22);
		list.insert(11);
		list.insert(33);
		list.insert(55);
		
		list.show();
		
		list.insertAtStart(66);		
		System.out.println("After inserting at start");
		
		list.show();
		
		list.insertAt(3, 88);
		
		list.show();
		
		list.insertAt(0, 77);
		
		list.show();
		
		list.deleteAt(3);
		
		list.show();	
		
		list.deleteAt(0);
		
		list.show();
		
		System.out.println("Element at position 2 is:" + Integer.toString(list.get(2)));
		System.out.println("Element at position 4 is:" + Integer.toString(list.get(4)));
	}

}
