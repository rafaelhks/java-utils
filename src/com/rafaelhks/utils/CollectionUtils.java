package com.rafaelhks.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {

	public static <T> List<T> toList(T[] inputArray) {
		List<T> ret = new ArrayList<T>();
		for(T t: inputArray) {
			ret.add(t);
		}
		return ret;
	}
	
	public static <T> T[] toArray(List<T> inputList, Class<T> clazz) {
		T[] ret = (T[]) Array.newInstance(clazz, inputList.size());
		for(int i=0; i<inputList.size(); i++) {
			ret[i] = inputList.get(i);
		}
		return ret;
	}
	
	public static <T> T[] append(T[] array, Class<T> clazz, T value) {
		T[] ret = (T[]) Array.newInstance(clazz, array.length+1);
		for(int i=0;i<array.length;i++) {
			ret[i] = array[i];
		}
		ret[array.length] = value;
		return ret;
	}
	
	public static <T> T[] append(T[] array, Class<T> clazz, T[] toAppend) {
		int newSize = array.length+toAppend.length;
		T[] ret = (T[]) Array.newInstance(clazz, newSize);
		for(int i=0;i<array.length;i++) {
			ret[i] = array[i];
		}
		for(int i=array.length; i<newSize; i++) {
			ret[i] = toAppend[i];
		}
		return ret;
	}
	
	public static <T> T[] append(T[] array, Class<T> clazz, List<T> toAppend) {
		int newSize = array.length+toAppend.size();
		T[] ret = (T[]) Array.newInstance(clazz, newSize);
		for(int i=0;i<array.length;i++) {
			ret[i] = array[i];
		}
		for(int i=array.length; i<newSize; i++) {
			ret[i] = toAppend.get(i-array.length);
		}
		return ret;
	}
	
	public static <T> void addAll(List<T> list, T[] toAdd) {
		for(T t:toAdd) {
			list.add(t);
		}
	}
	
	public static <T> T[] put(T[] array, int pos, T value, Class<T> clazz) {
		T[] ret = (T[]) Array.newInstance(clazz, array.length+1);
		for(int i=0;i<pos;i++) {
			ret[i] = array[i];
		}
		
		ret[pos] = value;
		
		for(int i=pos+1;i<=array.length;i++) {
			ret[i] = array[i-1];
		}
		return ret;
	}
	
	public static double sumAll(Number[] numbers) {
		double res = 0;
		for(Number n: numbers) {
			res+=n.doubleValue();
		}
		return res;
	}
	
	public static double sumAll(List<Number> numbers) {
		double res = 0;
		for(Number n: numbers) {
			res+=n.doubleValue();
		}
		return res;
	}
	
	public static boolean isIn(Object val, Object[] set) {
		for(Object o: set) {
			if(o.equals(val)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isIn(Object val, List<Object> set) {
		for(Object o: set) {
			if(o.equals(val)) {
				return true;
			}
		}
		return false;
	}

}
