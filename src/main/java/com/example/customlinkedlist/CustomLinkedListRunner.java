package com.example.customlinkedlist;

public class CustomLinkedListRunner {

	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(4);
		list.insert(6);

		list.show();

		list.insertAt(2, 3);
		list.insertAt(4, 5);

		list.show();

		list.insertAt(0, 0);

		list.show();

		list.insertAtStart(10);

		list.show();
		
		list.deleteAt(3);
		
		list.show();
		
		list.deleteAt(0);
		
		list.show();
		
		System.out.println("Element at position 3: " + list.get(3));
		System.out.println("Element at position 4: " + list.get(4));
		System.out.println("Size of linked list is: " + list.size());
	}

}
