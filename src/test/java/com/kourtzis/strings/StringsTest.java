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