package com.example.dmitriy.customrecyclerview.linkedlist;

import android.util.Log;

/**
 * Created by Dima on 10/20/2017.
 */

public class CircularLinkedListImpl implements CircularLinkedList<String> {
    private Node first;
    private Node last;
    private Node firstArrLast;
    private Node secondArrFirst;
    private Node secondArrLast;
    private Node thirdArrFirst;

    private int size = 0;
    private int maxSize = 0;
    private int currentPosition = 0;
    private static int arraysCount = 0;

    public CircularLinkedListImpl(int maxSize) {
        first = last = null;
        this.maxSize = maxSize;
    }

    @Override
    public void insertArrays(String[] data) {
        while (arraysCount <= 2) {
            for (String str : data) {
                insert(str);
            }
            arraysCount++;
        }
    }

    private void insert(String data) {
        if (!isFull()) {
            final Node link = new NodeImpl(data);
            if (isEmpty()) {
                first = last = link;
                link.setNext(null);
                link.setPrev(null);
                link.setPosition(0);
            } else {
                if (size == 1) {
                    last = link;
                    link.setPrev(first);
                    link.setNext(first);
                    first.setPrev(link);
                    first.setNext(link);
                } else {
                    link.setPrev(last);
                    last.setNext(link);
                    last = link;
                    link.setNext(first);
                    first.setPrev(link);
                }
                setArraysLimits(data, link);
                link.setPosition(++currentPosition);
            }
            size++;
            Log.i("size = ", String.valueOf(size));
        }
    }

    private void setArraysLimits(String data, Node link) {
        if (data.equals("00") && arraysCount == 0)
            firstArrLast = link;
        if (data.equals("05") && arraysCount == 1)
            secondArrFirst = link;
        if (data.equals("00") && arraysCount == 1)
            secondArrLast = link;
        if (data.equals("05") && arraysCount == 2)
            thirdArrFirst = link;
    }

    @Override
    public String get(int position) {
        Node link = first;
        Log.i("LINK = ", link.getData().toString());

        while (link.getPosition() != position) {
            link = link.getNext();
        }
        return link.getData().toString();
    }

    @Override
    public void show() {
        if (!isEmpty()) {
            Node link = first;
            do {
                Log.i("data = ", String.valueOf(link.getData()));
                Log.i("position = ", String.valueOf(link.getPosition() + "\n"));

                link = link.getNext();
            } while (link != last.getNext());
        }
    }

    @Override
    public int getFirstArrFirstPos() {
        return first.getPosition();
    }

    @Override
    public int getFirstArrLastPos() {
        return firstArrLast.getPosition();
    }

    @Override
    public int getSecArrFirstPos() {
        return secondArrFirst.getPosition();
    }

    @Override
    public int getSecArrLastPos() {
        return secondArrLast.getPosition();
    }

    @Override
    public int getThirdArrFirstPos() {
        return thirdArrFirst.getPosition();
    }

    @Override
    public int getThirdArrLastPos() {
        return last.getPosition();
    }

    @Override
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize*3;
    }
}
