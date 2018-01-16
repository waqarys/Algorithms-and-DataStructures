package com.datastructure.queue;

public interface Queue<X> {

	public int size();
	public void enQueue(X item);
	public X deQueue();
	public boolean contains(X item);
	public X access(int position);
}
