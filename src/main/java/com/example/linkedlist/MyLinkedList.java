package com.example.linkedlist;

public class MyLinkedList {
	
	private Node head;
	
	public void insert(int data) {
		Node node = new Node();
		node.setData(data);
		node.setNext(null);
		
		if(head == null) {
			head = node;
		} else {
			Node n = head;
			
			while(n.getNext() != null) {
				n = n.getNext();
			}
			n.setNext(node);
		}
	}

	public void show() {
		Node n = head;
		
		while(n.getNext() != null) {
			System.out.println(n.getData());
			n = n.getNext();
		}
		System.out.println(n.getData());
		System.out.println();
	}

	public void insertAtStart(int data) {
		Node node = new Node();
		node.setData(data);
		node.setNext(head);
		
		head = node;
	}

	public void insertAt(int index, int data) {
		Node node = new Node();
		node.setData(data);
		node.setNext(null);
		
		if(index == 0) {
			insertAtStart(data);
		}
		else {
			Node n = head;
			for(int i = 0; i < index-1; i++) {
				n = n.getNext();
			}
			node.setNext(n.getNext());
			n.setNext(node);
		}
	}

	public void deleteAt(int index) {
		if(index == 0) {
			head = head.getNext();
		}
		else {
			Node n = head;
			for(int i = 0; i < index-1; i++) {
				n = n.getNext();
			}
			Node tempNode = n.getNext();
			n.setNext(tempNode.getNext());
			
			tempNode = null;
			
		}
	}

	public int get(int index) {
		Node n = head;
		
		for(int i = 0; i < index; i++) {
			n = n.getNext();
		}
		return n.getData();
	}

}
