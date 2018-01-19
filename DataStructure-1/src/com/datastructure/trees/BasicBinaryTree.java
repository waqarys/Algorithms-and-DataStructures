package com.datastructure.trees;

public class BasicBinaryTree<X extends Comparable<X>> {

	private Node root;
	private int size;
	
	public BasicBinaryTree() {
		this.root = null;
	}
	
	public int size(){
		return size;
	}
	
	public void add(X item){
		Node node = new Node(item);
		
		// if this is the first item in the tree, set it as root
		if(root == null){
			this.root = node;
			System.out.println("Set root: "+node.getItem());
			this.size++;
		}
		//otherwise we need to insert the item into the tree using the binary tree insert algorithm
		else {
			insert(this.root, node);
		}
	}
	
	private void insert(Node parent, Node child){
		// if the child is less than the parent, it goes on the left
		if(child.getItem().compareTo(parent.getItem()) < 0){
			// if the left node is null, we've found our spot
			if(parent.getLeft() == null){
				parent.setLeft(child);
				child.setParent(parent);
				this.size++;
			}
			//otherwise we need to call insert again and test for left or right(recursion)
			else{
				insert(parent.getLeft(), child);
			}
		}
		//if the child is greater than the parent, it goes on the right
		else if(child.getItem().compareTo(parent.getItem()) > 0){
			// if the right node is null, we've found our spot
			if(parent.getRight() == null){
				parent.setRight(child);
				child.setParent(parent);
				this.size++;
			}
			//otherise we need to call insert again and test for left or right(recursion)
			else {
				insert(parent.getRight(), child);
			}
		}
		
		//if the parent and child happen to be equal, we don't do anything
		// data in a binary tree is assumed to be unique and the value already exists in the tree
	}
	
	public boolean contains(X item){
		Node currentNode = getNode(item);
		
		if(currentNode == null){
			//didn't find it
			return false;
		} else {
			return true;
		}
	}
	
	private Node getNode(X item){
		Node currentNode = this.root;
		
		while(currentNode != null){
			int val = item.compareTo(currentNode.getItem());
			
			// see if the node is a match
			if(val == 0) {
				return currentNode;
			}
			//if the val is less than 0 we go to te left side of the tree
			else if(val < 0){
				currentNode = currentNode.getLeft();
			}
			// otherwise we go to the right side
			else {
				currentNode = currentNode.getRight();
			}
		}
		
		return null;
	}
	
	private class Node{
		private Node left;
		private Node right;
		private Node parent;
		private X item;
		
		public Node(X item) {
			this.item = item;
			this.left = null;
			this.right = null;
			this.parent = null;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public X getItem() {
			return item;
		}

		public void setItem(X item) {
			this.item = item;
		}
		
	}
}
