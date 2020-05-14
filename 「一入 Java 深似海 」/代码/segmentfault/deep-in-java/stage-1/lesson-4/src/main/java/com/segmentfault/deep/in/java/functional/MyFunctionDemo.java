package com.segmentfault.deep.in.java.functional;

import java.util.function.Function;

/**
 * @author rongsimin
 * @date 2020/5/14 10:50
 */
public class MyFunctionDemo {
	public static void main(String[] args) {
		//Function特点 有出有进
		//下面例子其实是一句废话，只是用来说明类型转换
		Function<Integer,Integer> function = (a) -> a;
		int i = function.apply(1).intValue();
		System.out.println(i);

		Function<Integer,String> integerToString = String::valueOf;
		Function<String,Integer> stringToInteger = Integer::valueOf;
		//先执行compose里面的转换，再执行外边的integerToString转换
		String apply = integerToString.compose(stringToInteger).apply("1");
	}
}
