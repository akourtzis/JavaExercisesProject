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

    //Aufgabe 3
	public static String monthAsString(final String str) {
		if(checkDateFormat(str)) {
			return getMonth(str);
		}
		
		return "Datum soll im Format \"dd.mm.yyyy\" angegeben werden.";
	}
	
	public static boolean checkDateFormat(final String str) {
		return str.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
	}
	
	public static String getMonth(final String str) {
		String[] date = str.split("\\.");
		String month = date[1];
		
		switch(month) {
		case "01":
			return "Januar";
		case "02":
			return "Februar";
		case "03":
			return "Marz";
		case "04":
			return "April";
		case "05":
			return "Mai";
		case "06":
			return "Juni";
		case "07":
			return "Juli";
		case "08":
			return "August";
		case "09":
			return "September";
		case "10":
			return "Oktober";
		case "11":
			return "November";
		case "12":
			return "Dezember";
		default:
			return "Unbekannter Monat";
		
		}
	}
}
