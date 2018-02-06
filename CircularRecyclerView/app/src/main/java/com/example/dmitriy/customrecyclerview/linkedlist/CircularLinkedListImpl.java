package com.example.dmitriy.customrecyclerview.linkedlist;

import android.util.Log;

/**
 * Created by Dima on 10/20/2017.
 */

public class CircularLinkedListImpl implements CircularLinkedList<String, NodeImpl> {
    private NodeImpl first;
    private NodeImpl last;
    private NodeImpl firstArrLast;
    private NodeImpl secondArrFirst;
    private NodeImpl secondArrLast;
    private NodeImpl thirdArrFirst;

  //private String[] singleArrayData;
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
      //singleArrayData = data;
        while (arraysCount <= 2) {
            for (String str : data) {
                insert(str);
            }
            arraysCount++;
        }
    }

    private void insert(String data) {
        if (!isFull()) {
            final NodeImpl link = new NodeImpl(data);
            if (isEmpty()) {
                first = last = link;
                link.next = link.prev = null;
                link.setPosition(0);
            } else {
                if (size == 1) {
                    last = link;
                    link.prev = first;
                    link.next = first;
                    first.prev = link;
                    first.next = link;
                } else {
                    link.prev = last;
                    last.next = link;
                    last = link;
                    link.next = first;
                    first.prev = link;
                }
                setArraysLimits(data, link);
                link.setPosition(++currentPosition);
            }
            size++;
            Log.i("size = ", String.valueOf(size));
        }
    }

    private void setArraysLimits(String data, NodeImpl link) {
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
        NodeImpl link = first;
        Log.i("LINK = ", link.getData());

        while (link.getPosition() != position) {
            link = link.next;
        }
        return link.getData();
    }

    @Override
    public void show() {
        if (!isEmpty()) {
            NodeImpl link = first;
            do {
                Log.i("data = ", String.valueOf(link.getData()));
                Log.i("position = ", String.valueOf(link.getPosition() + "\n"));

                link = link.next;
            } while (link != last.next);
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
