package com.segmentfault.deep.in.java.collection;

import java.util.Comparator;

/**
 * @author rongsimin
 * @date 2020/5/14 17:25
 */
public class MyTestMain {
	public static void main(String[] args) {

		String a = "a";
		String b = "b";
		Comparator<String> stringComparator = String::compareTo;
		int compare = stringComparator.compare(a, b);
		System.out.println(compare);

		int[] nums = new int[10];
		System.out.println(nums.length);

	}
}
