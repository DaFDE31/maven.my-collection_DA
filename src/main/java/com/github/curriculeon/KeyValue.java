package com.github.curriculeon;

import javax.naming.OperationNotSupportedException;

public class KeyValue<KeyType, ValueType> {

    private KeyType keys;
    private ValueType values;
    public KeyValue(KeyType key, ValueType value) {
        keys = key;
        values = value;
    }

    public KeyType getKey() {
        return keys;

    }

    public ValueType getValue() {
        return values;
    }

    public void setKey(KeyType key) {
        keys = key;
    }

    public void setValue(ValueType value) {
        values = value;
    }
}
