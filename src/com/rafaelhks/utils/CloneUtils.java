package com.rafaelhks.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CloneUtils {
	
	public static <T> void cloneMethod2(T original, T clone) {
		Field[] fields = original.getClass().getDeclaredFields();
		for(Field f: fields) {
			try {
				Object o = new PropertyDescriptor(f.getName(), original.getClass()).getReadMethod().invoke(original);
				new PropertyDescriptor(f.getName(), original.getClass()).getWriteMethod().invoke(clone, o);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static <T> void cloneMethod1(T original, T clone) {
		Method[] methods = original.getClass().getDeclaredMethods();
		Field[] fields = original.getClass().getDeclaredFields();
		
		for(Field f: fields) {
			for(Method m: methods) {
				String mName = m.getName().toLowerCase();
				if(mName.startsWith("set") && mName.contains(f.getName().toLowerCase())) {
					try {
						Object val = null;
						for(Method m2: methods) {
							String mName2 = m2.getName().toLowerCase();
							if(mName2.startsWith("get") && mName2.contains(f.getName().toLowerCase())) {
								val = m2.invoke(original);
							}
						}
						m.invoke(clone, val);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}			
		}
	}
	
	public static <T> void clone(T original, T clone) {
		cloneMethod2(original, clone);
	}
}
