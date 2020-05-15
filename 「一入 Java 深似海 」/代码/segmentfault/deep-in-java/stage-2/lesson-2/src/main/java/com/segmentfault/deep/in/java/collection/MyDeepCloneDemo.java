package com.segmentfault.deep.in.java.collection;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rongsimin
 * @date 2020/5/15 9:19
 */
public class MyDeepCloneDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ArrayList<String> source = new ArrayList<>();
		source.add("a");
		source.add("b");
		source.add("c");
		showDiff(source,(ArrayList<String>)shallowCopy(source));
		System.err.println("-------------------------------------------");
		showDiff(source,(ArrayList<String>)deepCloneInJavaSerialization(source));
	}

	/**
	 * 浅拷贝
	 */
	private static List<String> shallowCopy(ArrayList<String> source){
		List<String> clone = (ArrayList<String>)source.clone();
		return clone;
	}

	private static void showDiff(ArrayList<String> values,ArrayList<String> clone){
		for (int i = 0;i < values.size();i++) {
			System.out.printf("values[%s].equals(clone[%s]) : %s\n",i,i,values.get(i).equals(clone.get(i)));
			System.out.printf("values[%s] == clone[%s] : %s\n",i,i,values.get(i) == clone.get(i));
		}
	}


	private static List<String> deepCloneInJavaSerialization(List<String> source) throws IOException, ClassNotFoundException,SecurityException {
		List<String> clone = new ArrayList<>(source);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(clone);
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		 clone = (ArrayList<String>)objectInputStream.readObject();
		return clone;
	}
}
