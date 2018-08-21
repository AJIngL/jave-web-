package com.hzxy.service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hzxy.dao.ArticleDao;
import com.hzxy.entity.Article;

/**
 * 帖子业务逻辑处理类
 * @author HZXY
 *
 */
public class ArticleService {
	private ArticleDao articleDao = new ArticleDao();

	/**
	 * 发帖方法
	 * @param article
	 */
	public void addArticle(Article article) {
		//封装属性postTime
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		article.setPostTime(time);
		//调用数据库访问类进行发帖
		articleDao.insertArticle(article);
		
	}
	
	public List<Article> getAricleList(String zoneId,String title){
		return articleDao.getArticleList(zoneId,title);
	}
	
	/**
	 *	查询今日帖子数与全部帖子数
	 * @return
	 */
	public Map<String,Object> getArticleNumber(){
		return articleDao.getArticleNumber();
	}

	public Article readArticle(String articleId) {
		articleDao.updateReadCount(articleId);
		return articleDao.getArticleById(articleId);
	}

	
	/**
	 *	读取指定的帖子
	 * @return
	 */

	
}



