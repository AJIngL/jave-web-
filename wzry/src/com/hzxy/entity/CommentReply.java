package com.hzxy.entity;

import java.io.Serializable;

public class CommentReply implements Serializable {
	
	private int replyId;
	private int userId;
	private int commentId;
	private String replyContent;
	private String replyTime;
	private String replyerName;
	private String picUrl;
	
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	public String getReplyerName() {
		return replyerName;
	}
	public void setReplyerName(String replyerName) {
		this.replyerName = replyerName;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public CommentReply(int replyId, int userId, int commentId, String replyContent, String replyTime,
			String replyerName, String picUrl) {
		super();
		this.replyId = replyId;
		this.userId = userId;
		this.commentId = commentId;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.replyerName = replyerName;
		this.picUrl = picUrl;
	}
	public CommentReply(int userId, int commentId, String replyContent, String replyTime, String replyerName,
			String picUrl) {
		super();
		this.userId = userId;
		this.commentId = commentId;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.replyerName = replyerName;
		this.picUrl = picUrl;
	}
	public CommentReply() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CommentReply [replyId=" + replyId + ", userId=" + userId + ", commentId=" + commentId
				+ ", replyContent=" + replyContent + ", replyTime=" + replyTime + ", replyerName=" + replyerName
				+ ", picUrl=" + picUrl + "]";
	}
	
}