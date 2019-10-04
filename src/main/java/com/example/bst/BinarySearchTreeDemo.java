package com.example.bst;

public class BinarySearchTreeDemo {

	public static void main(String[] args) {
		BSTNode node = new BSTNode(50);
		node.insert(1);
		node.insert(44);
		node.insert(55);
		node.insert(88);
		node.insert(2);
		node.insert(3);
		node.insert(6);
		node.insert(33);
		node.insert(67);
		
		
		
		System.out.println(node.contains(6));
		System.out.println(node.contains(99));
		node.printInOrder();
	}

}
