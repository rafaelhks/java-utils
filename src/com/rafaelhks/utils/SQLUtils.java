package com.rafaelhks.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Classe utilitaria.
 * @author Rafael Francisco Ferreira
 */
public class SQLUtils {
	
	/**
	 * Retorna um objeto String no formato "(obj0, obj1, ..., objN)".
	 * <p>
	 * Recomendado usar apenas objetos que possam ser convertidos 
	 * diretamente para string por meio do método toString()
	 *
	 * @author Rafael Francisco Ferreira
	 * @param  objs  an List of Java objects.
	 * @return Retorna um objeto String no formato "(obj0, obj1, ..., objN)", ou "()" caso <b>objs</b> seja nulo ou vazio.
	 */
	public static String sqlInFormat(List<? extends Object> objs) {
		if(objs!=null) {
			String res = "";
			
			for(Object o: objs) {
				res+=", "+sqlFormat(o);
			}
			
			if(res.length()>0) {
				return "("+res.substring(1)+")";
			}
			return "()";
		}else {
			return "()";
		}
	}
	
	/**
	 * Retorna um objeto String no formato "(obj0, obj1, ..., objN)".
	 * <p>
	 * Recomendado usar apenas objetos que possam ser convertidos 
	 * diretamente para string por meio do método toString()
	 *
	 * @author Rafael Francisco Ferreira
	 * @param  objs  an array of Java objects.
	 * @return Retorna um objeto String no formato "(obj0, obj1, ..., objN)", ou "()" caso <b>objs</b> seja nulo ou vazio.
	 */
	public static String sqlInFormat(Object[] objs) {
		if(objs!=null) {
			String res = "";
			
			for(Object o: objs) {
				res+=", "+sqlFormat(o);
			}
			
			if(res.length()>0) {
				return "("+res.substring(1)+")";
			}
			return "()";
		}else {
			return "()";
		}
	}

	/**
	 * Retorna um objeto String formatado para uso em querys SQL.
	 * <p>
	 * Recomendado usar apenas objetos que possam ser convertidos 
	 * diretamente para string por meio do método toString().
	 *
	 * @author Rafael Francisco Ferreira
	 * @param  o  an Java object that extends Object.
	 * @return <b>o</b> formatado em formato usado pelo SQL ou a String "null" caso o objeto seja nulo.
	 */
	public static String sqlFormat(Object o) {
		if(o!=null) {
			Class c = o.getClass();
			
			if(c.equals(String.class) || c.equals(Character.class)) {
				return "'"+o+"'";
			}
			
			else if(c.equals(Date.class)) {
				return "'"+toSQLTimeStamp((Date) o)+"'";
			}
			
			else if(c.equals(Boolean.class)) {
				return o.toString();
			}
			
			else if(c.getSuperclass().equals(Number.class)) {
				return o.toString();
			}
			
			return o.toString();
		}else {
			return "null";
		}
	}
	
	/**
	 * Retorna um objeto String contendo a data formatada no formato "yyyy-MM-dd".
	 * <p>
	 * Recomendado usar apenas objetos que possam ser convertidos 
	 * diretamente para string por meio do método toString().
	 *
	 * @author Rafael Francisco Ferreira
	 * @param  date  an Date object instance.
	 * @return <b>date</b> no formato "yyyy-MM-dd".
	 */
	public static String toSQLDate(Date date) {
		try {
			return format(date,"yyyy-MM-dd");
		}catch(Exception e) {
			e.printStackTrace();
			return "Err!";
		}
	}
	
	/**
	 * Retorna um objeto String contendo a data formatada no formato "yyyy-MM-dd hh:mm:ss".
	 * <p>
	 * Recomendado usar apenas objetos que possam ser convertidos 
	 * diretamente para string por meio do método toString().
	 *
	 * @author Rafael Francisco Ferreira
	 * @param  date  an Date object instance.
	 * @return <b>date</b> no formato "yyyy-MM-dd hh:mm:ss".
	 */
	public static String toSQLTimeStamp(Date date) {
		try {
			return format(date,"yyyy-MM-dd hh:mm:ss");
		}catch(Exception e) {
			e.printStackTrace();
			return "Err!";
		}
	}
	
	private static String format(Date date, String format) {
		try {
			SimpleDateFormat fmtr = new SimpleDateFormat(format);
			return fmtr.format(date);
		}catch(Exception e) {
			e.printStackTrace();
			return "Err!";
		}
	}
	
	public static void main(String args[]) {
		Object[] ss = {"OBJ1", new Date(), 10.0, true};
		System.out.println(sqlInFormat(ss));
	}
}
