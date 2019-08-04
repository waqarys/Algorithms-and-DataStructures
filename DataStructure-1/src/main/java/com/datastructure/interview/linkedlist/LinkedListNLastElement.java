package com.datastructure.interview.linkedlist;

// Simple Java program to find n'th node from end of linked list
public class LinkedListNLastElement {
    Node head;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node getNthLastNode(int n){
        int len = 0;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            len++;
        }

        if(len < n) return null;

        temp = head;
        for(int i=1; i < len-n+1; i++){
            temp = temp.next;
        }

        return temp;
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void main(String[] args) {
        LinkedListNLastElement list = new LinkedListNLastElement();
        list.push(20);
        list.push(4);
        list.push(15);
        list.push(35);

        Node nthLast = list.getNthLastNode(2);
        System.out.println(nthLast.data);
    }
}
