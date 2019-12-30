package com.xiaomi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTool {
	/*
	 	y 年
	 	M 月
	 	d 天
	 	H24时 h12时
	 	m 分
	 	s 秒
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//日期转字符串的方法
	public static String dateToString(Date date) {
		return sdf.format(date);
	}
	
	//字符串转日期的方法
	public static Date stringToDate(String dateStr) {
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}














