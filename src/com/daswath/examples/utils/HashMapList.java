package com.daswath.examples.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by DAswath on 10/8/2016.
 */
public class HashMapList<K, V> {
    private HashMap<K, ArrayList<V>> entries = new HashMap<K, ArrayList<V>>();

    public void put(K key, V value) {
        if (entries.get(key) == null) {
            entries.put(key, new ArrayList<V>());
        }
        entries.get(key).add(value);
    }

    public ArrayList<V> get(K key) {
        return entries.get(key);
    }

    public Set<K> keySet() {
        return entries.keySet();
    }
}
