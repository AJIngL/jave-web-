package com.hzxy.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hzxy.entity.User;
import com.hzxy.tool.MyDBUtils;

/**
 * 用户数据库操作类
 * dao ,data access object,数据访问对象
 * @author HZXY
 *
 */
public class UserDao {

	/**
	 * 判断用户名是否存在
	 * @param userName
	 * @return true代表已存在，false代表不存在
	 */
	public boolean isExists(String userName) {
		try {
			String sql = "select * from tb_user where userName=?";
			User user = MyDBUtils.runner.query(sql, new BeanHandler<User>(User.class), userName);
			//user 如果不为空，用户名被注册了，返回true
			return user!=null;
		} catch (SQLException e) {
			e.printStackTrace();
			//异常分为编译时异常，运行时异常
			//	编译，就是开放工具会在代码保存的时刻动态将.java代码编译成.class文件
			//	编译时异常，就是java代码语法检查的时候认为可能发生异常就直接报错，一定要处理
			//	RuntimeException运行时异常，在运行的时候真正发生了异常才会抛异常，否则不会抛出，运行时异常不需要处理
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加用户的方法
	 * @param userName
	 * @param userPass
	 * @param email
	 */
	public void addUser(String userName, String userPass, String email) {
		try {
			String sql = "INSERT INTO tb_user ( userName, userPass, email, picUrl, role, lastLoginTime, loginStatus, talkStatus)"+ 
					" VALUES ( ?, ?, ?, '', '1', NULL, '0', '0')";
			MyDBUtils.runner.update(sql, userName,userPass,email);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 根据用户名查找用户对象
	 * @param userName
	 * @return User
	 */
	public User selectUser(String userName) {
		try {
			String sql = "select * from tb_user where userName=?";
			User user = MyDBUtils.runner.query(sql, new BeanHandler<User>(User.class), userName);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * 更新用户的登录状态
	 * @param userId 更新用户的id
	 * @param loginOnline 更新登录的状态值
	 */
	public void updateLoginStatus(int userId, int loginOnline) {
		try {
			String sql = "update tb_user set loginStatus=? where userId=?";
			MyDBUtils.runner.update(sql, loginOnline,userId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	

	/**
	 *查询普通用户在线列表
	 * role=1 为在线
	 * loginStatus=1
	 */
	public List<User> getOnlineUserList(){
		String sql = "select *from tb_user where role=1 and loginStatus=1";
		try {
			
			return	MyDBUtils.runner.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 根据id获取user对象
	 * @param userId
	 * @return
	 */
	public User getUserById(int userId) {
		try {
			String sql = "SELECT * FROM tb_user WHERE userid=?";
			return MyDBUtils.runner.query(sql, new BeanHandler<User>(User.class),userId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


}
