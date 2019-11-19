package com.briup.apps.tyd.service;

import java.util.List;

import com.briup.apps.tyd.bean.Article;
import com.briup.apps.tyd.bean.extend.ArticleExtend;
import com.briup.apps.tyd.utils.CustomerException;

public interface IArticleService {
	List<Article> findAll();
	List<ArticleExtend> cascadeFindAll();
	ArticleExtend findById(long id);
	void saveOrUpdate(Article article) throws CustomerException;
	void deleteById(long id) throws CustomerException;
}
