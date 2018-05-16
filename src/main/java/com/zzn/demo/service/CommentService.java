package com.zzn.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzn.demo.mapper.CommentMapper;
import com.zzn.demo.pojo.Article;
import com.zzn.demo.pojo.Comment;

@Service
public class CommentService {

	@Autowired
	private CommentMapper commentMapper;

	/* 根据articleID删除评论 */
	public int artComment(Integer articleID) {
		return commentMapper.deleteArtComment(articleID);
	}

	/* 根据articleID查看博客的评论 */
	public List<Comment> searchArticleComment(Integer articleID) {
		List<Comment> list = commentMapper.getArticleComment(articleID);
		return list;
	}

	/* 分页，查询pageSize条评论 */
	public List<Comment> fiveCommentList(Integer articleid, Integer page, Integer pagesize) {
		List<Comment> list = commentMapper.getFiveCommentList(articleid, page, pagesize);
		return list;
	}

	/* 分页，获取评论表总条数 */
	public int commentTotalCount(Integer articleid) {
		return commentMapper.getCommentTotalCount(articleid);
	}
	
	/* 写评论添加评论 */
	public int insertComt(String commentcontent,Integer userid,Integer articleid) {
		return commentMapper.insertComment(commentcontent, userid, articleid);
	}
	
	/* 根据commentID删除评论 */
	public void deleteCmtByid(Integer CommentID) {
		commentMapper.deleteCommentByID(CommentID);
	}
}
