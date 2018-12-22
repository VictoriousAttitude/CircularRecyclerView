package com.example.dmitriy.customrecyclerview.linkedlist;

/**
 * Created by Dima on 11/20/2017.
 */

public class NodeImpl implements Node<String> {
    private Node next;
    private Node prev;
    private String data;
    private int position;

    public NodeImpl(String data) {
        this.data = data;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public Node getNext() {
        return next;
    }

    @Override
    public Node getPrev() {
        return prev;
    }

    @Override
    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    @Override
    public String getData() {
        return data;
    }
}