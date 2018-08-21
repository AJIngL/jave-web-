package com.hzxy.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import com.hzxy.dao.CommentDao;
import com.hzxy.entity.Comment;

public class CommentService {
	
	private CommentDao commentDao=new CommentDao();
	
	public boolean addComment(Comment comment){
		comment.setCommentTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return commentDao.addComment(comment);
	}
		
	
	public List<Comment> getCommentsByArticleId(int articleId){
		return commentDao.getCommentsByArticleId(articleId);
	}

}
