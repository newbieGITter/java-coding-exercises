package com.example.udemy50coding;

public class Problem16CheckIfBinaryTreeIsValid {

	// By recursively checking if every node respects its own range:
	// Time complexity: O(n)
	// Space complexity: O(h)
	static boolean isBst(Tree root) {
		return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	static class Tree {
		int data;
		Tree left;
		Tree right;

		Tree(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		Tree(int data, Tree left, Tree right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	static boolean isBst(Tree root, int min, int max) {
		if (root == null) {
			return true;
		} else if (root.data <= min || root.data >= max) {
			return false;
		} else {
			return isBst(root.left, min, root.data) && isBst(root.right, root.data, max);
		}
	}

}
