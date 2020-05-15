package com.segmentfault.deep.in.java.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rongsimin
 * @date 2020/5/15 8:41
 */
public class MyListAndSetDemo {
	public static void main(String[] args) {
		//如果存的是ASCII值，且是按顺序存的，那么取出来也是这个顺序
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('b');
		set.add('c');
		//不论以上三个字符顺序存进去是怎样的，输出一定是[a,b,c],这里只是碰巧
		System.out.println(set);
		//对比下String 底层是通过字符数组来存储的，计算hash值是线性计算，所以得到也是一样
		//这里如果存的都是c，那么得到的hash值是相等的
		Character character = 'c';
		int i = character.hashCode();
		String s = "c";
		int j = s.hashCode();
		System.err.println(i==j);
	}


}
