package com.zzn.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zzn.demo.pojo.Article;
import com.zzn.demo.service.ArticleService;

@RestController
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	// 获取所有博客
	@RequestMapping(value = "/allArticleList", method = RequestMethod.GET)
	public List<Article> allArticleLsit() {
		List<Article> list = articleService.allArticleList();
		return list;
	}

	// 获有个人的所有博客列表,分页,每页显示pageSize条
	@RequestMapping(value = "/sbArticleList", method = RequestMethod.GET)
	public List<Article> sbArticleList(
			@RequestParam(value = "page") Integer page, @RequestParam(value = "pagesize") Integer pagesize,
			HttpSession session) {
		Integer id = (Integer) session.getAttribute("userid");
		// System.out.println(id);
		List<Article> list1 = articleService.sbArticleList(id, page, pagesize);
		return list1;
	}

	// 获取某个人博客列表的条数
	@RequestMapping(value = "/sbArticleCount", method = RequestMethod.GET)
	public int sbArticleCount(HttpSession session) {
		Integer id = (Integer) session.getAttribute("userid");
		return articleService.sbArticleCount(id);
	}
	
	// 删除博客
	@RequestMapping(value = "/sbArticle", method = RequestMethod.GET)
	public int sbArticle(@RequestParam(value = "articleid", required = false) Integer articleid, HttpSession session) {
		// System.out.println(articleid);
		return articleService.sbArticle(articleid);
	}

	// 获取，显示博客
	@RequestMapping(value = "/article", method = RequestMethod.GET)
	public Article article(@RequestParam(value = "articleid", required = false) Integer articleid) {
		// System.out.println(articleid);
		return articleService.article(articleid);
	}

	// 添加,写博客
	@RequestMapping(value = "/insertArt", method = RequestMethod.GET)
	public int insertArt(@RequestParam(value = "articlename", required = false) String articlename,
			@RequestParam(value = "articlecontent", required = false) String articlecontent,
			@RequestParam(value = "userid", required = false) Integer userid, HttpSession session) {
		userid = (Integer) session.getAttribute("userid");
		// System.out.println(userid);
		// System.out.println(userid+articlecontent+articlename);
		/*
		 * Integer artid= articleService.insertArt2(); System.out.println(artid);
		 */
		return articleService.insertArt(articlename, articlecontent, userid);
	}

	// 添加文章后获取id
	@RequestMapping(value = "/insert2", method = RequestMethod.GET)
	public int insert2() {
		return articleService.insertArt2();
	}

	// 更新博客
	@RequestMapping(value = "/updateArt", method = RequestMethod.GET)
	public int updateArt(@RequestParam(value = "articleid", required = false) Integer articleid,
			@RequestParam(value = "articlename", required = false) String articlename,
			@RequestParam(value = "articlecontent", required = false) String articlecontent) {
		// System.out.println(articleid);
		// System.out.println(articlename);
		// System.out.println(articlecontent);
		return articleService.updateArt(articleid, articlename, articlecontent);
	}

	// 分页，查询10条博客
	@RequestMapping(value = "/fiveAllArticleList", method = RequestMethod.GET)
	public List<Article> fiveArticleList(@RequestParam(value = "page") Integer page,
			@RequestParam(value = "pagesize") Integer pagesize) {
		List<Article> list = articleService.fiveArticleList(page, pagesize);
		return list;
	}

	// 分页，获取博客表总条数
	@RequestMapping(value = "/artTotalCount", method = RequestMethod.GET)
	public int artTotalCount() {
		return articleService.artTotalCount();
	}
}
