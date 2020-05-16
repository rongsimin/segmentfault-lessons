package com.segmentfault.deep.in.java.collection.advanced;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastVsFailSafeDemo {

    public static void main(String[] args) {

        demoFailFast();

        demoFailSafe();
    }

    private static void demoFailSafe() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));

        removeForEach(new CopyOnWriteArrayList<>(list));
    }

    private static void demoFailFast() {
        removeForEach(new ArrayList<>(Arrays.asList(1,2,3)));
    }

    private static void removeForEach(Collection<?> values) {
        try {
            // 如果是 Fail-Fast 设计的话，那么会抛出 java.util.ConcurrentModificationException，如：ArrayList
            // 如果是 Fail-Safe 设计的话，那么就没有关系，如 java.util.concurrent.CopyOnWriteArrayList
            for (Object value : values) {
                values.remove(value);
            }
            System.out.println("集合删除成功，目前空间大小：" + values.size());
        } catch (ConcurrentModificationException e) {
            System.out.println("Fail-Fast 异常");
        }
    }

}
