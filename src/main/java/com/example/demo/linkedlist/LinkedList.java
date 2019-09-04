package com.example.demo.linkedlist;

public class LinkedList {

	private Node head;
	
	// insert in linked list will by default insert it at the end position
	public void insert(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(null == head){
			head = node;
		} else {
			Node n = head;
			
			while(n.next != null){
				n = n.next;
			}
			n.next = node;
		}
	}
	
	public void show() {
		Node node = head;
		
		while(node.next != null) {
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println("Final element: " + node.data);
	}

	public void insertAt(int index, int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(index == 0){
			insertAtStart(data);
		} else {
			Node n = head;
			for(int i = 0; i < index-1; i++) {
				n = n.next;
			}
			node.next = n.next;
			n.next = node;
			
		}
	}

	public void insertAtStart(int data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		head = node;
	}
}
