package com.zzn.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zzn.demo.pojo.Article;

@Mapper
public interface ArticleMapper {

	// 获取所有博客
	@Select("select ArticleID ,ArticleName,ArticleContent ,UserID from Article")
	public List<Article> getArticleList();

	// 获取有个人的所有博客
	@Select("select ArticleID ,ArticleName ,ArticleContent from Article where UserID = #{userID}")
	public List<Article> getSbArticleList(@Param("userID") Integer UserID);
	
	//删除博客
	@Delete("delete from Article where ArticleID = #{articleID}")
	public Integer deleteSbArticle(@Param("articleID") Integer ArticleID);
	
	//获取,显示博客
	@Select("select ArticleName,ArticleContent from Article where ArticleID=#{articleID}")
	public Article getArticle(@Param("articleID") Integer ArticleID);
	
	//添加,写博客
	@Insert("insert into Article (ArticleName,ArticleContent,UserID) values (#{ArticleName},#{ArticleContent},#{UserID})")
	public int insertArticle(@Param("ArticleName") String ArticleName,@Param("ArticleContent") String ArticleContent,@Param("UserID") Integer UserID);
	
	//更新博客
	@Update("UPDATE Article SET ArticleContent = #{articleContent} WHERE ArticleID = #{articleID}")
	public int updateArticle(@Param("articleID") Integer ArticleID,@Param("articleContent") String ArticleContent);
}
