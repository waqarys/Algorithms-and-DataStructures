package com.datastructure.interview.stack;

import java.util.ListIterator;
import java.util.Stack;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;


public class SortedStack {

	//Recursive insert
	public void sortedInsert(Stack<Integer> s, int x){
		if(s.isEmpty() || x > s.peek()){
			s.push(x);
			return;
		}
		
		// if top is greater, remove the top item and recur
		int temp = s.pop();
		sortedInsert(s, x);
		
		//put back the top item in sorted stack
		s.push(temp);
	}
	
	// Method to sort stack
	public void sortStack(Stack<Integer> s){
		//if stack is not empty
		if(!s.isEmpty()){
			//remove the top item
			int x = s.pop();
			
			//sort remaining stack
			sortStack(s);
			
			//push the top item back in sorted stack
			sortedInsert(s, x);
		}
	}
	
	public void printStack(Stack<Integer> s) throws SAXException, JAXBException{
		ListIterator<Integer> it = (ListIterator<Integer>) s.listIterator();
		
		//forwarding
		while(it.hasNext()){
			//System.out.println(it.next());
			it.next();
		}
		
		//printing from top to bottom
		while(it.hasPrevious())
			System.out.print(it.previous()+" ");
		
	}
}
