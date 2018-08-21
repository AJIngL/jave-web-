package com.hzxy.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hzxy.entity.User;
import com.hzxy.tool.MyDBUtils;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理post提交数据中文乱码问题
		request.setCharacterEncoding("utf-8");
		
		//1.获取客户端用户输入的数据
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		String email = request.getParameter("email");
		
		try {
			//2.注册是应检查用户名是否已经被注册
			String sql = "select * from tb_user where userName=?";
			User user = MyDBUtils.runner.query(sql, new BeanHandler<User>(User.class),userName);
			boolean isSuccess = true; //标识注册成功
			if(user!=null){
				isSuccess = false;
			}
			//3.向数据库注册数据
			if(isSuccess){
				sql = "INSERT INTO tb_user ( userName, userPass, email, picUrl, role, lastLoginTime, loginStatus, talkStatus)"+ 
										" VALUES ( ?, ?, ?, '', '1', NULL, '0', '0')";
				MyDBUtils.runner.update(sql, userName,userPass,email);
				//4.注册成功去index.jsp
				request.getRequestDispatcher("index.jsp").forward(request, response);
				//使用页面重定向跳转
				//response.sendRedirect("index.jsp");

			}else{
				request.setAttribute("msg", "注册失败，用户名已经被注册了");
				//5.注册失败去register.jsp并显示错误消息
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//查询发生数据库异常，网络异常
		}
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
