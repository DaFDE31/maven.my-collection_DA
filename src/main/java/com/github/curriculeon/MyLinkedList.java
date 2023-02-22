package com.github.curriculeon;

import java.util.Iterator;

public class MyLinkedList<SomeType> implements MyCollectionInterface<SomeType> {
    private MyNode<SomeType> head; // The current node accessed in the linked list
    private int size; // The length/size of the linked list (how many nodes are in it)

    public MyLinkedList() { // Null constructor
        this.head = null;
        this.size = 0;
    }

    @SafeVarargs
    public MyLinkedList(SomeType... valuesToBePopulatedWith) { // Custom Constructor


        // Iterate through the linked list and set the current node equal to the jawn inputted
        for (SomeType someType : valuesToBePopulatedWith) {
            add(someType);
        }
        size = valuesToBePopulatedWith.length;
    }


    // The following methods are derived from the "myarraylist" set of tests, to coincide with the methods that the
    // tests are testing for.
    @Override
    public void add(SomeType data){ // Don't waste memory
        if ( head == null ) {
            head = new MyNode<>(data, null); // New node which is head
        } else { // If it is not empty
            MyNode<SomeType> node = head; // Sets node = head so iteration is possible
            while (node.hasNext() && node.getNext() != null){
                node = node.getNext();
            }
            MyNode<SomeType> endNode = new MyNode<>(data, null);
            node.setNext(endNode); // Once end of the list has been reached, add new node
        }
        size++; // Increments the size of the list if the new node has been appended to the list.
    }

    @Override
    public void remove(SomeType objectToRemove) {
        if (head==null){ // If the list is empty
            System.out.println("The inputted value does not exist within the list.");
            return; // May be causing issue(s)
        } else if (head.getData() == objectToRemove){ // If the head is the node to be removed
            head = head.getNext();
            size--;
            return; // May be causing issue(s)
        }
        // Go thru the list until reaching the value wanted
        MyNode<SomeType> currentNode = head;
        while ( currentNode.getNext() != null && currentNode.hasNext() ){
            if ( currentNode.getNext().getData() == objectToRemove){
                MyNode<SomeType> nextNode; // Creates a placeholder variable
                nextNode = currentNode.getNext().getNext(); // Sets the next node to the double next node, if you will
                currentNode = nextNode;
                size--; // Decrements the size of the list
            }
            currentNode = currentNode.getNext(); // Moves the head to the next node (iterates)
        }
    }

    @Override
    public void remove(int indexOfObjectToRemove) {
        // Go thru the list until reaching the value wanted
        if(indexOfObjectToRemove > -1 && indexOfObjectToRemove < size) {
            MyNode<SomeType> node = head;
            for (int i = 0; i < indexOfObjectToRemove; i++) { // Iterate thru linked list until getting to wanted index
                node = node.getNext(); // Moves the head to the next node (iterates)
            }
            remove(node.getData());
        }
        // Removes the object @ the wanted index
    }

    public SomeType get(int index){
        if (index >= size || index < 0) { // Yes I totally just copy-pasted this, I couldn't make it better myself to be honest.
            throw new IndexOutOfBoundsException();
        }
        MyNode<SomeType> currentNode = head; // current node in iteration
        for ( int i = 0 ; i < index ; i++ ) { // Iterates to the index
            currentNode = currentNode.getNext(); // iterates
        }
        return currentNode.getData(); // Returns the data
    }

    @Override
    public Boolean contains(SomeType objectToCheckFor) {
        MyNode<SomeType> currentNode = head; // keeps track of current node
        while (currentNode != null){ // until you reach end of list, loop
            if ( currentNode.getData() == objectToCheckFor ) {
                return true;
            }
            currentNode = currentNode.getNext(); // Iterates
        }
        return false;
    }

    @Override
    public Integer size() {
        return size;
    }

    @Override
    public Iterator<SomeType> iterator() {
        return new MyLinkedListIterator<>(this);
    }

    private static class MyLinkedListIterator<SomeType> implements Iterator<SomeType> {

        private MyNode<SomeType> currentNode;

        public MyLinkedListIterator(MyLinkedList<SomeType> list) {
            this.currentNode = new MyNode<>();
            this.currentNode.setData(list.get(0)); // this is the head
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public SomeType next() {
            SomeType value = currentNode.getData();
            currentNode = currentNode.getNext();
            return value;
        }
    }
}
