package com.zzn.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

	/* 分页，查询pageSize条评论 */
	@Select("select CommentID,UserID,CommentContent from comment where ArticleID = #{articleID} order by CommentID asc LIMIT #{page},#{pagesize}")
	public List<Comment> getFiveCommentList(@Param("articleID") Integer articleID, @Param("page") Integer page,
			@Param("pagesize") Integer pagesize);

	/* 分页，获取评论表总条数 */
	@Select("select count(*) from comment where ArticleID = #{articleID}")
	public int getCommentTotalCount(@Param("articleID") Integer articleID);

	/* 写评论添加评论 */
	@Insert("insert into Comment (CommentContent,UserID,ArticleID) values (#{CommentContent},#{UserID},#{ArticleID})")
	public int insertComment(@Param("CommentContent") String commentcontent, @Param("UserID") Integer userid,
			@Param("ArticleID") Integer articleid);
	
	/* 根据commentID删除评论 */
	@Delete("delete from Comment where CommentID = #{CommentID}")
	public void deleteCommentByID(@Param("CommentID") Integer CommentID);
}
