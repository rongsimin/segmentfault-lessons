package com.segmentfault.deep.in.java.functional;

import java.util.function.Consumer;

/**
 * @author rongsimin
 * @date 2020/5/14 10:35
 */
public class MyConsumerDemo {
	public static void main(String[] args) {
		//Consumer只进不出，System.out::println就正好适合
		Consumer<String> consumer1 = System.out::println;
		consumer1.accept("hello,consumer");
		Consumer<String> consumer2 = MyConsumerDemo::echo;
		// Fluent API
		// consumer2 -> consumer -> consumer
		//把这三步当作时，扔一个对象进去，再扔一个对象，最后点击提交
		consumer2.andThen(consumer1).andThen(consumer1).accept("hello,rsm");

	}

	public static void echo(String message){
		System.err.println("echo :"+message);
	}
}
