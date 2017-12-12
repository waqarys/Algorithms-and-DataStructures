package com.datastructure.linkedlist;

import java.util.Collection;
import java.util.Iterator;

public class LinkedList<T, E> implements Collection<E> {

	protected int size;
	protected LinkedListNode<T> head;
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		head = addAtEnd(head, e);
		size++;
		return false;
	}

	private LinkedListNode<T> addAtEnd(LinkedListNode<T> node, E value) {
		if (node == null) {	// special case
		    return new LinkedListNode<T>(node);
		} else if (node.getNext() == null) { // other special case
		    node.setNext(new LinkedListNode<T>(node));
		} else {
		    addAtEnd(node.getNext(), value);
		}
		return node;
	    }
	
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
