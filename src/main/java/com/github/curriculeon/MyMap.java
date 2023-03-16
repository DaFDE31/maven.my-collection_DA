package com.github.curriculeon;

import java.security.Key;

public class MyMap<KeyType, ValueType> implements MyMapInterface<KeyType, ValueType> {

    private MyArrayList<KeyValue<KeyType, ValueType>> map;

    public MyMap() {
        this.map = new MyArrayList<KeyValue<KeyType, ValueType>>();
    }

    public MyMap(MyArrayList<KeyValue<KeyType, ValueType>> myArrayList) {
        this.map = myArrayList;
    }

    @Override
    public void put(KeyType key, ValueType value) {
        KeyValue keyValue = new KeyValue(key, value);
        map.add(keyValue);
    }

    @Override
    public ValueType get(KeyType key) {
        for (int keySpot = 0; keySpot< map.size();keySpot++){
            KeyType currentKey = map.get(keySpot).getKey();
            boolean isCorrectKey = currentKey.equals(key);
            if (isCorrectKey) {
                ValueType currentValue = map.get(keySpot).getValue();
                return currentValue;
            }

        }
        /*for (KeyValue<KeyType, ValueType> keyValue : map) {
            KeyType currentKey = keyValue.getKey();
            boolean isCorrectKey = currentKey.equals(key);
            if (isCorrectKey) {
                ValueType currentValue = keyValue.getValue();
                return currentValue;
            }
        }*/
        return null;
    }

    @Override
    public MySet<KeyType> getKeySet() {
        MySet<KeyType> set = new MySet<>();
        for (int keySpot = 0; keySpot< map.size();keySpot++){
            set.add(map.get(keySpot).getKey());
        }
        return set;
    }

    @Override
    public MyCollectionInterface<ValueType> getValues() {
        MyArrayList<ValueType> list = new MyArrayList<>();
        for (int keySpot = 0; keySpot< map.size();keySpot++){
            list.add(map.get(keySpot).getValue());
        }
        return list;
    }

    @Override
    public MySet<KeyValue<KeyType, ValueType>> getList() {
        MySet<KeyValue<KeyType, ValueType>> set = new MySet<>();
        for (int keySpot = 0; keySpot< map.size();keySpot++){
            set.add(new KeyValue<>(map.get(keySpot).getKey(),map.get(keySpot).getValue()));
        }
        return set;
    }

    @Override
    public MyMapInterface<ValueType, KeyType> invert() {
        return null;
    }
}
