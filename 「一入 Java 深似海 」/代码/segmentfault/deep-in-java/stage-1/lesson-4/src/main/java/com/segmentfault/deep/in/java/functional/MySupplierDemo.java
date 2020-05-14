package com.segmentfault.deep.in.java.functional;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * @author rongsimin
 * @date 2020/5/14 10:19
 */
public class MySupplierDemo {
	public static void main(String[] args) {
		//函数式接口可以被方法引用来进行实例化，再调用get方法表示真正的调用
		Supplier<String> supplier = MySupplierDemo::getHelloWorld;
		System.out.println(supplier.get());
		Supplier<String> helloWorld2 = getHelloWorld2();
		System.err.println(helloWorld2.get());
		//Supplier只出不进 Callable也是如此
		Callable<String> callable = MySupplierDemo::getHelloWorld;
	}

	public static String getHelloWorld(){
		return "hello,world";
	}

	/**
	 * 作为方法返回值
	 * @return
	 */
	public static Supplier<String> getHelloWorld2(){
		return MySupplierDemo::getHelloWorld;
	}
}
