package com.datastructure.interview.stack;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.util.Stack;

public class TestSortedMap {

	public static void main(String[] args) throws SAXException, JAXBException {
		SortedStack stack = new SortedStack();
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
      
        System.out.println("Stack elements before sorting: ");
        stack.printStack(s);
      
        stack.sortStack(s);
      
        System.out.println(" \n\nStack elements after sorting:");
        stack.printStack(s);
      
    }
}
