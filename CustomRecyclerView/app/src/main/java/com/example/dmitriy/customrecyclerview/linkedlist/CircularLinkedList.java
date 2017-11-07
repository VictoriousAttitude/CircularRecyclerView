package com.example.dmitriy.customrecyclerview.linkedlist;

import android.util.Log;

/**
 * Created by Dima on 10/20/2017.
 */

class Node {
    public Node next;
    public Node prev;
    private String data;
    private int position;

    public Node(String data) {
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

public class CircularLinkedList {
    private Node first;
    private Node last;
  //private Node currentLink;

    private int size = 0;
    private int maxSize = 0;
    private int currentPosition = 0;

    public CircularLinkedList(int maxSize) {
        first = last = null;
        this.maxSize = maxSize;
    }

    public void insert(String data) {
        if (!isFull()) {
            Node link = new Node(data);

            if (isEmpty()) {
                this.first = this.last = link;
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
                link.setPosition(++currentPosition);
            }
            size++;
        }
    }

    public String get(int position) {
        Node link = first;

        while (link.getPosition() != position) {
            link = link.next;
          //if (link == this.last && link.getPosition() != position)
              //break;
        }
        return link.getData();
    }

    public void show() {
        if (!isEmpty()) {
            Node link = this.first;
            do {
                Log.i("data = ", String.valueOf(link.getData()));
                Log.i("position = ", String.valueOf(link.getPosition() + "\n"));

                link = link.next;
            } while (link != last.next);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }
}
