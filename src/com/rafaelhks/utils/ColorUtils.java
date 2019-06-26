package com.rafaelhks.utils;

import java.util.ArrayList;
import java.util.List;

public class ColorUtils {

	public static String getRandomHex() {
		String [] letters = new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	    String color = "";
	    for (int i = 0; i < 6; i++ ) {
	    	double ind = Math.random() * 15;
            int index = (int)Math.round(ind);
            color += letters[index]; 
	    }
	    
	    return color;
	}
	
	public static String[] getRandomHexArray(int size) {
		List<String> colors = new ArrayList<String>();
		
		for (int i = 0; i < size; i++) {
			String hex = getRandomHex();
			while(colors.contains(hex)) {
				hex = getRandomHex();
			}
			colors.add(hex);
		}
		
		String[] ret = new String[size];
		colors.toArray(ret);
		return ret;
	}
}
