package com.rafaelhks.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.swing.text.MaskFormatter;

public class StringUtils {

	public static String wordwrap(String base, int regex){
        String rsm = base;
        boolean gotspace = false;
        boolean gotfeed = false;
        
        int pos = regex;
        while (pos < rsm.length()){
             int bf = pos-regex; 
             gotspace = false;
             gotfeed = false;
             
             for (int ap=pos; ap>bf; ap--){
                  if (String.valueOf(rsm.charAt(ap)).equals(" ") == true && gotspace == false){
                       gotspace=true;
                       pos = ap;
                  }
                  else if (String.valueOf(rsm.charAt(ap)).equals("<br>") == true && gotfeed == false){
                       pos = ap;
                       gotfeed = true;
                  }
             }
             if (gotfeed == false){
                  if (gotspace == false){rsm = new StringBuffer(rsm).insert(pos, "<br>").toString();}
                  else{rsm = new StringBuffer(rsm).insert(pos+1, "<br>").toString();}
             }
             pos += (regex+1);
        }
        return (rsm);
    }
	
	public static String customFormat(String value,String format){
        try {
        	MaskFormatter mask = new MaskFormatter(format);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (Exception e) {
        	return "***********";
        }
	}
	
	public static String leftPadding(String s, String pad, int totalLength) {
		if(totalLength<s.length()) {
			return s;
		}else {
			String ret = "";
			while(ret.length()<s.length()+totalLength) {
				ret+=pad;
			}
			ret+=s;
			return ret.substring(ret.length()-totalLength, ret.length());
		}
	}
	
	public static String rightPadding(String s, String pad, int totalLength) {
		if(totalLength<s.length()) {
			return s;
		}else {
			while(s.length()<totalLength) {
				s+=pad;
			}
			return s.substring(0,totalLength);
		}
	}
	
	public static String remove(String s, String charsToRemove) {
		try {
			return s.replaceAll("["+charsToRemove+"]", "");
		} catch (Exception e) {
			e.printStackTrace();
			return s;
		}
	}
	
	public static String sha256(String s) {
		return hash(s,"SHA-256");
	}
	
	public static String sha512(String s) {
		return hash(s,"SHA-512");
	}
	
	private static String hash(String s, String algorithm) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);
			byte[] encodedhash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
			return bytesToHex(encodedhash);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
}
