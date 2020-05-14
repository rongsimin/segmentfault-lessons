package com.segmentfault.deep.in.java.functional;

/**
 * @author rongsimin
 * @date 2020/5/14 11:01
 */
public class MyActionDemo {
	public static void main(String[] args) {
		//Action特点，无进无出，像Runnable就是这样的
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				println();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		Runnable runnable1 = () ->{

		};

		//以上改写
		runnable1 = MyActionDemo::println;
		thread = new Thread(runnable1);
		thread.start();

	}
	public static void println(){
		System.out.println("执行run方法");
	}
}
