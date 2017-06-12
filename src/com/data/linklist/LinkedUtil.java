package com.data.linklist;

public class LinkedUtil {

	/**
	 * Á´±í·´×ª 
	 * @param head
	 * @return
	 */
	public static Node reverseLink(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node pre = null;
		Node current = head;
		Node next = head;
		while ((next = next.next) != null) {
			current.next = pre;
			pre = current;
			current = next;
		}
		current.next = pre;
		return current;
	}
	
	public static Node buildLink(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		
		Node head = new Node();
		head.value = array[0];
		Node current = head;
		for (int i = 1; i < array.length; i++) {
			Node node = new Node();
			node.value = array[i];
			current.next = node;
			current = current.next;
		}
		return head;
	}
	
	public static void printLink(Node head) {
		if (head == null) {
			return;
		}
		Node current = head;
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	static class Node {
		Object value;
		Node next;
	}
	
	public static void main(String[] args) {
		Node head = buildLink(new int[]{5, 7, 3, 12, 9, 4, 11});
		printLink(head);
		head = reverseLink(head);
		printLink(head);
	}
}
