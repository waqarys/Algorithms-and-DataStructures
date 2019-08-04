package com.datastructure.stacks;

import java.util.ArrayList;
import java.util.List;

public class ListStack<X> implements Stack<X> {

	private List<X> data;
	private int stackPointer;
	
	public ListStack() {
		data = new ArrayList<X>();
		stackPointer = 0;
	}
	
	@Override
	public void push(X newItem) {
		data.add(newItem);
		stackPointer++;
	}

	@Override
	public X pop() {
		if(data.size()==0 && stackPointer==0){
			throw new IllegalStateException("No more items on the stack");
		}
		return data.get(--stackPointer);
	}

	@Override
	public boolean contains(X item) {
		boolean found = false;
		for(int i=0; i<stackPointer; i++){
			if(data.get(i).equals(item)){
				found = true;
				break;
			}
		}
		
		return found;
	}

	@Override
	public X access(X item) {
		while(stackPointer>0){
			X tmpItem = pop();
			if(item.equals(tmpItem)){
				return tmpItem;
			}
		}
		
		throw new IllegalArgumentException("Could not find the item on the stack: "+ item);
	}
	
	public int size() {
		return stackPointer;
	}

}
