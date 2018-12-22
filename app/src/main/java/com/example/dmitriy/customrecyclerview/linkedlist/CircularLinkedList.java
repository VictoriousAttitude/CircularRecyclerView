package com.example.dmitriy.customrecyclerview.linkedlist;

/**
 * Created by Dima on 11/20/2017.
 */

public interface CircularLinkedList<S> {
    public void insertArrays(S[] data);
    public void show();
    public int getFirstArrFirstPos();
    public int getFirstArrLastPos();
    public int getSecArrFirstPos();
    public int getSecArrLastPos();
    public int getThirdArrFirstPos();
    public int getThirdArrLastPos();
    public int getSize();
    public boolean isEmpty();
    public boolean isFull();
    public S get(int position);
}
