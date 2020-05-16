package com.segmentfault.deep.in.java.collection.advanced;

import java.util.Arrays;

/**
 * @author rongsimin
 * @date 2020/5/16 10:19
 */
public class MyImmutableArrayDemo {
	public static void main(String[] args) {
		Integer[] nums = of(888,999,1000);
		Integer[] copyNums = Arrays.copyOf(nums, nums.length);

		//Arrays.copyOf属于浅拷贝，与集合是一样的
		for (int i = 0; i < nums.length; i++) {
			//这里可以证明以上浅拷贝观点，输出全为true，表示数组里面的元素内存地址没变
			System.out.println(nums[i] == copyNums[i]);
		}
		//Integer#valueOf()
		copyNums[0] = 777;
		//[888, 999, 1000]至于这里，原数组第一个元素并没有改变，这里不能说明Arrays.copyOf
		//属于浅拷贝，但是具体原因不知，以后再深究
		System.out.println(Arrays.toString(nums));
		//String、Long都测试了，结论都一样
		//如果是自定义对象
		User[] users = of(1L, 2L, 3L);
		User[] copyOf = Arrays.copyOf(users, users.length);
		copyOf[0].setId(99L);
		//99,说明引用的是同一个内存地址，属于浅拷贝
		System.out.println(users[0].getId());

		// 结论：
		//      1. 数组的 Copy 与 集合对象的 Clone 是类似，浅克隆（复制）
		//      2. 如果需要只读数组的话， 需要深度 Clone（复制）
	}

	private static <T> T[] of(T... nums) {
		return nums;
	}

	private static User[] of(Long ...ids){
		User[] users = new User[ids.length];
		for (int i = 0;i < ids.length;i++){
			users[i] = new User(ids[i]);
		}
		return users;
	}
	private static class User{
		private Long id;

		public User(Long id) {
			this.id = id;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
	}

}
