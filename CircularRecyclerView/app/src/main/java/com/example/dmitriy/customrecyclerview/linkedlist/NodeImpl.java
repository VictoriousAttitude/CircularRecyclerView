package com.example.dmitriy.customrecyclerview.linkedlist;

/**
 * Created by Dima on 11/20/2017.
 */

public class NodeImpl implements Node<NodeImpl, String> {
    public NodeImpl next;
    public NodeImpl prev;
    private String data;
    private int position;

    public NodeImpl(String data) {
        this.data = data;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    public int getPosition() {
        return position;
    }
    public String getData() {
        return data;
    }
}