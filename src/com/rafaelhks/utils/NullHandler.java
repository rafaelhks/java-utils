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
}
