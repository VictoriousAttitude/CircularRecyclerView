package com.example.dmitriy.customrecyclerview.linkedlist;

/**
 * Created by Dima on 11/20/2017.
 */

public interface Node<N, S> {
    public S getData();
    public void setPosition(int position);
    public int getPosition();
}
