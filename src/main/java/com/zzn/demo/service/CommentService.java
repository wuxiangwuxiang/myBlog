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
	
	//根据articleID删除评论
	public int artComment(Integer articleID) {
		return commentMapper.deleteArtComment(articleID);
	}
	
	//根据articleID查看博客的评论
	public List<Comment> searchArticleComment(Integer articleID) {
		List<Comment> list = commentMapper.getArticleComment(articleID); 
		return list;
	}
}
