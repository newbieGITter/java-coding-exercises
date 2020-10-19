package com.example.udemy50coding;

public class Problem9ReverseLinkedListInPlace {

	static class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
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

		// Time complexity: O(n²)
		// Space complexity: O(1)
		static void reverseList_WithValues(LinkedList list) {
			int length = 0;
			Node temp = list.head;
			while (temp != null) {
				length++;
				temp = temp.next;
			}

			Node left = list.head;
			for (int i = 0; i < length / 2; i++) {
				Node right = list.head;

				for (int j = 0; j < length - i - 1; j++)
					right = right.next;

				int tempData = left.data;
				left.data = right.data;
				right.data = tempData;
				left = left.next;
			}
		}
		
		// Time complexity: O(n)
		// Space complexity: O(1)
		static void reverseList_withLinksIteratively(LinkedList list) {
			Node previous = null;
			Node current = list.head;
			
			while(current != null) {
				Node next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}
			list.head = previous;
		}
		
		// Time complexity: O(n)
		// Space complexity: O(n) -- cos of recursion
		static void reverseList_withLinksRecursively(LinkedList list) {
			list.head = reverseNodes(list.head);
		}

		private static Node reverseNodes(Node node) {
			if(node == null || node.next == null) {
				return node;
			}
			Node reversed = reverseNodes(node.next);
			node.next.next = node;
			node.next = null;
			return reversed;
		}

	}

}
