package com.github.curriculeon;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<SomeType> implements MyCollectionInterface<SomeType> {
    // Variable Declarations
    private int index; // Holds current jawn in the jawn
    private SomeType[] content; // Array to hold shit
    private static final Integer resize = 1; // holds the additional length given to the backbone array when capacity is being reached

    public MyArrayList() { // General constructor
        index = 0; // Sets index to zero
        this.content = (SomeType[]) new Object[1]; // Sets the backbone array to a length of 10 (unspecified objects)
    }

    public MyArrayList(SomeType[] valuesToBePopulatedWith) { // Custom constructor
        // Initiate the backbone array to be bigger than the length as the inputted array
        this.content = (SomeType[]) new Object[valuesToBePopulatedWith.length + resize];
        // Loop through the array starting at "index" until reaching the length of the array given as "valuesToBePopulatedWith"
        // Each iteration of the loop, used teh "add" method that hasn't been created yet to add the given object to the array
        for (int i = index; i < valuesToBePopulatedWith.length; i++) {
            content[i] = valuesToBePopulatedWith[i]; // Copy shit over
        }
    }

    @Override
    public void add(SomeType objectToBeAdded) { // Adds an object into the arraylist
        Integer threshhold = content.length - 1; // The threshhold for resizing the array is 1 less than the current length
        if (index <= threshhold) { // Adds length to array if needed
            Integer newSize = content.length + resize; // Bigger array size
            SomeType[] newContent = (SomeType[]) new Object[newSize]; // Declare bigger array
            System.arraycopy(content, 0, newContent, 0, content.length); // Copies the array from start to end from old array to new array
            content = newContent; // Updates backbone array with new information
        }
        content[index] = objectToBeAdded; // Adds shit to the array
        index++; // Increment index bc we just added shit
    }

    @Override
    public SomeType get(int index) { // Returns an object from the backbone arrray at the given index
        SomeType returnVar = null; // declares a return variable
        if (index < this.index && index > -1) { // if given index is a valid input
            returnVar = this.content[index]; // sets return variable equal to the wanted object
        }
        return returnVar; // returns the wanted object if valid input
    }

    @Override
    public Boolean contains(SomeType objectToCheckFor) {
        boolean returnVar = false;
        boolean flag = false; // Flag that is only true if the objectToCheckFor in contained in the content array

        // For loop that loops thru the content array and switches the flag to true if the objectToCheckFor is contained
        for (int i = 0; i < content.length; i++) {
            if (content[i] == null) { // Null catcher
                continue;
            } else if (content[i].equals(objectToCheckFor)) { // If the current iteration of the content array's object is equal to the objectToCheckFor
                return true;
            }
        }

        return returnVar; // Returns the status of flag, held as returnVar
    }

    @Override
    public Integer size() {
        return this.index;
    }

    @Override
    public void remove(SomeType objectToRemove) {
        int contentLength =  content.length;
        int newContentLength = contentLength - 1;
        SomeType[] newContent = (SomeType[]) new Object[newContentLength]; // Creates new generic array with one less length than content

        int newContentCurrentIndex = 0;
        for (int currentIndex = 0; currentIndex < content.length; currentIndex++) { // Loops thru the
            SomeType currentObject = content[currentIndex];

            if (currentObject != objectToRemove) { // Is current object is NOT objectToRemove
                newContent[newContentCurrentIndex] = currentObject; // Populates new array
                newContentCurrentIndex++;
            }
        }
        index--;
        this.content = newContent; // Copies array over
    }

    @Override
    public void remove(int indexOfObjectToRemove) {
        remove(get(indexOfObjectToRemove));
    }


    @Override
    public Iterator<SomeType> iterator() { // Not necessary to do because this method isn't being tested
        return new MyArrayListIterator<>(this);
    }

    private static class MyArrayListIterator<SomeType> implements Iterator<SomeType> {
        private MyArrayList<SomeType> list;

        private int currentIndex;

        public MyArrayListIterator(MyArrayList<SomeType> list) {
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
























