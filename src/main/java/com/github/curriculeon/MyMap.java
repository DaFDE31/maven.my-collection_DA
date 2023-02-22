package com.github.curriculeon;

public class MyMap<KeyType, ValueType> implements MyMapInterface<KeyType, ValueType> {

    KeyType keyValue; // Key
    ValueType value; // Value
    private MyArrayList<KeyValue<KeyType, ValueType>> map; // Map

    public MyMap() {
        this.map = new MyArrayList<>();
    }

    public MyMap(MyArrayList<KeyValue<KeyType, ValueType>> map) {
        this.map = map;
    }


    @Override
    public void put(KeyType key, ValueType value){
        KeyValue keyvalue = new KeyValue<>(key,value); // Creates object to hold two objects in
        map.add(keyvalue); // adds it to list
    }

    @Override
    public ValueType get(KeyType key){
        for(KeyValue<KeyType,ValueType> keyvalue : map) { // goes thru each key value in the map's arrayList backbone
            KeyType currentKey = keyvalue.getKey(); // Sets the current key equal to the current arraylist index's keyvalue
            if (currentKey.equals(key) ) { // If the current key is the one we want
                return keyvalue.getValue(); // return the value of the current key
            }
        }
        return null; // returns null if it isn't in the map
    }

    @Override
    public MySet<KeyType> getKeySet(){
        return null;
    }

    @Override
    public MyCollectionInterface<ValueType> getValues(){
        return null;
    }

    @Override
    public MySet<KeyValue<KeyType, ValueType>> getList(){
        return null;
    }

    @Override
    public MyMapInterface<ValueType, KeyType> invert(){
        return null;
    }

}
