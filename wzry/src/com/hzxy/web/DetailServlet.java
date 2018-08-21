package com.hzxy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzxy.entity.Article;
import com.hzxy.entity.Comment;
import com.hzxy.entity.CommentReply;
import com.hzxy.entity.User;
import com.hzxy.service.ArticleService;
import com.hzxy.service.ComentRepleyService;
import com.hzxy.service.CommentService;
import com.hzxy.service.UserService;

/**
 * Servlet implementation class DetailServlet
 */
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

     private ArticleService articleService=new ArticleService();
     private UserService userService =new UserService();
     private CommentService commentService=new CommentService();
	private  ComentRepleyService comentRepleyService =new ComentRepleyService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String articleId=request.getParameter("articleId");
		Article article =articleService.readArticle(articleId);
		User user=userService.getUserById(article.getUserId());
		request.setAttribute("poster", user);
		request.setAttribute("article", article);
		
		
		
		List<Comment> commentList=commentService.getCommentsByArticleId(Integer.parseInt(articleId));
		
		if(commentList!=null){
			for(Comment comment:commentList){
				List<CommentReply> commentReplies=comentRepleyService.getCommentReplyListByCommentId(comment.getCommentId());
				comment.setCommentReplies(commentReplies);
			}
		}
			

		
		request.setAttribute("commentList", commentList);
		
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
