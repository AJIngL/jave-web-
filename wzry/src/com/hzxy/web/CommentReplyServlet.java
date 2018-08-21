package com.hzxy.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzxy.entity.CommentReply;
import com.hzxy.entity.User;
import com.hzxy.service.ComentRepleyService;

/**
 * Servlet implementation class CommentReplyServlet
 * @param <CommentReplyService>
 */
public class CommentReplyServlet extends HttpServlet {
	
       private ComentRepleyService comentRepleyService = new ComentRepleyService();
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		String commentId =request.getParameter("commentId");
		String  replyContent=request.getParameter("content");
		
		User user=(User) request.getSession().getAttribute("loginUser");
		if(user==null){
			response.sendRedirect("index");
			return ;
		}
		
		int userId=user.getUserId();
		String replyName=user.getUserName();
		String picUrl=user.getPicUrl();
		
		CommentReply commentReply=new CommentReply(userId,Integer.parseInt(commentId),
				replyContent,null,replyName,picUrl);
		
		comentRepleyService.addCommentReply(commentReply);
		response.sendRedirect("detail?articleId="+request.getParameter("articleId"));
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
