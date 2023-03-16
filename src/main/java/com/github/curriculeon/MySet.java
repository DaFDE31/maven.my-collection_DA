package com.github.curriculeon;

import java.util.Arrays;
import java.util.Iterator;

public class MySet<SomeType> implements MyCollectionInterface<SomeType>{
    private MyArrayList<SomeType> set;

    public MySet() {
        set = new MyArrayList<>();
    }

    public MySet(SomeType[] valuesToBePopulatedWith) {
        set = new MyArrayList<>(valuesToBePopulatedWith);
    }

    @Override
    public void add(SomeType objectToAdd) {
        if(!set.contains(objectToAdd)){
            set.add(objectToAdd);
        }
    }

    @Override
    public void remove(SomeType objectToRemove) {
        set.remove(objectToRemove);
    }

    @Override
    public void remove(int indexOfObjectToRemove) {
        set.remove(indexOfObjectToRemove);
    }

    @Override
    public SomeType get(int indexOfElement) {
        return set.get(indexOfElement);
    }

    @Override
    public Boolean contains(SomeType objectToCheckFor) {
        return set.contains(objectToCheckFor);
    }

    @Override
    public Integer size() {
        return set.size();
    }

    @Override
    public Iterator<SomeType> iterator() {
        return null;
    }

   /* public void add(SomeType object){
        if (!set.contains(object)){
            if (counter >= array.length){
                SomeType [] update = (SomeType[]) new Object[array.length+5];
                System.arraycopy(array,0, update, 0,array.length);
                array = update;
                array[counter] = object;
            }
            else{
                array[counter] = object;
            }
            counter++;
        }
    }

    public void remove(SomeType objectToRemove) { // This should only remove one index
        SomeType [] update = (SomeType[]) new Object[array.length];
        int index = 0;
        boolean first = true;
        for (SomeType check: array){
            if (check == null){
                break;
            }
            if(!check.equals(objectToRemove) || !first){
                update[index] = check;
                index++;
            }
            else{
                first = false;
                counter--;
            }
        }
        array = update;

    }

    @Override
    public void remove(int indexOfObjectToRemove) {

    }

    public SomeType get(int indexOfElement) {
        return null;
    } //Should not exist for a set

    public Boolean contains(SomeType objectToCheckFor) {
        for (SomeType check: array){
            if (check.equals(objectToCheckFor)){
                return true;
            }

        }
        return false;
    }

    public Integer size() {
        return counter;
    }

    @Override
    public Iterator<SomeType> iterator() {
        return new MySetIterator<SomeType>(this);
    }

    private static class MySetIterator<SomeType> implements Iterator<SomeType>{
        private  MySet<SomeType> list;

        private int currentIndex;

        public MySetIterator(MySet<SomeType> list){
            this.list = list;
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < list.size();
        }

        @Override
        public SomeType next() {
            return list.get(currentIndex++);
        }
    }

    */
}
