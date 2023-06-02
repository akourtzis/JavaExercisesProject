package com.kourtzis.strings;

public class Strings {
    public static void main(String[] args) {

    }
    
    // Aufgabe 2
	public static String revert(final String str) {
		char[] tempStr = str.toCharArray();
		char[] revStr = new char[tempStr.length];
		
		for(int it = revStr.length - 1, index = 0; it >= 0; --it, ++index) {
			revStr[index] = tempStr[it];
		}
		
		return String.valueOf(revStr);
	}
}
