package com.segmentfault.deep.in.java.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapDemo {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a");

        System.out.println(map.get(1)); //a
        System.out.println(map.get(1L));// null
        System.out.println(map.get(1.0));//null
        System.out.println(map.get(new Key(1)));//a
        System.out.println(map.containsKey(new Key(1)));//true
    }
    private static class Key {
        private final int value;
        private Key(int value) {
            this.value = value;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Integer) {
                return this.value == ((Integer) o).intValue();
            }
            Key key = (Key) o;
            return value == key.value;
        }
        @Override
        public int hashCode() {
            return value;
        }
    }
}
