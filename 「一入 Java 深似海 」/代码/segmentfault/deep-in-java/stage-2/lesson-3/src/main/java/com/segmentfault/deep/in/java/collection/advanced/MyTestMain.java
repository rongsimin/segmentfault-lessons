package com.segmentfault.deep.in.java.collection.advanced;

import java.util.Collections;
import java.util.List;

/**
 * @author rongsimin
 * @date 2020/5/15 10:46
 */
public class MyTestMain {
	public static void main(String[] args) {
		List<String> a = Collections.singletonList("A");
//		a.add("n");
//		a.remove("A");
//		a.set(0,"b");
		//所有的写操作都不行
		System.out.println(a);
		List<User> oneUser = Collections.singletonList(new User(10L));
		//java.lang.UnsupportedOperationException
		//oneUser.set(0,new User(999L));
		//如果只是更改这个对象的属性，是可以的
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
