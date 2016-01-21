package com.lawyer.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String datestr = "2016��1��21��";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy��MM��dd��");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf2.parse(datestr.toString());
			System.out.println(sdf1.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
