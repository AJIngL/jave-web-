package com.hzxy.dao;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.hzxy.entity.Article;
import com.hzxy.tool.MyDBUtils;

/**
 * 帖子数据访问类
 * @author HZXY
 *
 */
public class ArticleDao {

	/**
	 * 数据库发帖
	 * @param article
	 */
	public void insertArticle(Article article) {
		try {
			String sql ="insert into `tb_article` (`userId`, `zoneId`, `title`, `content`, `postTime`, `posterName`, `isTop`, `commentCount`, `likeCount`, `readCount`) "
					                                      + "values(?,?,?,?,?,?,?,?,?,?)";
			MyDBUtils.runner.update(sql, article.getUserId(),article.getZoneId(),article.getTitle(),article.getContent(),article.getPostTime(),
					article.getPosterName(),article.getIsTop(),article.getCommentCount(),article.getLikeCount(),article.getReadCount());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Article> getArticleList(String zoneId,String title){
		try{
			String sql="select *from tb_article where zoneid=?";
			//数据排序的要求，按照置顶和发帖时间降序，置顶在最上面
			if(title!=null && !"".equals(title)){
				sql+="and title like ? order by istop desc,postTime desc";
				return MyDBUtils.runner.query(sql, new BeanListHandler<Article>(Article.class),zoneId,"%"+title+"%");
			}else{
				sql+="order by istop desc,postTime Desc";
				return MyDBUtils.runner.query(sql, new BeanListHandler<Article>(Article.class),zoneId);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	public Map<String,Object> getArticleNumber(){
		try{
			String sql="SELECT COUNT(*) todayArticles,(SELECT COUNT(*) FROM tb_article) "
					+ "allArticles FROM tb_article WHERE postTime LIKE ?";
			String todayDate=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			//数据排序的要求，按照置顶和发帖时间降序，置顶在最上面
			return MyDBUtils.runner.query(sql, new  MapHandler(),todayDate+"%");
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	public void updateReadCount(String articleId){
		try{
			String sql="update tb_article set readCount=readCount+1 where articleId=?";
			
		 MyDBUtils.runner.update(sql,articleId);
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	
	public Article getArticleById(String articleId){
		try{
			String sql="select * from tb_article where articleId=?";
			return MyDBUtils.runner.query(sql, new BeanHandler<Article>(Article.class),articleId);
			
		 
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}

