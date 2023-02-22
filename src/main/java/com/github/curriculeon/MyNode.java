package com.github.curriculeon;

public class MyNode<SomeType> {
    private SomeType data; // The data of the current node
    private MyNode<SomeType> next; // The <node> of the next node

    // * FAILS TEST 2 OF NONNULLARYCONSTRUCTORTEST *
    public MyNode() {
        setData(null); setNext(null);
    }

    // * FAILS TEST 2 OF NONNULLARYCONSTRUCTORTEST *
    public MyNode(SomeType data, MyNode<SomeType> next) {
        setData(data); setNext(next);
    }

    public SomeType getData() { return this.data; } // Returns the data of the current node.

    public void setData(SomeType data) { this.data = data; } // Sets the data of the current node equal to the inputted parameter.

    public MyNode<SomeType> getNext() { return next; } // Returns the <node> of the next node.

    // * FAILS TEST 3 OF SETNEXTTEST*
    public void setNext(MyNode<SomeType> next) { // Sets the next node of the current node.
        if(next == this) {
            throw new IllegalArgumentException();
        }
        this.next = next;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    public boolean hasNext() {
        return next != null;
    }
}