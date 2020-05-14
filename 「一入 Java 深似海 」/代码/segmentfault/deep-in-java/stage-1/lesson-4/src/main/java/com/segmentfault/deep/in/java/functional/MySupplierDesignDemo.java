package com.segmentfault.deep.in.java.functional;

import java.util.function.Supplier;

/**
 * @author rongsimin
 * @date 2020/5/14 11:08
 */
public class MySupplierDesignDemo {
	public static void main(String[] args) {
		echo("Hello,World"); // 固定参数，像这里必须传入String
		echo(() ->  //变化实现
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			return "hello supplier";
		});


	}

	private static void echo(String s) {
		System.err.println(s);
	}

	private static void echo(Supplier<String> supplier) {
		System.out.println(supplier.get());
	}
}
