package com.example.udemy50coding;

public class Problem11FindIfLinkedListPalindrome {

	public static void main(String[] args) {
		//LinkedList list = new LinkedList(head)
		//isPalindrome_approach1_searchingForPositionOfRightPointer();
		//isPalindrome_approach2_reversingRightHalfAndComparing()
	}

	// By reversing the right half then comparing:
	// Time complexity: O(n)
	// Space complexity: O(1)
	private static boolean isPalindrome_approach2_reversingRightHalfAndComparing(LinkedList list) {
		// First we need to get the middle element
		// We can get middle element by using two pointer technique. Fast pointer will
		// move by 2 nodes, slow will move by 1 node.
		Node slow = list.head;
		Node fast = list.head;

		while (fast != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// Now the node which 'slow' points to is the middle node. So we need to reverse
		// the list from this position
		slow = reverseList(slow);

		// Now put slow at head of the original list and compare it with 'slow' list
		// until slow is null
		Node head = list.head;
		while (slow != null) {
			if (slow.data != head.data)
				return false;
			slow = slow.next;
			head = head.next;
		}
		return true;
	}

	static Node reverseList(Node head) {
		Node previous = null;
		Node current = head;
		while (current != null) {
			Node next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

	// By each time searching for the position of right pointer:
	// Time complexity: O(n²)
	// Space complexity: O(1)
	private static boolean isPalindrome_approach1_searchingForPositionOfRightPointer(LinkedList list) {
		int length = 0;
		Node temp = list.head;

		while (temp != null) {
			length++;
			temp = temp.next;
		}

		Node left = list.head;
		for (int i = 0; i < length / 2; i++) {
			Node right = list.head;

			for (int j = 0; j < length - i - 1; j++) {
				right = right.next;
			}
			if (left.data != right.data) {
				return false;
			}
		}
		return true;
	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	static class LinkedList {
		Node head;

		LinkedList() {
			this.head = null;
		}

		LinkedList(Node head) {
			this.head = head;
		}
	}

}
