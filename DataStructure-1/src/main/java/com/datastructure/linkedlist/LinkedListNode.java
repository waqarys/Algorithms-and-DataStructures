package com.datastructure.linkedlist;

public class LinkedListNode<T> {

	T value;
	LinkedListNode<T> next;
	
	public LinkedListNode() {
		// TODO Auto-generated constructor stub
	}
	
	public LinkedListNode(T value) {
		this.value = value;
	}
	
	public LinkedListNode(LinkedListNode<T> node) {
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public LinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}
	
	
}
