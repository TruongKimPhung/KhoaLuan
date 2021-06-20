package com.dtu.Commom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GetDate {

	public Date getcurrentDay() throws ParseException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		Date date = formatter.parse(dtf.format(now));
		return date;
	}
}
