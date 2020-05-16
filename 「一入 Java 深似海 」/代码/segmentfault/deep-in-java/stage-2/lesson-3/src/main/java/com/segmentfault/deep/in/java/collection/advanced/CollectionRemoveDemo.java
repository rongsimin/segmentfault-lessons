package com.segmentfault.deep.in.java.collection.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CollectionRemoveDemo {

    public static void main(String[] args) {

        List<Integer> values = new ArrayList(Arrays.asList(1, 2, 3));

        // 常规做法
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()) {
            iterator.next(); // 需要执行，调整游标
            iterator.remove();
        }

        values = new ArrayList(Arrays.asList(1, 2, 3));

        //　成功删除
        int size = values.size();
        for (int i = 0; i < size; i++) {
            Object value = values.get(0);
            values.remove(value);
            System.out.println(values.size());
        }

        values = new ArrayList(Arrays.asList(1, 2, 3));

        size = values.size();
        for (int i = 0; i < size; i++) {
            values.remove(0);
        }
        //这样会导致删不干净，删完还剩下一个元素
		values = new ArrayList(Arrays.asList(1, 2, 3));
        for (int i = 0;i < values.size();i++){
        	values.remove(i);
		}

        // 失败删除: for-each 语法
        values = new ArrayList(Arrays.asList(1, 2, 3));

        for (Integer value : values) {
            values.remove(value);
        }
    }
}
