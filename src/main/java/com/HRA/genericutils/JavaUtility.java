package com.HRA.genericutils;

import java.util.Date;
import java.util.Random;

/**
 * This class contain Java related methods
 * @author Nixon
 */
public class JavaUtility {
	/**
	 * This method is used to get the random number
	 * @return
	 */
	public int getRandomeNumer() {
		Random ran = new Random();
		int randomNum= ran.nextInt(500);
		return randomNum;
		
	}
	
	/**
	 * This method is used to get the range random number
	 * @return
	 */
	public int getRandomeRangeNumer() {
		Random ran = new Random();
		int randomNum= ran.nextInt(100,999);
		return randomNum;
		
	}
	
	/**
	 * This method is used to fetch system date in required format
	 * @return
	 */
	public String getSystemDate()
	{
	 Date date = new Date();
	return date.toString();
	
	}
	
	/**
	 * This method is used to fetch system date in required format    h
	 * @return
	 */
	public static String getSystemDateInFormat() {
		{
			Date dateTime = new Date();
			String[] d = dateTime.toString().split(" ");
			
			String day = d[0];
			String month =d[1];
			Object date =d[2];
			String year = d[5];
			
			String finalFormat= day+" "+month+" "+date+" "+year;
			return finalFormat;
		}
	
	}
}
