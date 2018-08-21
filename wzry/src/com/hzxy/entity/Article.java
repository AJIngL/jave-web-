package com.hzxy.entity;

import java.io.Serializable;

/**
 * 帖子表
 * @author HZXY
 *
 */
public class Article implements Serializable {
	
	private int articleId;
	private int userId;
	private int zoneId;
	private String title;
	private String content;
	private String postTime;
	private String posterName;
	private String isTop;//0-不置顶；1-置顶
	private int commentCount;
	private int likeCount;
	private int readCount;
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
	public int getZoneId() {
		return zoneId;
	}
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public String getPosterName() {
		return posterName;
	}
	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}
	public String getIsTop() {
		return isTop;
	}
	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Article(int articleId, int userId, int zoneId, String title, String content, String postTime,
			String posterName, String isTop, int commentCount, int likeCount, int readCount) {
		super();
		this.articleId = articleId;
		this.userId = userId;
		this.zoneId = zoneId;
		this.title = title;
		this.content = content;
		this.postTime = postTime;
		this.posterName = posterName;
		this.isTop = isTop;
		this.commentCount = commentCount;
		this.likeCount = likeCount;
		this.readCount = readCount;
	}
	public Article(int userId, int zoneId, String title, String content, String postTime, String posterName,
			String isTop, int commentCount, int likeCount, int readCount) {
		super();
		this.userId = userId;
		this.zoneId = zoneId;
		this.title = title;
		this.content = content;
		this.postTime = postTime;
		this.posterName = posterName;
		this.isTop = isTop;
		this.commentCount = commentCount;
		this.likeCount = likeCount;
		this.readCount = readCount;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", userId=" + userId + ", zoneId=" + zoneId + ", title=" + title
				+ ", content=" + content + ", postTime=" + postTime + ", posterName=" + posterName + ", isTop=" + isTop
				+ ", commentCount=" + commentCount + ", likeCount=" + likeCount + ", readCount=" + readCount + "]";
	}
	
	

}


