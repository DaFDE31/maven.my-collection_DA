package com.github.curriculeon.myarraylist;

import com.github.curriculeon.ImportChecker;
import com.github.curriculeon.MyArrayList;
import com.github.curriculeon.MyCollectionInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @author leonhunter
 * @created 12/15/2019
 */
@SuppressWarnings("all")
public class RemoveTest {
    //given
    private <SomeType> void test(SomeType valueToRemove, SomeType[] valuesToBePopulatedWith, SomeType[] expectedElementSequence) {
        MyArrayList<SomeType> myList = new MyArrayList<>();
        ImportChecker.scanClass(myList.getClass());
        MyCollectionInterface<SomeType> myCollection = (MyCollectionInterface<SomeType>) myList;

        for (SomeType someValue : valuesToBePopulatedWith) {
            myCollection.add(someValue);
            Boolean myCollectionContainsValue = myCollection.contains(someValue);
            Assert.assertTrue(myCollectionContainsValue);
        }

        // when
        myCollection.remove(valueToRemove);
        Integer postRemoveLength = myCollection.size(); // get size of collection
        Integer actualPostRemoveLength = postRemoveLength; // get the actual post-removal length

        // then
        Assert.assertEquals(actualPostRemoveLength, postRemoveLength);
        for (int currentIndex = 0; currentIndex < expectedElementSequence.length; currentIndex++) {
            SomeType expectedElement = expectedElementSequence[currentIndex];
            SomeType actualElement = myCollection.get(currentIndex);
            Assert.assertEquals(expectedElement, actualElement);
        }
    }

    @Test
    public void test0() {
        int indexOfElementToRemove = 1;
        String[] valuesToPopulateCollection = new String[]{"The", "Quick", "Brown", "Fox"};
        String[] expectedElementSequence = new String[]{"The", "Brown", "Fox"};
        String valueToRemove = valuesToPopulateCollection[indexOfElementToRemove];
        test(valueToRemove, valuesToPopulateCollection, expectedElementSequence);
    }


    @Test
    public void test1() {
        int indexOfElementToRemove = 0;
        Integer[] valuesToPopulateCollection = new Integer[]{1, 3, 5, 8, 13};
        Integer[] expectedElementSequence = new Integer[]{3, 5, 8, 13};
        Integer valueToRemove = valuesToPopulateCollection[indexOfElementToRemove];
        test(valueToRemove, valuesToPopulateCollection, expectedElementSequence);
    }

    @Test
    public void test2() {
        int indexOfElementToRemove = 2;
        Date d1 = new Date();
        Date d2 = new Date();
        Date d3 = new Date();
        Date[] expectedElementSequence = new Date[]{d1, d2};
        Date[] valuesToPopulateCollection = new Date[]{d1, d2, d3};
        Date valueToRemove = valuesToPopulateCollection[indexOfElementToRemove];
        test(valueToRemove, valuesToPopulateCollection, expectedElementSequence);
    }


    @Test
    public void test3() {
        int indexOfElementToRemove = 3;
        Date d1 = new Date();
        Date d2 = new Date();
        Date d3 = new Date();
        Date d4 = new Date();
        Date d5 = new Date();
        Date d6 = new Date();
        Date d7 = new Date();
        Date[] expectedElementSequence    = new Date[]{d1, d2, d3,     d5, d6, d7};
        Date[] valuesToPopulateCollection = new Date[]{d1, d2, d3, d4, d5, d6, d7};
        Date valueToRemove = valuesToPopulateCollection[indexOfElementToRemove];
        test(valueToRemove, valuesToPopulateCollection, expectedElementSequence);
    }
}
