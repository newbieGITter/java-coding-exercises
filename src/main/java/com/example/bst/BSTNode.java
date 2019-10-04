package com.example.bst;

public class BSTNode {
	private int data;
	private BSTNode left;
	private BSTNode right;
	
	public BSTNode(int value) {
		this.data = value;
	}
	
	public void insert(int value) {
		if(value <= data) {
			if(left == null) {
				left = new BSTNode(value);
			} else {
				left.insert(value);
			}
		} else {
			if(right == null) {
				right = new BSTNode(value);
			} else {
				right.insert(value);
			}
		}
	}
	
	public boolean contains(int value) {
		if(value == data) {
			return true;
		} 
		else if(value < data) {
			if(left == null) {
				return false;
			} else {
				return left.contains(value);
			}
		}
		else {
			if(right == null) {
				return false;
			} else {
				return right.contains(value);
			}
		}
	}
	
	public void printInOrder() {
		if(left != null) {
			left.printInOrder();
		}
		System.out.println(data);
		
		if(right != null) {
			right.printInOrder();
		}
	}

}
