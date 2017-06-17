package com.jinrui.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Title: DateTest.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-6-15 ÉÏÎç11:45:36
 */

public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String stamp = format.format(date);
        System.out.println(stamp);
	}

}
