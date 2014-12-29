package com.motelmanager.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTool {
	
	public static String dateToStringWithFormat(Date date, String format){
		if(date != null && (format != null && !format.isEmpty())){
			return "'"+ (new SimpleDateFormat(format).format(date)) + "'";
		}
		return null;
	}
	
	public static Date stringToDate(String dateSt){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	 
		Date date = null;
		try {
			date = formatter.parse(dateSt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
