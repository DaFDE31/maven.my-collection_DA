package com.github.curriculeon;

import java.util.Iterator;

public class MySet<T> implements MyCollectionInterface<T> {
    private MyArrayList<T> set; // Set creation

    public MySet() {
        this.set = new MyArrayList<>();
    }

    public MySet(Object[] valuesToBePopulatedWith) {
//        // Initiate the backbone array to be bigger than the length as the inputted array
//        this.content = T[valuesToBePopulatedWith.length + resize];
//        // Loop through the array starting at "index" until reaching the length of the array given as "valuesToBePopulatedWith"
//        // Each iteration of the loop, used teh "add" method that hasn't been created yet to add the given object to the array
//        for (int i = index; i < valuesToBePopulatedWith.length; i++) {
//            content[i] = (T) valuesToBePopulatedWith[i]; // Copy shit over
//        }

        if (valuesToBePopulatedWith[0].equals(null) || ( valuesToBePopulatedWith.length < 1) ) { // Check if the array has shit in it
            System.out.println("Not a valid array as input, try again.");
        } else {
            this.set = new MyArrayList<>(); // Instantiate the set

            for (int i = 0 ; i < valuesToBePopulatedWith.length ; i++ ) { // Loops thru valuesToBePopulatedWith
                this.set.add((T) valuesToBePopulatedWith[i]); // Adds each element of valuesToBePopulatedWith to the set
            }
        }
    }

    @Override
    public void add(T objectToAdd) {
        //if ( ( set.contains(objectToAdd) != null ) && ( set.contains(objectToAdd) == true) ) { // If the set contains the object, don't add it to the set
        if ( set.contains(objectToAdd)) {
            System.out.println("That object is already in your set!");
        } else {
            set.add(objectToAdd); // Adds the object to the set
        }
    }

    @Override
    public void remove(T objectToRemove) {
        if ( set.contains(objectToRemove)){ // If it is in the set
            set.remove(objectToRemove); // Removes wanted element from the set
        } else {
            System.out.println("The inputted object does not exist within the set, try again.");
        }
    }

    @Override
    public void remove(int indexOfObjectToRemove) {
        if ( set.size() >= indexOfObjectToRemove ){ // If it is in the set
            set.remove(indexOfObjectToRemove); // Removes wanted element from the set
        } else {
            System.out.println("The inputted object does not exist within the set, try again.");
        }
    }

    @Override
    public T get(int indexOfElement) {
        return set.get(indexOfElement);
    }

    @Override
    public Boolean contains(T objectToCheckFor) {
        return set.contains(objectToCheckFor);
    }

    @Override
    public Integer size() {
        return set.size();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
