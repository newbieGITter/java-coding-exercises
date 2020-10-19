package com.example.udemy50coding;

public class Problem5TreeDepthFirstSearch {
	static class Tree {
		int data;
		Tree left;
		Tree right;

		Tree(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public Tree(int data, Tree left, Tree right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	// pre order means first root, then left and then right
	static void dfsPreOrder(Tree root) {
		if (root == null)
			return;
		System.out.println(root.data);
		dfsPreOrder(root.left);
		dfsPreOrder(root.right);
	}

	// pre order means first left, then root and then right
	static void dfsInOrder(Tree root) {
		if (root == null)
			return;
		dfsInOrder(root.left);
		System.out.println(root.data);
		dfsInOrder(root.right);
	}

	// pre order means first left, then right and then root
	static void dfsPostOrder(Tree root) {
		if (root == null)
			return;
		dfsPostOrder(root.left);
		dfsPostOrder(root.right);
		System.out.println(root.data);
	}

}
