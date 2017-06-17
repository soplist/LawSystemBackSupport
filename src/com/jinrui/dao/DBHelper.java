package com.jinrui.dao;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;

/**
 * <p>Title: DBHelper.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-6-9 ÏÂÎç2:33:33
 */

public class DBHelper {
	public static final String url = "jdbc:mysql://localhost/law_170609";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "wangkang";  
  
    public Connection conn = null;  
  
    public DBHelper() {  
        
    }  
    
    public Connection getConnection(){
    	try {  
        	Class.forName(name);
            return conn = DriverManager.getConnection(url, user, password);
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    	return null;
    }
  
}
