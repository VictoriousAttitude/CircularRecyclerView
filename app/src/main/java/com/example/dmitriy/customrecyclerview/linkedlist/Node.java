package com.example.dmitriy.customrecyclerview.linkedlist;

/**
 * Created by Dima on 11/20/2017.
 */

public interface Node<S> {
    public S getData();
    public void setPosition(int position);
    public int getPosition();
    public Node getNext();
    public Node getPrev();
    public void setNext(Node next);
    public void setPrev(Node prev);
}
