package com.motelmanager.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTool {
	
	public static String dateToStringWithFormat(Date date, String format){
		if(date != null && (format != null && !format.isEmpty())){
			return "'"+ (new SimpleDateFormat(format).format(date)) + "'";
		}
		return null;
	}

}
