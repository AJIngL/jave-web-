package com.hzxy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import com.hzxy.entity.Comment;
import com.hzxy.entity.User;
import com.hzxy.service.CommentService;

import com.hzxy.tool.MyDBUtils;

/**
 * Servlet implementation class CommentServlet
 */
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  private CommentService commentService=new CommentService();
   
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String articleId=request.getParameter("articleId");
		String commentContent=request.getParameter("content");
		
		User user=(User)request.getSession().getAttribute("loginUser");
		if(user ==null){
			response.sendRedirect("index");
			
		}
		int userId=user.getUserId();
		String commentUserName=user.getUserName();
		String pivUrl=user.getPicUrl();
		
		Comment comment=new Comment(Integer.parseInt(articleId),userId,commentContent,null,commentUserName,MyDBUtils.Comment_Status_Default,pivUrl);
		
		if( commentService.addComment(comment)){
			response.sendRedirect("detail?articleId="+articleId);
		}else{
			request.setAttribute("commentMsg", "评论不成功"); 
			request.getRequestDispatcher("detail?articleId="+articleId).forward(request, response);
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
