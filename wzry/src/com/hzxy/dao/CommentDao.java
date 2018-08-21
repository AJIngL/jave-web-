package com.hzxy.dao;
import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hzxy.entity.Comment;
import com.hzxy.tool.MyDBUtils;

public class CommentDao {

	//向数据库插入评论
	public boolean addComment(Comment comment){
	
		try {
			
			String sql="INSERT INTO tb_comment(articleId,userid,commentContent,commentTime,commentUserName,commentStatus,picUrl) VALUES(?,?,?,?,?,?,?)";
			MyDBUtils.runner.update(sql,comment.getArticleId(),comment.getUserId(),
					comment.getCommentContent(),comment.getCommentTime(),comment.getCommentUserName(),
					comment.getCommentStatus(),comment.getPicUrl());
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return true;
	}
	
	public List<Comment> getCommentsByArticleId(int articleId){
		
	
		try {
			String sql="select *from tb_comment where articleId=? and commentStatus=0";
			return MyDBUtils.runner.query(sql, new BeanListHandler<Comment>(Comment.class),articleId);
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
