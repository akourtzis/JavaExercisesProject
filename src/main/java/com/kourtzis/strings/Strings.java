package com.kourtzis.strings;

public class Strings {
    public static void main(String[] args) {
		// String invalidDate = "22/35/2303.";

		// String result = Strings.getMonth(invalidDate);
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

    // Aufgabe 4
	public static boolean isAnagram(final String str1, final String str2) {
		if(str1 == null || str2 == null) {
			throw new NullPointerException("Parameter should not be null");
		}
		
		if(str1.isBlank() && str2.isBlank()) {
			return true;
		}
		
		String str1New = removeAllNonLetters(str1);
		String str2New = removeAllNonLetters(str2);
			
		if(str1New.length() != str2New.length()) {
			return false;
		}
			
		char[] str1Arr = str1New.toLowerCase().toCharArray();
		StringBuilder tmpStr2 = new StringBuilder(str2New.toLowerCase());
			
		for(int it = 0; it < str1Arr.length; ++it) {
			String ch = "" + str1Arr[it];
			int index = tmpStr2.indexOf(ch);
					
			if(index != -1) {
				tmpStr2.deleteCharAt(index);
			}
			else {
				return false;
			}
		}
			
		return true;
	}
	
	public static String removeAllNonLetters(final String str) {
		if(str == null) {
			throw new NullPointerException("Parameter should not be null");
		}
		StringBuilder tempString = new StringBuilder(str.length());
		char[] strArr = str.strip().toCharArray();
		
		for(int it = 0; it < strArr.length; ++it) {
			if(Character.isLetter(strArr[it])) {
				tempString.append(strArr[it]);
			}
		}
		
		return tempString.toString();
	}

    //Aufgabe 5
	public static void palindrom(final String text) {
		String[] words = text.strip().split(" ");
		for(int it = 0; it < words.length; ++it) {
			if(isPalindrom(words[it])) {
				System.out.println(words[it]);
			}
		}
	}
	
	public static boolean isPalindrom(final String phrase) {
		String phraseWithoutWhiteSpaces = removeWhitespaceFromPhrase(phrase);
		char[] tmpWord = phraseWithoutWhiteSpaces.toLowerCase().toCharArray();
		int begin = 0;
		int end = phraseWithoutWhiteSpaces.length() - 1;
		
		for(; begin < phraseWithoutWhiteSpaces.length() / 2; ++begin, --end) {
			if(tmpWord[begin] != tmpWord[end]) {
				return false;
			}
		}
		
		return true;
	}

	public static String removeWhitespaceFromPhrase(final String text) {
		if(text == null) {
			throw new NullPointerException("String object is not supposed to be null");
		}

		StringBuilder tempText = new StringBuilder(text.length());
		char[] chArr = text.strip().toCharArray();

		for(int it = 0; it < chArr.length; ++it) {
			if(Character.isWhitespace(chArr[it])) {
				continue;
			}
			else {
				tempText.append(chArr[it]);
			}
		}

		return tempText.toString();
	}
}
