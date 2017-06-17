package com.jinrui.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Title: ImageHelper.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-6-15 ÉÏÎç11:52:18
 */

public class ImageHelper {

	public static String generateName(String originalName){
		String extensionName = originalName.substring(originalName.lastIndexOf("."));
		
		Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String stamp = format.format(date);
        //System.out.println(stamp);
        return stamp+extensionName;
	}
}
