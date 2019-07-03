package com.rafaelhks.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static Date getDate(int day, int month, int year) {
		try {
			Calendar c = Calendar.getInstance();
			if(day>31) {
				day = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			}
			if(day<=0) {
				day = c.getActualMinimum(Calendar.DAY_OF_MONTH);
			}
			c.set(year, month, day);
			return c.getTime();
		} catch (Exception e) {
			return new Date();
		}
	}

	public static Date firstDayOfYear(int year) {
		return getDate(1,0,year);
	}
	
	public static Date lastDayOfYear(int year) {
		return getDate(32,11,year);
	}
	
	public static Integer firstDayOfMonth(int month) {
		try {
			Calendar c = Calendar.getInstance();
			c.set(Calendar.MONTH, month);
			return c.getActualMinimum(Calendar.DAY_OF_MONTH);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static Integer lastDayOfMonth(int month) {
		try {
			Calendar c = Calendar.getInstance();
			c.set(Calendar.MONTH, month);
			return c.getActualMaximum(Calendar.DAY_OF_MONTH);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static String format(Date date, String format) {
		try {
			SimpleDateFormat fmtr = new SimpleDateFormat(format);
			return fmtr.format(date);
		}catch(Exception e) {
			e.printStackTrace();
			return "Err!";
		}
	}
	
	public static int difference(String data1, String data2) {  
        try {
            SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");  
            return difference(sdf.parse(data1), sdf.parse(data2));
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} 
    } 
	
	public static int difference(Date data1, Date data2) {  
		try {
	        long difTempo = data2.getTime() - data1.getTime();  
	        return (int) ((difTempo + 60L * 60 * 1000) / (24L * 60 * 60 * 1000)) + 1; 
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
    } 
	
	public static Date toDate(LocalDate date) {
		try {
			Calendar c = Calendar.getInstance();
			c.set(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
			return c.getTime();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getTime(Date date) {
		return format(date, "hh:mm:ss");
	}
	
	public static int getDay(Date date) {
		return extractField(date, Calendar.DAY_OF_MONTH);
	}
	
	public static int getMonth(Date date) {
		return extractField(date, Calendar.MONTH);
	}
	
	public static int getYear(Date date) {
		return extractField(date, Calendar.YEAR);
	}
	
	public static int getHour(Date date) {
		return extractField(date, Calendar.HOUR_OF_DAY);
	}
	
	public static int getMinute(Date date) {
		return extractField(date, Calendar.MINUTE);
	}
	
	public static int getSecond(Date date) {
		return extractField(date, Calendar.SECOND);
	}
	
	public static int getMillis(Date date) {
		return extractField(date, Calendar.MILLISECOND);
	}
	
	private static int extractField(Date date, int field) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			return c.get(field);
		} catch (Exception e) {
			return -1;
		}
	}
}
