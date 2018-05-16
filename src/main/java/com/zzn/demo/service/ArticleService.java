package com.zzn.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zzn.demo.mapper.ArticleMapper;
import com.zzn.demo.pojo.Article;

@Service
public class ArticleService {

	@Autowired
	private ArticleMapper articleMapper;

	// 获取所有博客
	public List<Article> allArticleList() {
		List<Article> list = articleMapper.getArticleList();
		return list;
	}

	// 获有个人的所有博客列表,分页,每页显示pageSize条
	public List<Article> sbArticleList(Integer userID, Integer page, Integer pageSize) {
		List<Article> list1 = articleMapper.getSbArticleList(userID, page, pageSize);
		return list1;
	}

	// 获取某个人博客列表的条数
	public int sbArticleCount(Integer userID) {
		return articleMapper.getSbArticleCount(userID);
	}

	// 删除博客
	public int sbArticle(Integer articleID) {
		return articleMapper.deleteSbArticle(articleID);
	}

	// 获取，显示博客
	public Article article(Integer articleID) {
		return articleMapper.getArticle(articleID);
	}

	// 添加,写博客
	public int insertArt(String articleName, String articleContent, Integer userID) {
		return articleMapper.insertArticle(articleName, articleContent, userID);
	}

	// 添加文章后獲取id
	public int insertArt2() {
		return articleMapper.getNewArticleID();
	}

	// 更新博客
	public int updateArt(Integer aticleID, String articleName, String articleContent) {
		return articleMapper.updateArticle(aticleID, articleName, articleContent);
	}

	// 分页，查询10条博客
	public List<Article> fiveArticleList(Integer page, Integer pageSize) {
		List<Article> list = articleMapper.getFiveArticleList(page, pageSize);
		return list;
	}

	// 分页，获取博客表总条数
	public int artTotalCount() {
		return articleMapper.getArtTotalCount();
	}
}
