package com.hzxy.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hzxy.entity.CommentReply;
import com.hzxy.tool.MyDBUtils;

public class CommentRepleyDao {
	public void addCommentReply(CommentReply commentReply){
		String sql="INSERT INTO tb_comment_reply(userid,commentid,replyContent,replyTime,replyerName,picUrl) VALUES (?,?,?,?,?,?)";
		try {
			MyDBUtils.runner.update(sql,commentReply.getReplyId(),commentReply.getCommentId(),commentReply.getReplyContent(),
					commentReply.getReplyTime(),commentReply.getReplyerName(),commentReply.getPicUrl());
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	public List<CommentReply> getCommentReplyListByCommentId(int commentId){
		String sql="SELECT *FROM tb_comment_reply WHERE commentId=?";
		try {
			return MyDBUtils.runner.query(sql,new BeanListHandler<CommentReply>(CommentReply.class),commentId);
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
