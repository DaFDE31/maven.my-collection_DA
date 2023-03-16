package com.github.curriculeon;

import java.util.Iterator;

public class MyLinkedList<SomeType> implements MyCollectionInterface<SomeType>{
    private MyNode<SomeType> baseNode;

    public MyLinkedList() {
        baseNode = new MyNode<SomeType>();
    }

    public MyLinkedList(SomeType... valuesToBePopulatedWith) {
        //MyNode currentNode = baseNode;
        for (SomeType adders : valuesToBePopulatedWith){
            this.add(adders);
        }
    }

    @Override
    public void add(SomeType objectToAdd) {
        if (baseNode == null){
            baseNode = new MyNode<SomeType>(objectToAdd);
        }
        else if (baseNode.getData() == null){
            baseNode.setData(objectToAdd);
        }
        else{
            MyNode<SomeType> currentNode = baseNode;
            while (currentNode != null && currentNode.hasNext()){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new MyNode<>(objectToAdd, null));
        }
    }

    @Override
    public void remove(SomeType objectToRemove) {
        MyNode<SomeType> nodeToAdd = new MyNode<>();
        nodeToAdd.setData(objectToRemove);
        if (baseNode.getData() == objectToRemove) {
            baseNode = baseNode.getNext();
            return;
        }
        MyNode<SomeType> current = baseNode;
        while(current!=null&&current.getNext()!=null) {
            MyNode<SomeType> next = current.getNext();
            boolean isCorrectValue = next.getData().equals(objectToRemove);
            if (isCorrectValue) {
                MyNode<SomeType> swapped = next.getNext();
                current.setNext(swapped);
                break;
            }
            current = current.getNext();

        }
    }

    @Override
    public void remove(int indexOfObjectToRemove) {
        remove(get(indexOfObjectToRemove));


    }

    @Override
    public SomeType get(int indexOfElement) {
        int index = 0;
        MyNode<SomeType> current = baseNode;
        while(current != null){
            if (index == indexOfElement){
                return current.getData();
            }
            index++;
            current = current.getNext();
        }

        return null;
    }

    @Override
    public Boolean contains(SomeType objectToCheckFor) {
        MyNode<SomeType> currentNode = baseNode;
        while (currentNode != null){
            SomeType data = currentNode.getData();
            if (data.equals(objectToCheckFor)){
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public Integer size() {
        MyNode<SomeType> currentNode = baseNode;
        int count = 0;
        while (currentNode != null){
            count++;
            currentNode = currentNode.getNext();
        }
        return count;
    }

    @Override
    public Iterator<SomeType> iterator() {
        return new MyLinkedListIterator<>(this);
    }

    @Override
    public String toString() {
        String result = "List:";
        MyNode<SomeType> current = baseNode;
        while(current != null){
            result += " "+current.getData().toString();
            current = current.getNext();
        }
        return result;
    }

    private static class MyLinkedListIterator<SomeType> implements Iterator<SomeType> {
        private MyLinkedList<SomeType> list;
        private MyNode<SomeType> currentNode;

        public MyLinkedListIterator(MyLinkedList<SomeType> list) {
            this.list = list;
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
