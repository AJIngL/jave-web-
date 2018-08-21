package com.hzxy.entity;

import java.io.Serializable;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Comment implements	Serializable {
	
	private int commentId;
	private int articleId;
	private int userId;
	private String commentContent;
	private String commentTime;
	private String commentUserName;
	private int commentStatus;//1代表屏蔽，0代表显示（默认）
	private String picUrl;
	
	private List<CommentReply> commentReplies;
	
	public  List<CommentReply> getCommentReplies() {
		return commentReplies;
	}
	public void setCommentReplies(List<CommentReply> commentReplies) {
		this.commentReplies = commentReplies;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public String getCommentUserName() {
		return commentUserName;
	}
	public void setCommentUserName(String commentUserName) {
		this.commentUserName = commentUserName;
	}
	public int getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(int commentStatus) {
		this.commentStatus = commentStatus;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Comment(int commentId, int articleId, int userId, String commentContent, String commentTime,
			String commentUserName, int commentStatus, String picUrl) {
		super();
		this.commentId = commentId;
		this.articleId = articleId;
		this.userId = userId;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
		this.commentUserName = commentUserName;
		this.commentStatus = commentStatus;
		this.picUrl = picUrl;
		
	}
	public Comment(int articleId, int userId, String commentContent, String commentTime, String commentUserName,
			int commentStatus, String picUrl) {
		super();
		this.articleId = articleId;
		this.userId = userId;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
		this.commentUserName = commentUserName;
		this.commentStatus = commentStatus;
		this.picUrl = picUrl;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", articleId=" + articleId + ", userId=" + userId
				+ ", commentContent=" + commentContent + ", commentTime=" + commentTime + ", commentUserName="
				+ commentUserName + ", commentStatus=" + commentStatus + ", picUrl=" + picUrl + "]";
	}
	
	

}


