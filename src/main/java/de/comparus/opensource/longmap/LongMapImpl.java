package de.comparus.opensource.longmap;

import java.util.Arrays;

public class LongMapImpl<V> implements LongMap<V> {

    private static final int DEFAULT_CAPACITY = 5;

    private long[] keys;
    private V[] values;
    private int size;

    public LongMapImpl() {
        this(DEFAULT_CAPACITY);
    }

    public LongMapImpl(int capacity) {
        keys = new long[capacity];
        values = (V[]) new Object[capacity];
    }

    public V put(long key, V value) {

        if (size == keys.length) {
            increaseCapacity();
        }

        for (int i = 0; i < size; i++) { //перевірка на наявність ключа
            if (keys[i] == key) {
                values[i] = value;
                return value;
            }
        }

        keys[size] = key;
        values[size] = value;
        size++;

        return value;
    }

    public V get(long key) {

        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                return values[i];
            }
        }
        return null;
    }

    public V remove(long key) {

        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                V value = values[i];

                for (int j = i + 1; j < size; j++) {
                    keys[j - 1] = keys[j];
                    values[j - 1] = values[j];
                }

                size--;
                return value;
            }
        }

        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(long key) {

        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                return true;
            }
        }

        return false;
    }

    public boolean containsValue(V value) {

        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public long[] keys() {
        return Arrays.copyOf(keys, size); // сподіваюсь, що так можна))
    }

    public V[] values() {
        return Arrays.copyOf(values, size);
    }

    public long size() {
        return size;
    }

    public void clear() {
        keys = new long[DEFAULT_CAPACITY];
        values = (V[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    private void increaseCapacity() {
        int newCapacity = size * 2;
        long[] newKeys = new long[newCapacity];
        V[] newValues = (V[]) new Object[newCapacity];

        System.arraycopy(keys, 0, newKeys, 0, size);
        System.arraycopy(values, 0, newValues, 0, size);

        keys = newKeys;
        values = newValues;
    }
}
