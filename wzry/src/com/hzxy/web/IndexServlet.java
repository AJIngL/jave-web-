package com.hzxy.web;



import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzxy.entity.Article;
import com.hzxy.entity.User;
import com.hzxy.entity.Zone;
import com.hzxy.service.ArticleService;
import com.hzxy.service.UserService;
import com.hzxy.service.ZoneService;


/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ZoneService zongService=new ZoneService();
	private ArticleService articleService=new ArticleService();

	 private UserService userService=new UserService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理乱码
	  request.setCharacterEncoding("utf-8");
		//获取版块列表数据
		//调用业务逻辑层获取版块列表
		List<Zone> zoneList = zongService.getZoneList();
		//将版块列表数据粗存储到域对象里面（request,session）==>request
		request.setAttribute("zoneList", zoneList);
		
		//域对象还需要存储一个当前浏览器板块id
				String zoneId = "";
				//获取zoneId 有两种方法
				//第一种： 客户端点击搜索的时候传过来zoneId；
				//第二种：类似于登录成功直接访问indexServlet，直接获取默认值；
				zoneId = request.getParameter("zoneId");
				
				if(zoneId==null || "".equals(zoneId)){
				for (Zone zone : zoneList) {
					if(zone.getIsDef()==1){
						//获取当前用户浏览板块的id
						zoneId = zone.getZoneId()+"";
						break;
					}
				}
				}
				//获取搜索标题的关键字
				String title =request.getParameter("title");
				 //  根据这两个条件去业务逻辑类去articleService查询符合条件的帖子列表
				List<Article> articleList=articleService.getAricleList(zoneId, title);
		        request.setAttribute("articleList", articleList);
				 //  目录最终将帖子列表显示到inde.jsp 页面去，所以要将articleList 存储到域对象里
		       
				//将当前用户浏览的板块id存储到域对象里面到index.jsp里面去用
				request.setAttribute("zoneId", zoneId);
				request.setAttribute("title", title);
				
				
				//获取在线用户列表
				List<User> onlineUserList =  userService.getOnlineUserList();
				//将在线列表用户存储到域对象里面
				request.setAttribute("onlineUserList", onlineUserList);
				//将在线用户的人数存储到域对象里面
				request.setAttribute("onlineNums", onlineUserList.size());
				
				//读取首页需要的贴子数
				Map<String,Object> articles = articleService.getArticleNumber();
				request.setAttribute("articles", articles);


		//页面跳转到index.jsp去显示(请求转发)
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
