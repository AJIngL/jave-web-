package com.hzxy.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzxy.service.UserService;

/**
 * 只负责调度产生动态资源数据
 */
public class Register2Servlet extends HttpServlet {

	//实例业务逻辑类
	UserService userService = new UserService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理post提交数据中文乱码问题
		request.setCharacterEncoding("utf-8");
		
		//1.获取客户端用户输入的数据
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		String email = request.getParameter("email");
		
		//3.调用业务逻辑处理类处理用户注册业务
		if(userService.registerUser(userName,userPass,email)){
			//注册成功
			//request.getRequestDispatcher("index.jsp").forward(request, response);
			//使用页面重定向跳转
			response.sendRedirect("index");
		}else{
			//注册失败
			request.setAttribute("msg", "注册失败，用户名已经被注册了");
			//5.注册失败去register.jsp并显示错误消息
			request.getRequestDispatcher("register.jsp").forward(request, response);
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
