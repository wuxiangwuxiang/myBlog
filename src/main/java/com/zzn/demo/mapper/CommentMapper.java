package com.zzn.demo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zzn.demo.pojo.Comment;

@Mapper
public interface CommentMapper {

	// 根据articleID删除评论
	@Delete("delete from Comment where ArticleID = #{articleID}")
	public Integer deleteArtComment(@Param("articleID") Integer ArticleID);

	// 根据articleID查看博客的评论
	@Select("select CommentID ,CommentContent ,ArticleID ,UserID from Comment where ArticleID = #{articleID}")
	public List<Comment> getArticleComment(@Param("articleID") Integer ArticleID);
}
