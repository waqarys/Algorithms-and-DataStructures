package com.datastructure.linkedlist;

public class NodeChain {

	public static void main(String[] args) {
		Node first = new Node();
		first.value = 3;
		
		Node middle = new Node();
		middle.value = 5;
		
		first.next = middle;
		
		Node last = new Node();
		last.value = 7;
		
		middle.next = last;
		
		printList(first);
	}

	private static void printList(Node node) {
		while(node != null){
			System.out.println(node.value);
			node = node.next;
		}
	}
}
