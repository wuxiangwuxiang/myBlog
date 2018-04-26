package com.zzn.demo.pojo;

public class Comment {
	private Integer CommentID;
	private String CommentContent;
	private Integer ArticleID;
	private Integer UserID;
	

	
	public String getCommentContent() {
		return CommentContent;
	}
	public void setCommentContent(String commentContent) {
		CommentContent = commentContent;
	}
	
	public Integer getCommentID() {
		return CommentID;
	}
	public void setCommentID(Integer commentID) {
		CommentID = commentID;
	}
	
	public Integer getArticleID() {
		return ArticleID;
	}
	public void setArticleID(Integer articleID) {
		ArticleID = articleID;
	}
	
	public Integer getUserID() {
		return UserID;
	}
	public void setUserID(Integer userID) {
		UserID = userID;
	}
	

}
