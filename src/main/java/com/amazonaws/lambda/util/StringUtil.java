package com.amazonaws.lambda.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class StringUtil {

	public static LocalDate fomatLocalDate(String pattern, String date) {
		LocalDate result = null;
		String text = date.trim();
		if(date != null && "".equals(text) == false) {
			result = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
		}
		return result;
	}
}