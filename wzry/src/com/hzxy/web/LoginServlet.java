package com.hzxy.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hzxy.entity.User;
import com.hzxy.service.UserService;
import com.hzxy.tool.MyDBUtils;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理post提交中文乱码
		request.setCharacterEncoding("utf-8");
		
		//1.获取数据
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		
		//2.调用业务处理类进行登录操作
		User loginUser = userService.login(userName,userPass,MyDBUtils.Login_Common);
		
		if(loginUser!=null){
			//要将登录用户的数据存储到session中
			//1.获取session
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			//登录成功(重定向跳转时2次请求)
			//response.sendRedirect("index");
			response.sendRedirect(request.getHeader("referer"));
		}else{
			//登录不成功
			request.setAttribute("loginMsg", "登录失败，输入的用户名或密码错误");
			//返回登录页面
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
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
