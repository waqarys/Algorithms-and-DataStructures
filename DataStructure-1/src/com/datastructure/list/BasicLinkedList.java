package com.datastructure.list;

public class BasicLinkedList<X> {

	private Node first;
	private Node last;
	private int nodeCount;
	
	public BasicLinkedList() {
		first = null;
		last = null;
		nodeCount = 0;
	}
	
	public int size(){
		return nodeCount;
	}
	
	public void add(X item){
		//this condition means we are adding something for the first time
		if(first == null){
			first = new Node(item);
			last = first;
		}
		//otherwise we want to grab the last node and update its value
		else{
			Node newLastNode = new Node(item);
			last.setNextNode(newLastNode);
			last = newLastNode;
		}
		nodeCount++;
	}
	
	public X remove(){
		if(first == null){
			throw new IllegalStateException("The LinkedList is empty and there are no items to remove");
		}
		
		X nodeItem = first.getNodeItem();
		
		//now update the first pointer and throw away the old first
		first = first.getNextNode();
		nodeCount--;
		return nodeItem;
	}
	
	public void insert(X item, int position){
		if(size()<position){
			throw new IllegalStateException("The Linked List is smaller than the position specified");
		}
		
		Node currentNode = first;
		
		for(int i=1; i<position && currentNode!=null; i++){
			currentNode = currentNode.getNextNode();
		}
		
		//severs the link chain and reconnects with the new code
		Node newNode = new Node(item);
		Node nextNode = currentNode.getNextNode();
		currentNode.setNextNode(newNode);
		newNode.setNextNode(nextNode);
		nodeCount++;
	}
	
	public X removeAt(int position){
		if(first == null){
			throw new IllegalStateException("The LinkedList is empty and there are no items to remove");
		}
		
		Node currentNode = first;
		Node prevNode = first;
		
		//start at 1 because we are already at the first node
		for(int i=1; i<position && currentNode != null; i++){
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		//now update the pointers and throw away the old first
		X nodeitem = currentNode.getNodeItem();
		prevNode.setNextNode(currentNode.getNextNode());
		nodeCount--;
		return nodeitem;
	}
	
	public X get(int position){
		if(first == null){
			throw new IllegalStateException("The LinkedList is empty and there are no items to remove");
		}
		
		Node currentNode = first;
		for(int i=1; i<size() && currentNode!=null; i++){
			if(i==position){
				return currentNode.getNodeItem();
			}
			currentNode = currentNode.getNextNode();
		}
		
		// if we didn't find it then return null
		return null;
	}
	
	public int find(X item){
		if(first == null){
			throw new IllegalStateException("The LinkedList is empty and there are no items to remove");
		}
		
		Node currentNode = first;
		for(int i=1; i<size() && currentNode!=null; i++){
			if(currentNode.getNodeItem().equals(item)){
				return i;
			}
			currentNode = currentNode.getNextNode();
		}
		// if we didn't find it then return -1
		return -1;
	}
	
	public String toString(){
		StringBuffer contents = new StringBuffer();
		Node currNode = first;
		
		while(currNode != null){
			contents.append(currNode.getNodeItem());
			currNode = currNode.getNextNode();
			
			if(currNode != null){
				contents.append(", ");
			}
		}
		return contents.toString();
	}
	
	private class Node{
		private Node nextNode;
		private X nodeItem;
		
		public Node(X item) {
			this.nextNode = null;
			this.nodeItem = item;
		}
		
		public void setNextNode(Node nextNode){
			this.nextNode = nextNode;
		}
		
		public Node getNextNode(){
			return nextNode;
		}
		
		public X getNodeItem(){
			return nodeItem;
		}
	}
}
