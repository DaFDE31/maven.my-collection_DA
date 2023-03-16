package com.github.curriculeon;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<SomeType> implements MyCollectionInterface<SomeType> {
    private SomeType[] array;
    private int counter;
    public MyArrayList() {
        array = (SomeType[]) new Object[10];
        counter = 0;
    }

    public MyArrayList(SomeType[] valuesToBePopulatedWith) {
        array = valuesToBePopulatedWith;
        counter = valuesToBePopulatedWith.length;
    }

    public void add(SomeType object){
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

    @Override
    public void remove(SomeType objectToRemove) { // This should only remove one index
        SomeType [] update = (SomeType[]) new Object[array.length];
        int index = 0;
        for (SomeType check: array){
            if (check == null){
                continue;
            }
            if(!check.equals(objectToRemove)){
                update[index] = check;
                index++;
            }else{counter--;}
        }
        array = update;

    }

    @Override
    public void remove(int indexOfObjectToRemove) {
        SomeType [] update = (SomeType[]) new Object[array.length];
        int index = 0;
        for (int check = 0; check<array.length; check++ ){
            if (array[check] == null){
                break;
            }
            if(check != indexOfObjectToRemove){
                update[index] = array[check];
                index++;
            }
        }
        array = update;
        counter--;
    }

    @Override
    public SomeType get(int indexOfElement) {
        try{
            return array[indexOfElement];
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Boolean contains(SomeType objectToCheckFor) {
        for (SomeType check: array)
            if (objectToCheckFor.equals(check)){
                return true;
            }
        return false;
    }

    @Override
    public Integer size() {
        return counter;
    }

    @Override
    public Iterator<SomeType> iterator() {
        return new MyArrayListIterator<>(this);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    private static class MyArrayListIterator<SomeType> implements Iterator<SomeType>{
        private  MyArrayList<SomeType> list;

        private int currentIndex;

        public MyArrayListIterator(MyArrayList<SomeType> list){
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
}
