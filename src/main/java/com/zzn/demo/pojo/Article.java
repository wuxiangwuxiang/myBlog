package com.zzn.demo.pojo;



public class Article {
	private Integer ArticleID;
	private String articleName;
	private String ArticleContent;
	private Integer UserID;
	

	
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	
	public String getArticleContent() {
		return ArticleContent;
	}
	public void setArticleContent(String articleContent) {
		ArticleContent = articleContent;
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
