package com.jinrui.webservice;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.jws.WebService;

import sun.misc.BASE64Decoder;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.jinrui.dao.UserDao;
import com.jinrui.domain.User;
import com.jinrui.util.Constant;
import com.jinrui.util.ImageHelper;

/**
 * <p>Title: UserEndPoint.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time：2017-6-9 下午3:13:34
 */
@WebService
public class UserEndPoint {
	//http://localhost:8080/LawSystemBackSupport/userEndPoint
    private UserDao userDao;
    public UserEndPoint(){
    	userDao = new UserDao();
    }
    public User getByUsernameAndPassword(String username,String password){
    	return userDao.getByUsernameAndPassword(username, password);
    }
    
    public void insert(User user){
    	userDao.insert(user);
    }
    
    public String getAll(){
    	JSONObject returnJson = new JSONObject();  
    	JSONArray jsonArray = new JSONArray();
    	ArrayList<User> userList = userDao.getAll();
    	for (User user : userList) {
    		JSONObject json = new JSONObject(); 
    		json.put("id", user.getId()); 
    		json.put("username", user.getUsername());
    		json.put("password", user.getPassword());
    		json.put("createTime", user.getCreateTime().getTime());
    		jsonArray.add(json);
		}
    	returnJson.put("time",System.currentTimeMillis());  
        returnJson.put("data", jsonArray); 
    	return returnJson.toString();
    }
    
    public String uploadImage(String filename, String image) {   
        FileOutputStream fos = null;    
        try{    
            byte[] buffer = new BASE64Decoder().decodeBuffer(image);   //对android传过来的图片字符串进行解码     
            File destDir = new File(Constant.IMAGE_PATH);      
            if(!destDir.exists()) {  
                destDir.mkdir();    
            }  
            fos = new FileOutputStream(new File(destDir,ImageHelper.generateName(filename)));   //保存图片    
            fos.write(buffer);    
            fos.flush();    
            fos.close();    
            return "上传图片成功!" + "图片路径为：" + Constant.IMAGE_PATH;    

        }catch (Exception e){    

            e.printStackTrace();    

        }    

        return "上传图片失败！";    

    }  
}
