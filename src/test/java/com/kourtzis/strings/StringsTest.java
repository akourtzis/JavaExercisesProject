package com.kourtzis.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

class StringsTest {
    @Test
	public void revertTest() {
		String str = "test";
		String revStr = Strings.revert(str);
		
		assertEquals("tset", revStr);
	}

	@Test
	public void monthFebTest() {
		String date = "05.02.2023";
		String month = Strings.monthAsString(date);

		assertEquals("Februar", month);
	}

	@Test
	public void invalidDateTest() {
		String expectedString = "Datum soll im Format \"dd.mm.yyyy\" angegeben werden.";
		String invalidDate = "22/35/2303.";

		String result = Strings.monthAsString(invalidDate);

		assertEquals(expectedString, result);
	}

    @ParameterizedTest
	@CsvSource(
			{
				"e  vi  l, live",
				"abc,c  b  a",
				"evil,live",
				"evil,l    i    ve",
				"      New York Times,      monkeys write              ",
				"Church of Scientology,            rich-chosen goofy cult"
				}
			)
	public void isAnagramTest(final String str1, final String str2) {
		assertTrue(Strings.isAnagram(str1, str2));
	}
	
	@ParameterizedTest
	@CsvSource(
			{
				"Hello,World!",
				"chur,churl",
				"Church of Scientology,            rich chosen goollfy cult",
				"Church of Scientolllogy,            rich chosen goofy cult",
				"nnn,mmm"
			}
			)
	public void isNotAnagramTest(final String str1, final String str2) {
		assertFalse(Strings.isAnagram(str1, str2));
	}
}