package com.vtiger.comcast.genericUtility;

import java.util.Date;
import java.util.Random;


/**
 * 
 * @author Dk
 *
 */

public class JavaUtility {
	/**
	 * its used to generate random number
	 * @return int data
	 */
	public int getRanDomNumber() {
		Random random = new Random();
		int intRandom = random.nextInt(10000);
		return intRandom;
	}
	/**
	 * used to get system date and time in IST format
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date = new Date();
		return date.toString();

	}

	/**
	 * used to get system date in YYY-MM-DD format
	 * @return
	 */
	public String getSystemDateWithFormate() {
		Date date = new Date();
		String dateAndTime = date.toString();

		String yyyy = dateAndTime.split(" ")[5];
		String dd = dateAndTime.split(" ")[2];
		int mm = date.getMonth()+1;

		String finalFormate = yyyy+"-"+mm+"-"+dd;
		return finalFormate;

	}

}
