package com.rafaelhks.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Utility class to deal with objects that extend from Number class.
 * Dependencies: NullHandler class.
 * @author Rafael Francisco Ferreira
 */
public class NumericUtils {
	
	public static String C_USD[] = {"en","US"}, C_BRL[] = {"pt","BR"};
	
	public static AtomicInteger toAtomicInteger(Number num) {
		return new AtomicInteger(NullHandler.handle(num, 0).intValue());
	}

	public static AtomicLong toAtomicLong(Number num) {
		return new AtomicLong(NullHandler.handle(num, 0).longValue());
	}

	public static BigDecimal toBigDecimal(Number num) {
		return new BigDecimal(NullHandler.handle(num, 0).toString());
	}

	public static BigInteger toBigInteger(Number num) {
		try {
			Long n = num.longValue();
			return new BigInteger(n.toString());
		} catch (Exception e) {
			return new BigInteger("0");
		}
	}

	public static Byte toByte(Number num) {
		return NullHandler.handle(num, 0).byteValue();
	}

	public static Double toDouble(Number num) {
		return NullHandler.handle(num, 0).doubleValue();
	}

	public static Float toFloat(Number num) {
		return NullHandler.handle(num, 0).floatValue();
	}

	public static Integer toInteger(Number num) {
		return NullHandler.handle(num, 0).intValue();
	}

	public static Long toLong(Number num) {
		return NullHandler.handle(num, 0).longValue();
	}

	public static Short toShort(Number num) {
		return NullHandler.handle(num, 0).shortValue();
	}
	
	public static String formatDecimal(Number num) {
		try{
			DecimalFormat df2 = new DecimalFormat("#,##0.00",new DecimalFormatSymbols(new Locale("pt","BR"))); 
			return df2.format(num);
		}catch(Exception e){
			e.printStackTrace();
			return "0,00";
		}
	}
	
	public static String formatDecimal(Number num, int decimalPlaces) {
		try{
			DecimalFormat df2 = new DecimalFormat("#,##0.00",new DecimalFormatSymbols(new Locale("pt","BR"))); 
			df2.setMaximumFractionDigits(decimalPlaces);
			df2.setMinimumFractionDigits(decimalPlaces);
			
			return df2.format(num);
		}catch(Exception e){
			e.printStackTrace();
			return "0,00";
		}
	}
	
	public static String formatBRL(Number num) {
		try{
			NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
			moneyFormat.setRoundingMode(RoundingMode.HALF_EVEN);
			return moneyFormat.format(num);
		}catch(Exception e){
			e.printStackTrace();
			return "R$ err";
		}
	}
	
	public static String formatMoney(Number num, String[] cur) {
		try{
			NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(new Locale(cur[0],cur[1]));
			return moneyFormat.format(num);
		}catch(Exception e){
			e.printStackTrace();
			return "R$ err";
		}
	}
	
	public static String formatPerc(Number num, int decimalPlaces) {
		try{
			NumberFormat nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(decimalPlaces);
			nf.setMinimumFractionDigits(decimalPlaces);
			return nf.format(num)+"%";
		}catch(Exception e){
			e.printStackTrace();
			return "err%";
		}
	}
	
	public static Number sum(Number n1, Number n2) {
		try {
			return new BigDecimal(n1.toString()).add(new BigDecimal(n2.toString()));
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static Number subtract(Number n1, Number n2) {
		try {
			return new BigDecimal(n1.toString()).subtract(new BigDecimal(n2.toString()));
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static Number multiply(Number n1, Number n2) {
		try {
			return new BigDecimal(n1.toString()).multiply(new BigDecimal(n2.toString()));
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static Number divide(Number n1, Number n2) {
		try {
			return new BigDecimal(n1.toString()).divide(new BigDecimal(n2.toString()));
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static Number parseString(String s) {
		try {
			return new BigDecimal(s);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
