package com.segmentfault.deep.in.java.collection.algorithm;

import java.util.Arrays;

/**
 * @author rongsimin
 * @date 2020/5/15 21:00
 */
public class MyInsertSort<T extends Comparable<T>> implements Sort<T> {
	@Override
	public void sort(T[] values) {
		int length = values.length;
		for (int i = 1; i < values.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (values[i].compareTo(values[j]) < 0) {
					T t = values[i];
					values[i] = values[j];
					values[j] = t;
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("一般情况");
		Integer[] values = Sort.of(3, 1, 2, 5, 4);
		Sort<Integer> sort = new MyInsertSort<>(); // Java 7 Diamond 语法
		sort.sort(values);
		System.out.printf("排序结果：%s\n", Arrays.toString(values));
	}
}
