package com.rafaelhks.utils;
/**
 * Class to handle possible null objects.
 * @author Rafael Francisco Ferreira
 */
public class NullHandler {
	
	/**
	 * If <b>obj</b> is not null, this method returns <b>obj</b> itself. 
	 * In case <b>obj</b> is null or any possible Exception occurs, returns <b>def</b>.
	 *
	 * @author Rafael Francisco Ferreira
	 * @param  obj  The object to check.
	 * @param  def	The object to return if <b>obj</b> is null.
	 * @return <b>obj</b> if <b>obj</b>!=null is true, or <b>def</b> if <b>obj</b>!=null is false.
	 */
	public static <T> T handle(T obj, T def) {
		try {
			if(obj!=null) {
				return obj;
			}else{
				return def;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return def;
		}
	}
	
	/**
	 * Checks if <b>obj</b> is null. This method is a utility to 
	 * evite the use of <b>null</b> comparison like "obj==null".
	 *
	 * @author Rafael Francisco Ferreira
	 * @param  obj  The object to check.
	 * @return true if <b>obj</b> is null or false if it is not.
	 */
	public static <T> boolean isNull(T obj) {
		return obj==null;
	}
	
	/**
	 * Checks if <b>obj</b> is not null. This method is a utility to 
	 * evite the use of <b>null</b> comparison like "obj!=null".
	 *
	 * @author Rafael Francisco Ferreira
	 * @param  obj  The object to check.
	 * @return true if <b>obj</b> is not null or false if it is.
	 */
	public static <T> boolean isNotNull(T obj) {
		return obj!=null;
	}
	
	/**
	 * Checks if <b>s</b> is null or empty String.
	 *
	 * @author Rafael Francisco Ferreira
	 * @param  s  The object to check. Must be a String object.
	 * @return true if <b>s</b> is null or empty.
	 */
	public boolean nullOrEmpty(String s) {
		if(s!=null && s.length()>0 && !s.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Checks if <b>n</b> is null or zero Number.
	 *
	 * @author Rafael Francisco Ferreira
	 * @param  n  The object to check. Must extend Number class.
	 * @return true if <b>n</b> is null or zero.
	 */
	public boolean nullOrZero(Number n) {
		if(n!=null && n.doubleValue()!=0) {
			return false;
		} else {
			return true;
		}
	}
}
