package com.example.udemy50coding;

public class Problem15SortLinkedListInPlace {

	public static void main(String[] args) {
		// LinkedList list = new LinkedList(new Node(6));
	}

	// Bubble sort
	// Time complexity: O(n²)
	// Space complexity: O(1)
	static void sortList_usingBubbleSort(LinkedList list) {
		Node i = list.head;
		while (i != null) {
			Node j = list.head;
			while (j.next != null) {
				if (j.data > j.next.data) {
					int temp = j.data;
					j.data = j.next.data;
					j.next.data = temp;
				}
				j = j.next;
			}
			i = i.next;
		}
	}

	// Using merge sort
	// Time complexity: O(nlogn)
	// Space complexity: O(logn)
	static void sortList_usingMergeSort(LinkedList list) {
		list.head = mergeSort(list.head);
	}

	private static Node mergeSort(Node head) {
		if (head == null || head.next == null)
			return head;

		Node slow = head;
		Node fast = head;

		// To identify the middle element, using two pointer technique
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// Breaking the list into two halves
		Node headRightHalf = slow.next;
		slow.next = null;

		// Using recursion
		head = mergeSort(head);
		headRightHalf = mergeSort(headRightHalf);

		return mergeSortedLists(head, headRightHalf);
	}

	@SuppressWarnings("unused")
	private static Node mergeSortedLists(Node head1, Node head2) {
		Node ptr1 = head1;
		Node ptr2 = head2;
		Node returnedHead = null;
		Node tail = null;
		Node lower;

		while (ptr1 != null && ptr2 != null) {
			if (ptr1 != null && ptr2 != null) {
				if (ptr1.data < ptr2.data) {
					lower = ptr1;
					ptr1 = ptr1.next;
				} else {
					lower = ptr2;
					ptr2 = ptr2.next;
				}
			} else if (ptr1 != null) {
				lower = ptr1;
				ptr1 = ptr1.next;
			} else {
				lower = ptr2;
				ptr2 = ptr2.next;
			}

			if (returnedHead == null) {
				returnedHead = lower;
				tail = lower;
			} else {
				tail.next = lower;
				tail = tail.next;
			}
		}

		return returnedHead;
	}

	static class Node {
		private int data;
		private Node next;

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
