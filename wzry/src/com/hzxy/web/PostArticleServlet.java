package com.hzxy.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzxy.entity.Article;
import com.hzxy.entity.User;
import com.hzxy.service.ArticleService;

/**
 * Servlet implementation class PostArticleServlet
 */
public class PostArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleService articleService = new ArticleService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取表单发贴数据
		//处理post提交乱码问题
		request.setCharacterEncoding("utf-8");
		//获取表单数据
		String zoneId = request.getParameter("zoneId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//userId
		int userId = -1;
		//posterName
		String posterName = null;
		User user = (User)request.getSession().getAttribute("loginUser");
		if(user!=null){
			userId = user.getUserId();
			posterName = user.getUserName();
		}
		//postTime,到业务逻辑处理去搞
		//封装数据
		Article article = new Article(userId, Integer.parseInt(zoneId), title, content, null, posterName, "0", 0, 0, 0);
		//调用业务逻辑层去发帖
		articleService.addArticle(article);
		//回到IndexServlet获取首页需要的动态数据之后再到index.jsp去显示动态数据
		response.sendRedirect("index?zoneId="+zoneId);//如果不需要传递数据给目标跳转页面建议使用response重定向，如果需要给跳转目标页面传递数据必须使用request请求转发跳转 
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
