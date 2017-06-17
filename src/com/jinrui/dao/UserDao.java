package com.jinrui.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jinrui.domain.User;

/**
 * <p>Title: UserDao.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-6-9 ÏÂÎç2:37:43
 */

public class UserDao {

	public User getByUsernameAndPassword(String username,String password){
		String sql = "select * from user where username='"+username+"' and password='"+password+"'";
		User user = new User();
  
        try {  
        	DBHelper db = new DBHelper();
        	Connection conn = db.getConnection();
        	PreparedStatement pst = conn.prepareStatement(sql);
        	ResultSet ret = pst.executeQuery();
            while (ret.next()) {  
            	user.setId(ret.getInt(1));  
            	user.setUsername(ret.getString(2));
            	user.setPassword(ret.getString(3));
            	user.setCreateTime(ret.getDate(4));
                
            }
            ret.close();  
            pst.close();
            conn.close();
            return user;
            
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        
        return null;
	}
	
	public void insert(User user){
		DBHelper db = new DBHelper();
    	Connection conn = db.getConnection();
        String sql="insert into user (username,password,create_time) values (?,?,?)";  
        try {  
            PreparedStatement preStmt=conn.prepareStatement(sql);  
            preStmt.setString(1, user.getUsername());  
            preStmt.setString(2, user.getPassword());  
            preStmt.setDate(3, new java.sql.Date(user.getCreateTime().getTime()) );
              
            preStmt.executeUpdate();  
              
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } 
	}
	
	public ArrayList<User> getAll(){
		String sql = "select * from user";
		
		ArrayList<User> userList = new ArrayList<User>();
        try {  
        	DBHelper db = new DBHelper();
        	Connection conn = db.getConnection();
        	PreparedStatement pst = conn.prepareStatement(sql);
        	ResultSet ret = pst.executeQuery();
            while (ret.next()) {  
            	User user = new User();
            	user.setId(ret.getInt(1));  
            	user.setUsername(ret.getString(2));
            	user.setPassword(ret.getString(3));
            	user.setCreateTime(ret.getDate(4));
            	userList.add(user);
                
            }
            ret.close();  
            pst.close();
            conn.close();
            
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        return userList;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		//User user = userDao.getByUsernameAndPassword("jack", "123456");
		//System.out.println(user.getCreateTime());
		//User user = new User();
		//user.setUsername("Mike");
		//user.setPassword("123");
		//user.setCreateTime(new java.util.Date());
		//userDao.insert(user);
		ArrayList<User> userList = userDao.getAll();
		for (User user : userList) {
			System.out.println("username:"+user.getUsername()+",password:"+user.getPassword());
		}
	}

}
