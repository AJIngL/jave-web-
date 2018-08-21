package com.hzxy.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hzxy.dao.CommentRepleyDao;
import com.hzxy.entity.CommentReply;


public class ComentRepleyService {
	
	private CommentRepleyDao commentRepleyDao = new CommentRepleyDao();
	
	public void addCommentReply(CommentReply commentReply){
		commentReply.setReplyTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		commentRepleyDao.addCommentReply(commentReply);
	}
	
	
	
	
	public List<CommentReply> getCommentReplyListByCommentId(int commentId){
		return commentRepleyDao.getCommentReplyListByCommentId(commentId);
	}

}
