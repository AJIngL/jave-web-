package com.hzxy.tool;

import org.apache.commons.dbutils.QueryRunner;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyDBUtils {
	public static final int Login_Common=1;
	public static final int Login_Admin=2;

	public static final int Login_Online = 1; //登录在线
	public static final int login_Unline = 0; //不在线

	public static final int Comment_Status_PingBi = 1; 
	public static final int Comment_Status_Default= 0; 
	/**
	 * 数据库操作工具类
	 */
	public static QueryRunner runner;
	static {
		runner = new QueryRunner(new ComboPooledDataSource());
	}

}
