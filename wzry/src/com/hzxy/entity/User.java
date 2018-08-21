package com.hzxy.entity;
import java.io.Serializable;
public class User implements Serializable{
	
	private int userId;
	private String userName;
	private String userPass;
	private String email;
	private String picUrl;
	private int role;//'1代表普通用户，2代表管理员'
	private String lastLoginTime;
	private int loginStatus;//'0-不在线 ，1-在线'
	private int talkStatus;//'0-未屏蔽发言（默认），1-已屏蔽发言'
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public int getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
	public int getTalkStatus() {
		return talkStatus;
	}
	public void setTalkStatus(int talkStatus) {
		this.talkStatus = talkStatus;
	}
	public User(int userId, String userName, String userPass, String email, String picUrl, int role,
			String lastLoginTime, int loginStatus, int talkStatus) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.email = email;
		this.picUrl = picUrl;
		this.role = role;
		this.lastLoginTime = lastLoginTime;
		this.loginStatus = loginStatus;
		this.talkStatus = talkStatus;
	}
	public User(String userName, String userPass, String email, String picUrl, int role, String lastLoginTime,
			int loginStatus, int talkStatus) {
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.email = email;
		this.picUrl = picUrl;
		this.role = role;
		this.lastLoginTime = lastLoginTime;
		this.loginStatus = loginStatus;
		this.talkStatus = talkStatus;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + ", email=" + email
				+ ", picUrl=" + picUrl + ", role=" + role + ", lastLoginTime=" + lastLoginTime + ", loginStatus="
				+ loginStatus + ", talkStatus=" + talkStatus + "]";
	}
	

}
