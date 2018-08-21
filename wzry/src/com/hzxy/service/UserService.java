package com.hzxy.service;

import java.util.List;

import com.hzxy.dao.UserDao;
import com.hzxy.entity.User;
import com.hzxy.tool.MyDBUtils;

/**
 * 用户业务逻辑处理类
 * @author HZXY
 *
 */
public class UserService {
	//实例化了数据库操作类
	private UserDao userDao = new UserDao();

	/**
	 * 用户注册方法处理
	 * @param userName
	 * @param userPass
	 * @param email
	 * @return true代表注册成功，false代表注册失败
	 */
	public boolean registerUser(String userName, String userPass, String email) {
		//1.调用数据访问类判断用户名是否已被注册
		if(userDao.isExists(userName)){
			return false;
		}
		//用户名没有被注册过
		//调用数据操作类进行向数据库添加用户
		userDao.addUser(userName,userPass,email);
		return true;
	}
	
	
	
	/**
	 * 登录的方法
	 * @param userName
	 * @param userPass
	 * @param loginCommon
	 * @return
	 */
	public User login(String userName, String userPass, int loginrole) {
		//调用数据访问类根据用户名查找对应用户
		User loginUser = userDao.selectUser(userName);
		if(loginUser!=null){
			//登录的用户存在
			if(loginUser.getUserPass().equals(userPass)){
				
				//验证登录成功，更新登录状态
				//调用数据库根据用户的ID（主键）更新当前用户的登录状态
				userDao.updateLoginStatus(loginUser.getUserId(),MyDBUtils.Login_Online);

				return loginUser;
			}else{
				//密码错误清空user
				loginUser = null;
			}
		}
		return loginUser;
	}
	
	//更新用户 状态为不在线
   public boolean unlineUser(int userId){
	   userDao.updateLoginStatus(userId, MyDBUtils.login_Unline);
	   return true;
   }



public List<User> getOnlineUserList() {

	return userDao.getOnlineUserList();
}
 public User getUserById(int userId){
	 return userDao.getUserById(userId);
 }

}

