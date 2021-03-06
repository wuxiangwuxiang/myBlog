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

	// 获有个人的所有博客列表,分页,每页显示pageSize条
	@Select("select ArticleID ,ArticleName ,ArticleContent from Article where UserID = #{userID} order by ArticleID asc LIMIT #{page},#{pageSize}")
	public List<Article> getSbArticleList(@Param("userID") Integer UserID, @Param("page") Integer page,
			@Param("pageSize") Integer pageSize);

	// 获取某个人博客列表的条数
	@Select("select count(*) from Article where UserID =#{userID}")
	public int getSbArticleCount(@Param("userID") Integer UserID);

	// 删除博客
	@Delete("delete from Article where ArticleID = #{articleID}")
	public Integer deleteSbArticle(@Param("articleID") Integer ArticleID);

	// 获取,显示博客
	@Select("select ArticleName,ArticleContent from Article where ArticleID=#{articleID}")
	public Article getArticle(@Param("articleID") Integer ArticleID);

	// 添加,写博客
	@Insert("insert into Article (ArticleName,ArticleContent,UserID) values (#{ArticleName},#{ArticleContent},#{UserID})")
	public int insertArticle(@Param("ArticleName") String ArticleName, @Param("ArticleContent") String ArticleContent,
			@Param("UserID") Integer UserID);

	// 添加文章后获取id
	@Select("select last_insert_id()")
	public Integer getNewArticleID();

	// 更新博客
	@Update("UPDATE Article SET ArticleName =#{articleName}, ArticleContent = #{articleContent} WHERE ArticleID = #{articleID}")
	public int updateArticle(@Param("articleID") Integer ArticleID, @Param("articleName") String ArticleName,
			@Param("articleContent") String ArticleContent);

	// 分页，查询pageSize条博客
	@Select("select ArticleID ,ArticleName,ArticleContent ,UserID from Article order by ArticleID asc LIMIT #{page},#{pageSize}")
	public List<Article> getFiveArticleList(@Param("page") Integer page, @Param("pageSize") Integer pageSize);

	// 分页，获取博客表总条数
	@Select("select count(*) from Article")
	public int getArtTotalCount();
}
